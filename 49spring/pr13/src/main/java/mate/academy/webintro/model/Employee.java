package mate.academy.webintro.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @ToString.Exclude // в методі toString це значення не буде виводитись
    @Column(name = "social_security_number", unique = true)
    private String socialSecurityNumber;
}

// DTO data transfer object
