package com.twu.biblioteca;

import java.util.*;
import java.util.LinkedList;
import java.util.Collections;

import static java.util.stream.Collectors.toList;

public class Library {
//    Todo: change String to be BookTitle type & refactor across other classes
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
//        Todo:  Figure out how to sort list, e.g. Collections.sort(listOfTitles);
        return booksInLibrary.values().stream().map(book -> book.getBookTitle()).collect(toList());
    }

    public List<String> getBookAuthors() {
//        Todo:  Figure out how to sort list, e.g. Collections.sort(listOfTitles);
        return booksInLibrary.values().stream().map(book -> book.getBookAuthor()).collect(toList());
    }

    public List<Integer> getBookYears() {
//        Todo:  Figure out how to sort list, e.g. Collections.sort(listOfTitles);
        return booksInLibrary.values().stream().map(book -> book.getBookYear()).collect(toList());
    }

    public String getBookDetails() {
        String bookDetails = "";
        for(Book value : booksInLibrary.values()) {
            return bookDetails += "|" + value.getBookTitle() + "|" + value.getBookAuthor() + "|" + value.getBookYear() + "|" + "\n";
        }
        return bookDetails;
        }

}
