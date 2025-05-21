package cash_track.repository;

import cash_track.entity.Transaction;
import cash_track.entity.Transaction.Fields;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID>, JpaSpecificationExecutor<Transaction> {

  @Query("""
      SELECT t FROM Transaction t
      WHERE t.user.username = ?#{principal.username}
      AND t.id = :transactionId
      """)
  @EntityGraph(attributePaths = {Fields.user, Fields.category})
  Optional<Transaction> findById(@Param("transactionId") UUID transactionId);
}
