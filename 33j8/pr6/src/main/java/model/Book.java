package model;

public class Book {
    private String title;
    private Author author;

    public Book(java.lang.String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Book{" +
                "title=" + title +
                ", author=" + author +
                '}';
    }
}
