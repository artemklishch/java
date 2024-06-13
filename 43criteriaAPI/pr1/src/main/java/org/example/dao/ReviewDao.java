package org.example.dao;

import org.example.model.Review;

public interface ReviewDao {
    Review save(Review review);

    Review get(Long id);
}
