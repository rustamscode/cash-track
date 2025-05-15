package cash_track.repository;

import cash_track.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

  @Query("""
      SELECT c FROM Category c 
      WHERE c.user.username = ?#{principal.username}
      AND c.name = :categoryName 
      """)
  Optional<Category> findCategoryByNameForCurrentUser(@Param("categoryName") String categoryName);

  @Query("""
      SELECT 
      CASE WHEN COUNT(c.id) > 0 
        THEN TRUE 
        ELSE FALSE 
      END
      FROM Category c
      WHERE c.name = :categoryName 
      AND c.user.username = ?#{principal.username}
      """)
  boolean existsByNameForCurrentUser(@Param("categoryName") String categoryName);

  @Query("""
      SELECT c FROM Category c 
      WHERE c.user.username = ?#{principal.username}
      AND c.id = :categoryId 
      """)
  Optional<Category> findCategoryByIdForCurrentUser(@Param("categoryId") UUID categoryId);
}
