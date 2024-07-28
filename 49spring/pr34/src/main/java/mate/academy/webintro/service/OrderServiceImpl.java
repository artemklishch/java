package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.order.OrderDto;
import mate.academy.webintro.dto.user.UserResponseDto;
import mate.academy.webintro.mapper.OrderMapper;
import mate.academy.webintro.model.User;
import mate.academy.webintro.repository.OrderRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserService userService;

    @Override
    public List<OrderDto> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable).stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public List<OrderDto> findAll(String email, Pageable pageable) {
        UserResponseDto userResponseDto = userService.getByMail(email);
        return orderRepository.findAllByUserId(userResponseDto.getId())
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }
}
