package cash_track.repository;

import cash_track.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

  List<Transaction> findTransactionsByUserUsername(String username);
}
