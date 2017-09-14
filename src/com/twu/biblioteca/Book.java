package com.twu.biblioteca;

public class Book {
    private final String author;
    private final int year;
    public BookTitle title;

    public Book(BookTitle title, String author, int year) {
        this.author = author;
        this.year = year;
        this.title = title;
    }

    public Book getBook(Book book) {
        return book;
    }

    public BookTitle getBookTitle(Book book) {
        return book.title;
    }
}
