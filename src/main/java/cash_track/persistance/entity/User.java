package cash_track.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @ToString.Exclude
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ToString.Exclude
    @Column(name = "password", nullable = false)
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new HashSet<>();
}
