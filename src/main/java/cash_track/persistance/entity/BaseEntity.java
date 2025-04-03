package cash_track.persistance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private OffsetDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    private OffsetDateTime lastModifiedDate;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;
}
