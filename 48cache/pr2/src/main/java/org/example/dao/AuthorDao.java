package org.example.dao;

import org.example.model.Author;

public interface AuthorDao {
    Author save(Author author);

    Author get(Long id);
}
