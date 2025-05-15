package cash_track.controller.impl;

import cash_track.controller.TransactionController;
import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.request.TransactionUpdateRq;
import cash_track.dto.response.ResponseDto;
import cash_track.dto.response.TransactionRs;
import cash_track.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static cash_track.util.ResponseMessageUtil.TRANSACTIONS_FETCHED;
import static cash_track.util.ResponseMessageUtil.TRANSACTION_CREATED;
import static cash_track.util.ResponseMessageUtil.TRANSACTION_UPDATED;

@RestController
@RequiredArgsConstructor
public class TransactionControllerImpl implements TransactionController {

  private final TransactionService transactionService;

  @Override
  public ResponseDto<UUID> createTransaction(TransactionCreateRq transactionCreateRq) {
    return ResponseDto.<UUID>builder()
        .message(TRANSACTION_CREATED)
        .data(transactionService.createUserTransaction(transactionCreateRq))
        .build();
  }

  @Override
  public ResponseDto<List<TransactionRs>> getUserTransactions() {
    return ResponseDto.<List<TransactionRs>>builder()
        .message(TRANSACTIONS_FETCHED)
        .data(transactionService.getUserTransactions())
        .build();
  }

  @Override
  public ResponseDto<TransactionRs> updateTransaction(UUID id, TransactionUpdateRq request) {
    return ResponseDto.<TransactionRs>builder()
        .message(TRANSACTION_UPDATED)
        .data(transactionService.updateTransaction(id, request))
        .build();
  }
}
