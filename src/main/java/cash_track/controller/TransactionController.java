package cash_track.controller;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.request.TransactionExportRq;
import cash_track.dto.request.TransactionSearchRq;
import cash_track.dto.request.TransactionUpdateRq;
import cash_track.dto.response.ExportTaskRs;
import cash_track.dto.response.ResponseDto;
import cash_track.dto.response.TransactionRs;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;


@RequestMapping("/transactions")
@Tag(name = "Transaction management API")
public interface TransactionController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Create a transaction")
  ResponseDto<UUID> createTransaction(@RequestBody @Valid TransactionCreateRq request);

  @PostMapping("/search")
  @Operation(summary = "Get transactions")
  ResponseDto<Page<TransactionRs>> getTransactions(@AuthenticationPrincipal UserDetails userDetails,
                                                   @RequestBody @Valid TransactionSearchRq request,
                                                   @PageableDefault Pageable pageable);

  @PatchMapping("/{id}")
  @Operation(summary = "Update transaction")
  ResponseDto<TransactionRs> updateTransaction(@PathVariable UUID id, @RequestBody @Valid TransactionUpdateRq request);

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Delete transaction")
  ResponseDto<Void> deleteTransaction(@PathVariable UUID id);

  @PostMapping("/export/initiate")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @Operation(summary = "Export transactions")
  ResponseDto<ExportTaskRs> initiateTransactionsExport(@RequestBody @Valid TransactionExportRq request);
}
