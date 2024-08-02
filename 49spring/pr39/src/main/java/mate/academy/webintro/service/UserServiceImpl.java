package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import mate.academy.webintro.dto.user.UserRegistrationRequestDto;
import mate.academy.webintro.dto.user.UserResponseDto;
import mate.academy.webintro.exception.RegistrationException;
import mate.academy.webintro.mapper.UserMapper;
import mate.academy.webintro.model.User;
import mate.academy.webintro.repository.UserRepository;
import mate.academy.webintro.security.HashUtil;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(
                    "Can't register user with email "
                            + requestDto.getEmail()
                            + ". Email is already in use."
            );
        }
        User user = new User();
        user.setEmail(requestDto.getEmail());
        byte[] salt = HashUtil.getSalt();
        String hashedPassword = HashUtil.hashPassword(requestDto.getPassword(), salt);
        user.setPassword(hashedPassword);
        user.setSalt(salt);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto getByMail(String email) {
        return userRepository
                .findByEmail(email)
                .map(userMapper::toUserResponseDto)
                .orElseThrow(() -> new RuntimeException("Can't find user with email " + email));
    }
}
