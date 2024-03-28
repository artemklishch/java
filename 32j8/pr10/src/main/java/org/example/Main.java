package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // predicate

        List<User> users = new ArrayList<>();
        users.add(new User("Bob", 22));
        users.add(new User("Bill", 17));
        users.add(new User("Bruce", 18));
        users.add(new User("Alice", 19));
        UserPredicate userPredicate = new UserPredicate();
        for (User user : users) {
            if (userPredicate.test(user)) {
                System.out.println(user.getName());
            }
        }

        // consumer
        Consumer<String> sout = System.out::println;
        List<String> names = List.of("Bob", "Alice", "John");
//        for (String name: names) {
//            sout.accept(name);
//        }
        names.forEach(sout); // дeфолтний метод

        // supplier
        Supplier<Integer> randomGenerator = () -> new Random().nextInt();
        System.out.println(randomGenerator.get());

        // exceptions
        Function<String, String> stringFunction = new Function<String, String>() {
            @Override
            public String apply(String s) {
                if (s == null) {
                    throw new RuntimeException(); //  we can throw only unchecked exceptions
                }
                return s.toUpperCase();
            }
        };

        Test test = () -> {

        };
        test.print();
        System.out.println(Test.get());
    }
}