package cash_track.search.specification;

import cash_track.search.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface SpecificationBuilder<T> {

  default Specification<T> buildSearchCriteriaSpecification(List<SearchCriteria> criteriaList) {
    List<Specification<T>> specifications = criteriaList.stream()
        .map(this::toSpecification)
        .toList();

    return Specification.allOf(specifications);
  }

  default Specification<T> toSpecification(SearchCriteria criteria) {
    return (root, query, cb) ->
        switch (criteria.getOperation()) {
          case CONTAINS -> criteria.getStrategy()
              .getContainsPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case NOT_CONTAINS -> criteria.getStrategy()
              .getNotContainsPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case EQUAL -> criteria.getStrategy()
              .getEqualsPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case NOT_EQUAL -> criteria.getStrategy()
              .getNotEqualsPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case BEGINS_WITH -> criteria.getStrategy()
              .getBeginsWithPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case NOT_BEGIN_WITH -> criteria.getStrategy()
              .getNotBeginsWithPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case ENDS_WITH -> criteria.getStrategy()
              .getEndsWithPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case NOT_END_WITH -> criteria.getStrategy()
              .getNotEndsWithPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case GREATER -> criteria.getStrategy()
              .getGreaterThanPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case GREATER_OR_EQUAL -> criteria.getStrategy()
              .getGreaterThanOrEqualPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case LESS -> criteria.getStrategy()
              .getLessThanPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
          case LESS_OR_EQUAL -> criteria.getStrategy()
              .getLessThanOrEqualPredicate(root.get(criteria.getField()), criteria.getValue(), cb);
        };
  }
}