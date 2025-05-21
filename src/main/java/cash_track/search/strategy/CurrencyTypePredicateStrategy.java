package cash_track.search.strategy;

import cash_track.entity.enums.CurrencyType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

public class CurrencyTypePredicateStrategy implements PredicateStrategy<CurrencyType> {

  @Override
  public Predicate getEqualsPredicate(Expression<CurrencyType> expression, CurrencyType value, CriteriaBuilder cb) {
    return cb.equal(expression, value);
  }

  @Override
  public Predicate getNotEqualsPredicate(Expression<CurrencyType> expression, CurrencyType value, CriteriaBuilder cb) {
    return cb.notEqual(expression, value);
  }
}
