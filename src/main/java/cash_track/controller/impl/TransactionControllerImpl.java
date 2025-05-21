package cash_track.controller.impl;

import cash_track.controller.TransactionController;
import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.request.TransactionSearchRq;
import cash_track.dto.request.TransactionUpdateRq;
import cash_track.dto.response.ResponseDto;
import cash_track.dto.response.TransactionRs;
import cash_track.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static cash_track.util.message.ExceptionMessageUtil.AUTHENTICATION_CREDENTIALS_NOT_FOUND;
import static cash_track.util.message.ResponseMessageUtil.TRANSACTIONS_FETCHED;
import static cash_track.util.message.ResponseMessageUtil.TRANSACTION_CREATED;
import static cash_track.util.message.ResponseMessageUtil.TRANSACTION_DELETED;
import static cash_track.util.message.ResponseMessageUtil.TRANSACTION_UPDATED;

@RestController
@RequiredArgsConstructor
public class TransactionControllerImpl implements TransactionController {

  private final TransactionService transactionService;

  @Override
  public ResponseDto<UUID> createTransaction(TransactionCreateRq request) {
    return ResponseDto.<UUID>builder()
        .message(TRANSACTION_CREATED)
        .data(transactionService.createUserTransaction(request))
        .build();
  }

  @Override
  public ResponseDto<Page<TransactionRs>> getTransactions(UserDetails userDetails, TransactionSearchRq request, Pageable pageable) {
    String username = userDetails.getUsername();
    if (StringUtils.isBlank(username)) {
      throw new AuthenticationCredentialsNotFoundException(AUTHENTICATION_CREDENTIALS_NOT_FOUND);
    }

    return ResponseDto.<Page<TransactionRs>>builder()
        .message(TRANSACTIONS_FETCHED)
        .data(transactionService.getTransactions(username, request, pageable))
        .build();
  }

  @Override
  public ResponseDto<TransactionRs> updateTransaction(UUID id, TransactionUpdateRq request) {
    return ResponseDto.<TransactionRs>builder()
        .message(TRANSACTION_UPDATED)
        .data(transactionService.updateTransaction(id, request))
        .build();
  }

  @Override
  public ResponseDto<Void> deleteTransaction(UUID id) {
    transactionService.deleteTransaction(id);

    return ResponseDto.<Void>builder()
        .message(TRANSACTION_DELETED)
        .build();
  }
}