package org.example;

import db.Storage;
import model.Author;
import model.Book;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Map;

public class AuthorServiceImp implements AuthorService {
    @java.lang.Override
    public List<Author> getMostPopularByAudienceAge(int fromAge, int toAge) {
        return Storage.getStatistic().entrySet().stream()
                .filter(e -> e.getKey().getAge() > fromAge && e.getKey().getAge() < toAge)
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .map(Book::getAuthor)
                .distinct() // it doesn't work, event when redefine 'equal' and 'hashCode' methods for author class
                .collect(Collectors.toList());
    }
}
