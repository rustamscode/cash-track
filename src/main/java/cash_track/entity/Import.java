package cash_track.entity;

import cash_track.entity.enums.ImportStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)

@Entity
@Table(name = "imports")
public class Import extends BaseEntity {

  @EqualsAndHashCode.Include
  @Column(name = "key", nullable = false, unique = true)
  private String key;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "status", nullable = false)
  private ImportStatus status;

  @Column(name = "submitted_at", nullable = false)
  private OffsetDateTime submittedAt;

  @Column(name = "started_at")
  private OffsetDateTime startedAt;

  @Column(name = "completed_at")
  private OffsetDateTime completedAt;

  @Column(name = "message", nullable = false)
  private String message;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
