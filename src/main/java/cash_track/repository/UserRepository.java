package cash_track.repository;

import cash_track.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByUsername(String username);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);
}
