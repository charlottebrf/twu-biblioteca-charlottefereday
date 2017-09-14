package com.twu.biblioteca;

public class Book {
    private final Author author;
    private final int year;
    public BookTitle title;

    public Book(BookTitle title, Author author, int year) {
        this.author = author;
        this.year = year;
        this.title = title;
    }

    public Book getBook() {
        return this;
    }

    public String getBookTitle() {
        return this.title.getTitle();
    }

    public String getBookAuthor() {
        return this.author.getAuthor();
    }
}
