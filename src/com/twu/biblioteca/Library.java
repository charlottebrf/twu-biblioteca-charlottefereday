package com.twu.biblioteca;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Library {

    private Map<String, Book> booksInLibrary;
    private final Keyboard keyboard;

    public Library(Keyboard keyboard) {
        booksInLibrary = new HashMap<String, Book>();
        this.keyboard = keyboard;
    }

    public Library() {
        this(new Keyboard());
    }

    public void addBooks(Book book) {
        booksInLibrary.put(book.getBookTitle(), book);
    }

    public void removeBooks(Book book) {
        booksInLibrary.remove(book.getBookTitle());
    }

    public List<Book> getBooks() {
        return new LinkedList<>(booksInLibrary.values());
    }

    public List<String> getBookTitles() {
        List<String> titles = booksInLibrary.values().stream().map(book -> book.getBookTitle()).collect(toList());
        Collections.sort(titles);
        return titles;
    }

    public Book findBookFromTitle() {
        String desiredTitle = keyboard.read();
        return booksInLibrary.getOrDefault(desiredTitle, Book.NO_BOOK);
    }

    public String getBookDetails() {
        String bookDetails = "";
        for (Book book : sortedBooks()) {
            bookDetails += "|" + book.getBookTitle() + "|" + book.getBookAuthor() + "|" + book.getBookYear() + "|" + "\n";
        }

        return bookDetails;
    }

    public List<Book> sortedBooks() {
        List<Book> books = new LinkedList<>(booksInLibrary.values());

        Comparator<Book> howToSort = Comparator.comparing(Book::getBookTitle);

        books.sort(howToSort);
        return books;
    }

    public boolean hasBookTitleInLibrary(String title) {
        return booksInLibrary.containsKey(title);
    }
}
