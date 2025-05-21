package cash_track.search.criteria;

import cash_track.entity.enums.TransactionType;
import cash_track.search.enums.SearchOperation;
import cash_track.search.strategy.PredicateStrategy;
import cash_track.search.strategy.TransactionTypePredicateStrategy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransactionTypeSearchCriteria implements SearchCriteria<TransactionType> {

  private final PredicateStrategy<TransactionType> STRATEGY = new TransactionTypePredicateStrategy();

  @NotBlank
  private String field;

  @NotNull
  private TransactionType value;

  @NotNull
  private SearchOperation operation;

  @Override
  public PredicateStrategy<TransactionType> getStrategy() {
    return STRATEGY;
  }

  @Override
  public String getField() {
    return field;
  }

  @Override
  public TransactionType getValue() {
    return value;
  }

  @Override
  public SearchOperation getOperation() {
    return operation;
  }
}