package cash_track.repository;

import cash_track.entity.User;
import cash_track.entity.User.Fields;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  @Query("""
      SELECT u FROM User u
      WHERE u.username = ?#{principal.username}
      """)
  Optional<User> findCurrentUser();

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

  @EntityGraph(attributePaths = {Fields.categories, Fields.roles})
  Optional<User> findUserByUsername(@Param("username") String username);
}
