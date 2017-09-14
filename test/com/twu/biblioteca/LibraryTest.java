package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class LibraryTest {

    BookTitle firstHP = new BookTitle("Harry Potter and the Philosopher's Stone");
    Author rowling = new Author("J.K.Rowlng");
    Year year = new Year(1997);
    Book harryPotter1 = new Book(firstHP, rowling, year);
    Library lib = new Library();

    @Before
    public void setUp() {
        Book harryPotter1 = new Book(firstHP, rowling, year);
        BookTitle firstHP = new BookTitle("Harry Potter and the Philosopher's Stone");
        Author rowling = new Author("J.K.Rowlng");
        Library lib = new Library();
    }

    @Test
    public void addsABookToTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<Book> list = new LinkedList<Book>();
        list.add(harryPotter1);
        assertEquals(list, lib.getBooks());
    }

    @Test
    public void getsABookTitleFromTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<String> title = new LinkedList<String>();
        String authorName = firstHP.getTitle();
        title.add(authorName);
        assertEquals(title, lib.getBookTitles());
    }
}