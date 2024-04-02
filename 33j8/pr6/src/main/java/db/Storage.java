package db;

import model.Author;
import model.Book;
import model.User;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class Storage {
    public static Map<User, List<Book>> getStatistic() {
        User bob = new User("Bob", 23);
        User alice = new User("Alice", 27);
        User john = new User("John", 32);
        User bill = new User("Bill", 29);

        Author miguelDeServantes = new Author("Miguel", "de Servantes");
        Book donQuihote = new Book("Don Quihot", miguelDeServantes);
        Book espanolaInglesa = new Book("La espanola inglesa", miguelDeServantes);

        Author markTwain = new Author("Mark", "Twain");
        Book tomSoyer = new Book("Tom Soyer", markTwain);

        // creating same objects separately, like here creates three different objects and we need to redifine
        // the equals/hashCode methods
        Book thinkingInJava = new Book("Thinking in Java", new Author("Bruce", "Eckel"));
        Book thinkingInC = new Book("Thinking in C++", new Author("Bruce", "Eckel"));
        Book javaEight = new Book("On Java 8", new Author("Bruce", "Eckel"));

        Map<User, List<Book>> statistic = new HashMap<>();
        statistic.put(bob, List.of(donQuihote, espanolaInglesa));
        statistic.put(alice, List.of(tomSoyer));
        statistic.put(john, Collections.emptyList());
        statistic.put(bill, List.of(thinkingInJava, thinkingInC, javaEight));
        return statistic;
    }
}
