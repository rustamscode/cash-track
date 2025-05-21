package cash_track.service.impl;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.request.TransactionSearchRq;
import cash_track.dto.request.TransactionUpdateRq;
import cash_track.dto.response.TransactionRs;
import cash_track.entity.Transaction;
import cash_track.entity.User;
import cash_track.exception.TransactionNotFoundException;
import cash_track.mapper.TransactionMapper;
import cash_track.repository.TransactionRepository;
import cash_track.search.specification.TransactionSpecificationBuilder;
import cash_track.service.TransactionService;
import cash_track.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static cash_track.util.message.ExceptionMessageUtil.TRANSACTION_NOT_FOUND;
import static cash_track.util.message.LogMessageUtil.SAVING_IN_DB_LOG;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  private final TransactionSpecificationBuilder transactionSpecificationBuilder;

  private final UserService userService;

  private final TransactionMapper transactionMapper;

  @Override
  @Transactional
  public UUID createUserTransaction(TransactionCreateRq request) {
    log.info("Transaction creation has started");
    Transaction transaction = transactionMapper.mapToTransaction(request);
    User user = userService.getCurrentUser();
    transaction.setUser(user);

    UUID transactionId = transactionRepository.save(transaction).getId();
    log.info(SAVING_IN_DB_LOG, transaction);

    return transactionId;
  }

  @Override
  @Transactional(readOnly = true)
  public Page<TransactionRs> getTransactions(String username, TransactionSearchRq request, Pageable pageable) {
    Specification<Transaction> usernameSpec = transactionSpecificationBuilder.buildUsernameSpecification(username);
    Specification<Transaction> specification = transactionSpecificationBuilder.buildSearchCriteriaSpecification(request.getCriteriaList())
        .and(usernameSpec);

    log.info("Fetching transactions by username from DB");
    Page<Transaction> transactions = transactionRepository.findAll(specification, pageable);

    log.info("Mapping transaction list into transaction response-dto list");
    return transactions.map(transactionMapper::mapToTransactionRs);
  }

  @Override
  @Transactional
  public TransactionRs updateTransaction(UUID transactionId, TransactionUpdateRq request) {
    log.info("Transaction update has started");
    Transaction transaction = getTransactionById(transactionId);
    transactionMapper.updateTransaction(transaction, request);

    log.info("Transaction with id {} has been updated", transactionId);

    return transactionMapper.mapToTransactionRs(transaction);
  }

  @Override
  @Transactional
  public void deleteTransaction(UUID transactionId) {
    transactionRepository.delete(getTransactionById(transactionId));
    log.info("Transaction with id {} has been deleted", transactionId);
  }

  @Transactional(readOnly = true)
  public Transaction getTransactionById(UUID transactionId) {
    return transactionRepository.findById(transactionId)
        .orElseThrow(() -> new TransactionNotFoundException(String.format(TRANSACTION_NOT_FOUND, transactionId)));
  }
}