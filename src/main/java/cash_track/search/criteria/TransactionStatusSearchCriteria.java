package cash_track.search.criteria;

import cash_track.entity.enums.TransactionStatus;
import cash_track.search.enums.SearchOperation;
import cash_track.search.strategy.PredicateStrategy;
import cash_track.search.strategy.TransactionStatusPredicateStrategy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransactionStatusSearchCriteria implements SearchCriteria<TransactionStatus> {

  private final PredicateStrategy<TransactionStatus> STRATEGY = new TransactionStatusPredicateStrategy();

  @NotBlank
  private String field;

  @NotNull
  private TransactionStatus value;

  @NotNull
  private SearchOperation operation;

  @Override
  public PredicateStrategy<TransactionStatus> getStrategy() {
    return STRATEGY;
  }

  @Override
  public String getField() {
    return field;
  }

  @Override
  public TransactionStatus getValue() {
    return value;
  }

  @Override
  public SearchOperation getOperation() {
    return operation;
  }
}
