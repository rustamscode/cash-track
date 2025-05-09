package cash_track.dto.request;

import cash_track.entity.enums.CurrencyType;
import cash_track.entity.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@Getter
@Builder
public class TransactionCreateRq {

  @NotNull
  @Positive
  private BigDecimal amount;

  @NotNull
  private CurrencyType currency;

  @NotNull
  private TransactionType type;

  @Nullable
  @Size(max = 1000)
  private String comment;

  @NotNull
  @Size(max = 255)
  private String categoryName;
}
