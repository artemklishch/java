package mate.academy.webintro.repository;

import mate.academy.webintro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends
        JpaRepository<Order, Long> {
    List<Order> findAllByUserId(Long userId);
}
