package mate.academy.webintro.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@Data
@Entity
@SQLDelete(sql = "UPDATE employees SET is_deleted = true WHERE id=?")
//@Where(clause = "is_deleted=false") // deprecated
@SQLRestriction("is_deleted=false")
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @ToString.Exclude
    @Column(name = "social_security_number", unique = true)
    private String socialSecurityNumber;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
