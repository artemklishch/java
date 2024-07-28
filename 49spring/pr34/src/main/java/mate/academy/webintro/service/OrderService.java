package mate.academy.webintro.service;

import mate.academy.webintro.dto.order.OrderDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAll(Pageable pageable);

    List<OrderDto> findAll(String email, Pageable pageable);
}
