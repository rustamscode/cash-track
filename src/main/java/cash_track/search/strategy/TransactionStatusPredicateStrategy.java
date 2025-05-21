package cash_track.search.strategy;

import cash_track.entity.enums.TransactionStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

public class TransactionStatusPredicateStrategy implements PredicateStrategy<TransactionStatus> {

  @Override
  public Predicate getEqualsPredicate(Expression<TransactionStatus> expression, TransactionStatus value, CriteriaBuilder cb) {
    return cb.equal(expression, value);
  }

  @Override
  public Predicate getNotEqualsPredicate(Expression<TransactionStatus> expression, TransactionStatus value, CriteriaBuilder cb) {
    return cb.notEqual(expression, value);
  }
}
