package cash_track.service;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.response.TransactionRs;
import cash_track.security.user.DefaultUserDetails;

import java.util.List;
import java.util.UUID;


public interface TransactionService {

  UUID createTransaction(TransactionCreateRq transactionCreateRq, DefaultUserDetails userDetails);

  List<TransactionRs> getTransactions(DefaultUserDetails userDetails);
}
