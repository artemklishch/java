package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mate.academy.webintro.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Log4j2
public class OrderService {
    private final PaymentService paymentService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void placeOrder(Order order) {
        paymentService.processPayment(order.getPayment());

        log.info("Order placed");
    }
}
