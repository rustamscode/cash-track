package cash_track.dto.response;

import cash_track.entity.enums.CurrencyType;
import cash_track.entity.enums.TransactionStatus;
import cash_track.entity.enums.TransactionType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class TransactionRs {

  private BigDecimal amount;
  private CurrencyType currency;
  private TransactionType type;
  private String comment;
  private TransactionStatus status;
  private CategoryRs category;
}
