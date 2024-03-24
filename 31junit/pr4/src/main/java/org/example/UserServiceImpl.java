package org.example;

import java.util.List;
import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    @java.lang.Override
    public List<User> findByAgeGraterThen(List<User> users, int age) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() > age) {
                result.add(user);
            }
        }
        return result;
    }
}
