package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.order.OrderDto;
import mate.academy.webintro.dto.user.UserResponseDto;
import mate.academy.webintro.mapper.OrderMapper;
import mate.academy.webintro.model.User;
import mate.academy.webintro.repository.OrderRepository;
import mate.academy.webintro.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    @Override
    public List<OrderDto> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable).stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public List<OrderDto> findAll(String email, Pageable pageable) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new NoSuchElementException("This user doesn't have orders!");
        }
        return orderRepository.findAllByUserId(user.get().getId())
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }
}
