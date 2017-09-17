package com.twu.biblioteca;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BookRegister {

    private Map<String, Book> booksInRegister;
    private final Keyboard keyboard;

    public BookRegister(Keyboard keyboard) {
        booksInRegister = new HashMap<String, Book>();
        this.keyboard = keyboard;
    }

    public BookRegister() {
        this(new Keyboard());
    }

    public void addBooksToRegister(Book book) {
        booksInRegister.put(book.getBookTitle(), book);
    }

    public List<Book> getBooksInRegister() {
        return new LinkedList<>(booksInRegister.values());
    }

    public Book findBookInRegisterFromTitle(String desiredTitle) {
        return booksInRegister.getOrDefault(desiredTitle, Book.NO_BOOK);
    }

    public void removesBooksFromRegister(Book book) {
        booksInRegister.remove(book.getBookTitle());
    }

    public boolean hasBookTitleInRegister(String title) {
        return booksInRegister.containsKey(title);
    }
}
