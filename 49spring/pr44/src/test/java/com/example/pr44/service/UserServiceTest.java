package com.example.pr44.service;

import com.example.pr44.model.User;
import com.example.pr44.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("""
            Verify getting existing user with valid user id
            """)
    void getUsername_WithValidUserId_ShouldReturnUser() {
        // given
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("Bob");
        user.setAge(23);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // when
        String actual = userService.getUsername(userId);

        // then
        String expected = user.getName();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            Verify getting existing user with valid user id
            """)
    void getUsername_WithNoneExistingUserId_ShouldThrowException() {
        // given
        Long userId = 10L;
//        Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // when
        Exception exception = assertThrows(RuntimeException.class, () -> userService.getUsername(userId));

        userRepository.findAll();
        // then
        String actual = exception.getMessage();
        String expected = "User not found with id: " + userId;
        assertEquals(expected, actual);

        verify(userRepository, times(1)).findById(userId); // check that method was called 1 time
        verify(userRepository, times(1)).findAll();
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    @DisplayName("""
            spy test
            """)
    void spyTest() {
        List<String> spyList = Mockito.spy(new ArrayList<>());

        spyList.add("one");
        spyList.add("two");

        assertEquals(2, spyList.size()); // real size

        Mockito.when(spyList.size()).thenReturn(100); // we substitute not real size for our test

        assertEquals(100, spyList.size()); // true
    }
}