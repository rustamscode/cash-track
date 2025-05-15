package cash_track.controller;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.request.TransactionUpdateRq;
import cash_track.dto.response.ResponseDto;
import cash_track.dto.response.TransactionRs;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;


@RequestMapping("/transactions")
@Tag(name = "Transaction management API")
public interface TransactionController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Create a transaction")
  ResponseDto<UUID> createTransaction(@RequestBody @Valid TransactionCreateRq request);

  @GetMapping
  @Operation(summary = "Get transactions")
  ResponseDto<List<TransactionRs>> getUserTransactions();

  @PatchMapping("/{id}")
  @Operation(summary = "Update transaction")
  ResponseDto<TransactionRs> updateTransaction(@PathVariable UUID id, @RequestBody @Valid TransactionUpdateRq request);
}
