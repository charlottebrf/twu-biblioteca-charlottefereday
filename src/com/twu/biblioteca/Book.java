package com.twu.biblioteca;

public class Book {
    private final Author author;
    private final Year year;
    public BookTitle title;
    public static final Book NO_BOOK = new Book(new BookTitle("No book"), new Author("No book"), new Year(1111));

    public Book(BookTitle title, Author author, Year year) {
        this.author = author;
        this.year = year;
        this.title = title;
    }

    public Book getBook() {
        return this;
    }

    public String getBookAuthor() {
        return this.author.getAuthor();
    }

    public int getBookYear() {
        return this.year.getYear();
    }

}
