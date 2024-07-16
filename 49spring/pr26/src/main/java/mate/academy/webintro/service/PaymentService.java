package mate.academy.webintro.service;

import mate.academy.webintro.model.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void processPayment(Payment payment) {
//        if (payment.getAmount() <= 0) {
//            throw new IllegalArgumentException("Payment amount must be positive");
//            // in this case both transactions will be rollbacked
//        }
//    };

    @Transactional(propagation = Propagation.REQUIRED)
    public void processPayment(Payment payment) {
        if (payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive");
        }
    };
}
