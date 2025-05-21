package cash_track.search.strategy;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

import java.math.BigDecimal;

public class BigDecimalPredicateStrategy implements PredicateStrategy<BigDecimal> {

  @Override
  public Predicate getEqualsPredicate(Expression<BigDecimal> expression, BigDecimal value, CriteriaBuilder cb) {
    return cb.equal(expression, value);
  }

  @Override
  public Predicate getNotEqualsPredicate(Expression<BigDecimal> expression, BigDecimal value, CriteriaBuilder cb) {
    return cb.notEqual(expression, value);
  }

  @Override
  public Predicate getGreaterThanPredicate(Expression<BigDecimal> expression, BigDecimal value, CriteriaBuilder cb) {
    return cb.greaterThan(expression, value);
  }

  @Override
  public Predicate getGreaterThanOrEqualPredicate(Expression<BigDecimal> expression, BigDecimal value, CriteriaBuilder cb) {
    return cb.greaterThanOrEqualTo(expression, value);
  }

  @Override
  public Predicate getLessThanPredicate(Expression<BigDecimal> expression, BigDecimal value, CriteriaBuilder cb) {
    return cb.lessThan(expression, value);
  }

  @Override
  public Predicate getLessThanOrEqualPredicate(Expression<BigDecimal> expression, BigDecimal value, CriteriaBuilder cb) {
    return cb.lessThanOrEqualTo(expression, value);
  }
}
