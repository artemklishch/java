package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UserServiceImplTest {
//    private final UserService userService = new UserServiceImpl();
private static UserService userService;
    private List<User> users;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all");
        userService = new UserServiceImpl();
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each");
        users = new ArrayList<>();
        users.add(new User("Bob", 23));
        users.add(new User("Alice", 22));
        users.add(new User("John", 17));
    }

    @Test
    void checkEmptyList_Ok() {
        List<User> actual = userService.findByAgeGraterThen(new ArrayList<>(), 10);
        assertTrue(actual.isEmpty());
    }

    @Test
    void validUserCase_Ok() {
        List<User> actual = userService.findByAgeGraterThen(users, 18);
        assertEquals(2, actual.size());
        assertTrue(actual.contains(new User("Bob", 23)));
        assertTrue(actual.contains(new User("Alice", 22)));
    }

    @Test
    void largeAge() {
        List<User> actual = userService.findByAgeGraterThen(users, 81);
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }
}