package cash_track.search.criteria;

import cash_track.search.enums.SearchOperation;
import cash_track.search.strategy.BigDecimalPredicateStrategy;
import cash_track.search.strategy.PredicateStrategy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class BigDecimalSearchCriteria implements SearchCriteria<BigDecimal> {

  private final PredicateStrategy<BigDecimal> STRATEGY = new BigDecimalPredicateStrategy();

  @NotBlank
  private String field;

  @NotNull
  @Positive
  private BigDecimal value;

  @NotNull
  private SearchOperation operation;

  @Override
  public PredicateStrategy<BigDecimal> getStrategy() {
    return STRATEGY;
  }

  @Override
  public String getField() {
    return field;
  }

  @Override
  public BigDecimal getValue() {
    return value;
  }

  @Override
  public SearchOperation getOperation() {
    return operation;
  }
}
