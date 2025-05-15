package cash_track.service;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.request.TransactionUpdateRq;
import cash_track.dto.response.TransactionRs;

import java.util.List;
import java.util.UUID;


public interface TransactionService {

  UUID createUserTransaction(TransactionCreateRq request);

  List<TransactionRs> getUserTransactions();

  TransactionRs updateTransaction(UUID transactionId, TransactionUpdateRq request);
}
