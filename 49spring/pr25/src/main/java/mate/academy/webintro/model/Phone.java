package mate.academy.webintro.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "country_manufactured")
    private String countryManufactured;
}
