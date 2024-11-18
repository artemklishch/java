package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // ifPresent
        // orElse
        // orElseGet
        // orElseThrow

        DataBase dataBase = new DataBase();
        Optional<User> userOptional = dataBase.getById(10L);
        userOptional.ifPresent(System.out::println);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println(user);
        }

        Optional<User> byId11 = dataBase.getById(11L);
        byId11.ifPresent(System.out::println); // returns nothing
        User alice = byId11.orElse(new User("Alice"));
        System.out.println(alice);

        Optional<User> optional = dataBase.getById(10L);
//        optional.orElseGet(() -> new User("Alice 2")); // приймає supplier інтерфейс
        System.out.println(optional.orElseGet(Main::getDefaultUser));

        Optional<User> optional2 = dataBase.getById(11L);
        optional2.orElseThrow(() -> new RuntimeException("Can't find user"));// приймає supplier інтерфейс

//        Optional<User> optional3 = dataBase.getById(11L);
//        optional3.get(); // returns NoSuchElementException by default (when user not found)
    }

    private static User getDefaultUser() {
        return new User("Bill");
    }
}