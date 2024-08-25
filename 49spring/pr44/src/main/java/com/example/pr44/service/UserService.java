package com.example.pr44.service;

import com.example.pr44.model.User;
import com.example.pr44.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUsername(Long userId) {
        return userRepository.findById(userId)
                .map(User::getName)
                .orElseThrow(
                        () -> new RuntimeException("User not found with id: " + userId)
                );
    }
}
