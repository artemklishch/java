package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.CreateUserRequestDto;
import mate.academy.webintro.dto.UserDto;
import mate.academy.webintro.exception.EntityNotFountException;
import mate.academy.webintro.mapper.UserMapper;
import mate.academy.webintro.model.User;
import mate.academy.webintro.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(CreateUserRequestDto requestDto) {
        User product = userMapper.toModel(requestDto);
        return userMapper.toDto(userRepository.save(product));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDto findById(Long id) {
        User product = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFountException(
                        "Can't find user with id: " + id)
                );
        return userMapper.toDto(product);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
