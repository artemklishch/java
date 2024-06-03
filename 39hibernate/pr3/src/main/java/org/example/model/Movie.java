package org.example.model;

import jakarta.persistence.*;

@Entity // ця аннтоація означає, що об'єкти цього класу будуть мапитись в таблицю з ім'ям по дефолту як назва класу
@Table(name = "movies")
public class Movie {
    @Id // аннотація для ідентифікатора
    @GeneratedValue(strategy = GenerationType.IDENTITY) // аннотація для стратегії генерації значення ідентифікатора, без цього ідентифікатор птрібно робити вручну
    private Long id;

    private String title;
    private String description;

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
