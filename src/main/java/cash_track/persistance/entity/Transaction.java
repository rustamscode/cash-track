package cash_track.persistance.entity;

import cash_track.persistance.entity.enums.CurrencyType;
import cash_track.persistance.entity.enums.TransactionStatus;
import cash_track.persistance.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private CurrencyType currency;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionStatus status;

    @ToString.Exclude
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
