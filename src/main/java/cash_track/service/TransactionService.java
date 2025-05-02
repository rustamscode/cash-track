package cash_track.service;

import cash_track.dto.request.TransactionCreateRq;

import java.util.UUID;


public interface TransactionService {

  UUID create(String username, TransactionCreateRq transactionCreateRq);
}
