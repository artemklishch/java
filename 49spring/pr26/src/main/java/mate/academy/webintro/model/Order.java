package mate.academy.webintro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Order(double amount) {
        this.amount = amount;
        this.payment = new Payment(amount);
    }
}
