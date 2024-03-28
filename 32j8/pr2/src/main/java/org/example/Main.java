package org.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Lambda example

        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getAge() - user2.getAge();
            }
        };
        Comparator<User> userComparator2 = (user1, user2) -> user1.getAge() - user2.getAge();

        // (parameters) -> sout(parameters);

        Set<User> users = new TreeSet<>(userComparator2);
        users.add(new User("Bob", 23));
        users.add(new User("Alice", 22));
        users.add(new User("John", 27));
        users.add(new User("Bob", 28));
        users.add(new User("Bob", 19));
        System.out.println(users);
    }
}