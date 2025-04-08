package cash_track.dto;

import cash_track.persistance.entity.enums.CurrencyType;
import cash_track.persistance.entity.enums.TransactionType;
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
}
