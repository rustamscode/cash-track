package cash_track.search.strategy;

import cash_track.entity.enums.TransactionType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

public class TransactionTypePredicateStrategy implements PredicateStrategy<TransactionType> {

  @Override
  public Predicate getEqualsPredicate(Expression<TransactionType> expression, TransactionType value, CriteriaBuilder cb) {
    return cb.equal(expression, value);
  }

  @Override
  public Predicate getNotEqualsPredicate(Expression<TransactionType> expression, TransactionType value, CriteriaBuilder cb) {
    return cb.notEqual(expression, value);
  }
}
