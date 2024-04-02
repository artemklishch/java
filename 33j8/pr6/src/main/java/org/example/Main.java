package org.example;

import db.Storage;
import model.Author;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // There is a Map<User, List<Book>>
        // that represents the kist of books bought by each User
        // Find the most popular Authors for users whose age between 25 and 35

        AuthorService authorService = new AuthorServiceImp();
        List<Author> authors = authorService.getMostPopularByAudienceAge(25, 35);
        for (Author author : authors) {
            System.out.println(author);
        }

//        Storage.getStatistic().keySet().stream() // getting the stream of keys

    }
}