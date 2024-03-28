package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // method reference
        // There are kinds of method references:
        // - Static methods
        // - Instance methods of particular objects
        // - Instance methods of arbitrary object of a particular type
        // - Constructor

        NumbersService<Integer> numbersService = Integer::parseInt; // static method
        Integer integer = numbersService.getFromString("123");
        System.out.println(integer);

        String[] names = {"Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda"};
        Arrays.sort(names, String::compareToIgnoreCase); // method reference via - Instance methods of arbitrary object of a particular type
        System.out.println(Arrays.toString(names));

        UserService userService = User::new; // method reference via constructor
        User bob = userService.of("Bob");
        System.out.println(bob);
    }
}