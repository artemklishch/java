package mate.academy.webintro.repository;

import mate.academy.webintro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends
        JpaRepository<Order, Long>,
        PageAndSortingRepository<Order, Long> {
}
