package org.example;

import model.Author;
import java.util.List;

public interface AuthorService {
    List<Author> getMostPopularByAudienceAge(int fromAge, int toAge);
}
