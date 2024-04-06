package org.example;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Optional
//        User[] users = new User[0];
//        User user = getElementByIndex(users, 10);
//        if (user != null) {
//            System.out.println(user.getName());
//        }

        User[] users = new User[]{new User("Bob")};
//        Wrapper<User> userWrapper = getElementByIndex(users, 0);
//        if (userWrapper.isPresent()){
//            System.out.println(userWrapper.getValue().getName());
//        }
        Optional<User> userWrapper = getElementByIndex(users, 10);
        userWrapper.ifPresent(System.out::println);
    }

    //    private static User getElementByIndex(User[] values, int index) {
//        if (index >= values.length || index < 0) {
//            return null;
//        }
//        return values[index];
//    }


//    private static Wrapper<User> getElementByIndex(User[] values, int index) {
//        if (index >= values.length || index < 0) {
//            return Wrapper.empty();
//        }
//        return new Wrapper<>(values[index]);
//    }

    private static Optional<User> getElementByIndex(User[] values, int index) {
        if (index >= values.length || index < 0) {
            return Optional.empty();
        }
        return Optional.of(values[index]);
    }
}