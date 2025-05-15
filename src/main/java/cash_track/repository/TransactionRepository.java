package cash_track.repository;

import cash_track.entity.Transaction;
import cash_track.entity.Transaction.Fields;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

  @Query("""
      SELECT t FROM Transaction t
      WHERE t.user.username = ?#{principal.username}
      """)
  @EntityGraph(attributePaths = {Fields.user, Fields.category})
  List<Transaction> findTransactionsForCurrentUser();
}
