package org.example;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StreamApiAdvanced streamApiAdvanced = new StreamApiAdvanced();

        int[] numbers = new int[]{2, 10, 25, 46, 30};
        System.out.println(streamApiAdvanced.filterAndReverse(numbers));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Bob", 20, Person.Sex.MAN));
        people.add(new Person("Alice1", 21, Person.Sex.WOMAN));
        people.add(new Person("Alice2", 17, Person.Sex.WOMAN, List.of(new Cat("Bob", 1), new Cat("Murzik", 1))));
        people.add(new Person("Alice3", 22, Person.Sex.WOMAN, List.of(new Cat("Bob", 1), new Cat("Murrr", 1))));
        people.add(new Person("Alice4", 25, Person.Sex.WOMAN, List.of(new Cat("Jack", 1), new Cat("Vasyl", 1))));

        System.out.println(streamApiAdvanced.groupByAge(people));

        List<String> strings = List.of("word", "bird", "word1", "bird.", "main", "plain", "fat");
        System.out.println(streamApiAdvanced.groupWordsByLastChar(strings));
    }
}