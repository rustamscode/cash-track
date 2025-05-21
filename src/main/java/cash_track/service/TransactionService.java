package cash_track.service;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.request.TransactionSearchRq;
import cash_track.dto.request.TransactionUpdateRq;
import cash_track.dto.response.TransactionRs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface TransactionService {

  UUID createUserTransaction(TransactionCreateRq request);

  Page<TransactionRs> getTransactions(String username, TransactionSearchRq request, Pageable pageable);

  TransactionRs updateTransaction(UUID transactionId, TransactionUpdateRq request);

  void deleteTransaction(UUID id);
}
