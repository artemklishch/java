package mate.academy.webintro.controller;

import mate.academy.webintro.model.Order;
import mate.academy.webintro.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final OrderService orderService;

    public TestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/test-order")
    public String testOrder(@RequestParam(defaultValue = "10") double amount) {
        orderService.placeOrder(new Order(amount));
        return "done!";
    }
}
