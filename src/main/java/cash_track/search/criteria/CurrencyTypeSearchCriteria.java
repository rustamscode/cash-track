package cash_track.search.criteria;

import cash_track.entity.enums.CurrencyType;
import cash_track.search.enums.SearchOperation;
import cash_track.search.strategy.CurrencyTypePredicateStrategy;
import cash_track.search.strategy.PredicateStrategy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CurrencyTypeSearchCriteria implements SearchCriteria<CurrencyType> {

  private final PredicateStrategy<CurrencyType> STRATEGY = new CurrencyTypePredicateStrategy();

  @NotBlank
  private String field;

  @NotNull
  private CurrencyType value;

  @NotNull
  private SearchOperation operation;

  @Override
  public PredicateStrategy<CurrencyType> getStrategy() {
    return STRATEGY;
  }

  @Override
  public String getField() {
    return field;
  }

  @Override
  public CurrencyType getValue() {
    return value;
  }

  @Override
  public SearchOperation getOperation() {
    return operation;
  }
}
