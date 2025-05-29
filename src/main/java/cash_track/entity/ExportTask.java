package cash_track.entity;

import cash_track.entity.enums.ExportFormat;
import cash_track.entity.enums.ExportTaskStatus;
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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)

@Entity
@Table(name = "export_tasks")
public class ExportTask extends BaseEntity {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User user;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private ExportTaskStatus status;

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(name = "params", columnDefinition = "jsonb", nullable = false, updatable = false)
  private ExportParams params;

  @Column(name = "progress_percentage")
  private Integer progressPercentage;

  @Column(name = "file_key", unique = true)
  private String fileKey;

  @Column(name = "file_size", updatable = false)
  private Long fileSize;

  @Column(name = "error_message")
  private String errorMessage;
}
