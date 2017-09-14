package com.twu.biblioteca;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Library {
    private Map<String, Book> booksInLibrary;

    public Library() {
        booksInLibrary = new HashMap<String, Book>();
    }

    public void addBooks(Book book) {
        booksInLibrary.put(book.getBookTitle(), book);
    }

    public List<Book> getBooks() {
        return new LinkedList<>(booksInLibrary.values());
    }

    public List<String> getBookTitles() {
        return booksInLibrary.values().stream().map(book -> book.getBookTitle()).collect(toList());
    }

}
