package org.example;

import java.util.List;

public interface UserService {
    List<User> findByAgeGraterThen(List<User> users, int age);
}
