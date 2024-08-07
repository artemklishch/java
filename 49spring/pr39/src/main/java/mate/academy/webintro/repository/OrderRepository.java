package mate.academy.webintro.repository;

import mate.academy.webintro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends
        JpaRepository<Order, Long> {
    List<Order> findAllByUserId(Long userId);
}

// package org.example.intro.repository.book;

// import org.example.intro.model.Book;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.EntityGraph;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// public interface BookRepository extends
// JpaRepository<Book, Long>,
// JpaSpecificationExecutor<Book>,
// PageAndSortingRepository<Book, Long> {
// @EntityGraph(attributePaths = "categories")
// Page<Book> findAll(Pageable pageable);

// @Query("SELECT b FROM Book b LEFT JOIN FETCH b.categories")
// List<Book> findAllBooks();

// @Query("SELECT DISTINCT b FROM Book b"
// + " LEFT JOIN FETCH b.categories c WHERE c.id = :id")
// List<Book> findBooksByCategoryId(Long id, Pageable pageable);

// this is in order not to use fetch type EAGER
// }
