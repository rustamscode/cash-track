package cash_track.dto.request;

import cash_track.entity.enums.CurrencyType;
import cash_track.entity.enums.TransactionType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class TransactionUpdateRq {

  @Positive
  @Digits(integer = 10, fraction = 2)
  private BigDecimal amount;

  private CurrencyType currency;

  private TransactionType type;

  @Size(max = 1000)
  private String comment;

  @Size(min = 3, max = 128)
  private String categoryName;
}
