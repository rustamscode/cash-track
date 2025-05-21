package cash_track.search.specification;

import cash_track.entity.Transaction;
import cash_track.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TransactionSpecificationBuilder implements SpecificationBuilder<Transaction> {

  public Specification<Transaction> buildUsernameSpecification(String username) {
    return (root, query, cb) ->
        cb.equal(root.get(Transaction.Fields.user).get(User.Fields.username), username);
  }
}
