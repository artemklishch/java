package mate.academy.webintro.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.order.OrderDto;
import mate.academy.webintro.model.User;
import mate.academy.webintro.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    //    @GetMapping
//    public List<OrderDto> findAll(Pageable pageable) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        return orderService.findAll(user.getEmail(), pageable);
//    }
    @GetMapping
    public List<OrderDto> findAll(Authentication authentication, Pageable pageable) {
//        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return orderService.findAll(user.getEmail(), pageable);
    }
}
