package org.example;

import java.util.Arrays;

public class ComparisonMain {
    public static void main(String[] args) {
        User[] people = new User[3];
        people[0] = new User("Bob");
        people[1] = new User("Alice");
        people[2] = new User("John");

        ComparisonProvider comparisonProvider = new ComparisonProvider();
        Arrays.sort(people, comparisonProvider::compareByName);
        System.out.println(Arrays.toString(people));
    }
}
