package org.example;

import java.util.function.Function; // щось приймає і щось повертає
import java.util.function.Predicate; // щось прийма та повертає булєве значення
import java.util.function.Consumer; // щось приймає та нічого не повертає
import java.util.function.Supplier; // нічого не приймає, але щось повертає

public class Main {
    public static void main(String[] args) {
        // functional interfaces in JDK example

        /*
        - function
        - predicate
        - consumer
        - ...
        */

        StudentsGradeFunction gradeFunction = new StudentsGradeFunction();
        System.out.println(gradeFunction.apply(100));

        User bob = new User("Bob", 22);
        Function<User, String> userStringFunction = User::getName;
    }
}