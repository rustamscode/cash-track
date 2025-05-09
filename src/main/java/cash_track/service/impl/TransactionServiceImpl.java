package cash_track.service.impl;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.response.TransactionRs;
import cash_track.entity.Transaction;
import cash_track.entity.User;
import cash_track.mapper.TransactionMapper;
import cash_track.repository.TransactionRepository;
import cash_track.security.user.DefaultUserDetails;
import cash_track.service.TransactionService;
import cash_track.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static cash_track.util.LogMessageUtil.SAVING_IN_DB_LOG;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  private final UserService userService;

  private final TransactionMapper transactionMapper;

  @Override
  @Transactional
  public UUID createTransaction(TransactionCreateRq transactionCreateRq, DefaultUserDetails userDetails) {
    log.info("Transaction creation has started");
    Transaction transaction = transactionMapper.mapToTransaction(transactionCreateRq);
    String username = userDetails.getUsername();
    User user = userService.getUserByUsername(username);
    transaction.setUser(user);

    UUID transactionId = transactionRepository.save(transaction).getId();
    log.info(SAVING_IN_DB_LOG, transaction);

    return transactionId;
  }

  @Override
  @Transactional(readOnly = true)
  public List<TransactionRs> getTransactions(DefaultUserDetails userDetails) {
    String username = userDetails.getUsername();
    log.info("Fetching transactions by username from DB");
    List<Transaction> transactions = transactionRepository.findTransactionsByUserUsername(username);

    log.info("Mapping transaction list into transaction response-dto list");
    return transactions.stream()
        .map(transactionMapper::mapToTransactionRs)
        .toList();
  }
}