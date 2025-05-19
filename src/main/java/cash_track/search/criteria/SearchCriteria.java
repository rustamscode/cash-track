package cash_track.search.criteria;

import cash_track.entity.BaseEntity;
import cash_track.entity.Transaction;
import cash_track.search.enums.SearchOperation;
import cash_track.search.enums.SearchOption;
import cash_track.search.strategy.PredicateStrategy;
import cash_track.util.constant.JsonConstant;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import jakarta.validation.constraints.NotNull;

@JsonTypeInfo(
    use = Id.NAME,
    property = JsonConstant.FIELD,
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BigDecimalSearchCriteria.class, names = {Transaction.Fields.amount}),
    @JsonSubTypes.Type(value = CurrencyTypeSearchCriteria.class, names = {Transaction.Fields.currency}),
    @JsonSubTypes.Type(value = TransactionTypeSearchCriteria.class, names = {Transaction.Fields.type}),
    @JsonSubTypes.Type(value = TransactionStatusSearchCriteria.class, names = {Transaction.Fields.status}),
    @JsonSubTypes.Type(value = UuidSearchCriteria.class, names = {Transaction.Fields.category + "." + BaseEntity.Fields.id}),
})
public interface SearchCriteria<T> {

  @NotNull
  PredicateStrategy<T> getStrategy();

  @NotNull
  String getField();

  @NotNull
  T getValue();

  @NotNull
  SearchOperation getOperation();

  SearchOption getOption();
}
