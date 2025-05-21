package cash_track.search.strategy;

import cash_track.search.enums.SearchOperation;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

import static cash_track.util.message.ExceptionMessageUtil.SEARCH_OPERATION_INVALID_FOR_VALUE;

public interface PredicateStrategy<T> {

  default Predicate getContainsPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.CONTAINS.name(), value)
    );
  }

  default Predicate getNotContainsPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.NOT_CONTAINS.name(), value)
    );
  }

  default Predicate getEqualsPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.EQUAL.name(), value)
    );
  }

  default Predicate getNotEqualsPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.NOT_EQUAL, value)
    );
  }

  default Predicate getBeginsWithPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.BEGINS_WITH, value)
    );
  }

  default Predicate getNotBeginsWithPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.NOT_BEGIN_WITH, value)
    );
  }

  default Predicate getEndsWithPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.ENDS_WITH, value)
    );
  }

  default Predicate getNotEndsWithPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.NOT_END_WITH, value)
    );
  }

  default Predicate getGreaterThanPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.GREATER, value)
    );
  }

  default Predicate getGreaterThanOrEqualPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.GREATER_OR_EQUAL, value)
    );
  }

  default Predicate getLessThanPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.LESS, value)
    );
  }

  default Predicate getLessThanOrEqualPredicate(Expression<T> expression, T value, CriteriaBuilder cb) throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        String.format(SEARCH_OPERATION_INVALID_FOR_VALUE, SearchOperation.LESS_OR_EQUAL, value)
    );
  }
}