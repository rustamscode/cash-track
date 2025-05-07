package cash_track.controller.impl;

import cash_track.controller.TransactionController;
import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.response.ResponseDto;
import cash_track.dto.response.TransactionRs;
import cash_track.security.user.DefaultUserDetails;
import cash_track.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static cash_track.util.ResponseMessageUtil.TRANSACTIONS_FETCHED;
import static cash_track.util.ResponseMessageUtil.TRANSACTION_CREATED;

@RestController
@RequiredArgsConstructor
public class TransactionControllerImpl implements TransactionController {

  private final TransactionService transactionService;

  @Override
  public ResponseDto<UUID> createTransaction(TransactionCreateRq transactionCreateRq, DefaultUserDetails userDetails) {
    return ResponseDto.<UUID>builder()
        .message(TRANSACTION_CREATED)
        .data(transactionService.createTransaction(transactionCreateRq, userDetails))
        .build();
  }

  @Override
  public ResponseDto<List<TransactionRs>> getTransactions(DefaultUserDetails userDetails) {
    return ResponseDto.<List<TransactionRs>>builder()
        .message(TRANSACTIONS_FETCHED)
        .data(transactionService.getTransactions(userDetails))
        .build();
  }
}
