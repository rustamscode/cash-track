package cash_track.controller;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.response.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;


@Validated
@RequestMapping("/transactions")
@Tag(name = "Loadout management API")
public interface TransactionController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Create a transaction")
  ResponseDto<UUID> createTransaction(@AuthenticationPrincipal @NotNull String username,
                                      @RequestBody @NotNull @Valid TransactionCreateRq transactionCreateRq);
}
