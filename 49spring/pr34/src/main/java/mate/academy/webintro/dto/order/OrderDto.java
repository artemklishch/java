package mate.academy.webintro.dto.order;

import lombok.Data;
import mate.academy.webintro.model.Order;

import java.time.LocalDateTime;

@Data
public class OrderDto{
    private Long id;
    private LocalDateTime orderDate;
    private Order.Status status;
    private Long userId;
}
