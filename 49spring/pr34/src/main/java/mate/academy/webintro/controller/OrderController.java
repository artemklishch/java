package mate.academy.webintro.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.order.OrderDto;
import mate.academy.webintro.service.Authentication;
import mate.academy.webintro.service.OrderService;
import mate.academy.webintro.service.SecurityContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll(Pageable pageable) {
        Authentication authentication = SecurityContextHolder
                .getSecurityContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        return orderService.findAll(email, pageable);
    }
}
