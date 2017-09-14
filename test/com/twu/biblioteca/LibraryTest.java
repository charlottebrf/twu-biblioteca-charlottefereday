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
        String hpTitle = firstHP.getTitle();
        title.add(hpTitle);
        assertEquals(title, lib.getBookTitles());
    }

    @Test
    public void getsABookAuthorFromTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<String> author = new LinkedList<String>();
        String authorName = rowling.getAuthor();
        author.add(authorName);
        assertEquals(author, lib.getBookAuthors());
    }

    @Test
    public void getsABookYearFromTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<Integer> bookYear = new LinkedList<Integer>();
        Integer year1 = year.getYear();
        bookYear.add(year1);
        assertEquals(bookYear, lib.getBookYears());
    }

    @Test
    public void getsAllBookInformationFromTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<String> title = new LinkedList<String>();
        String hpTitle = firstHP.getTitle();
        title.add(hpTitle);

        lib.addBooks(harryPotter1);
        LinkedList<String> author = new LinkedList<String>();
        String authorName = rowling.getAuthor();
        author.add(authorName);

        lib.addBooks(harryPotter1);
        LinkedList<Integer> bookYear = new LinkedList<Integer>();
        Integer year1 = year.getYear();
        bookYear.add(year1);

        assertEquals("|" + lib.getBookTitles() + "|" + lib.getBookAuthors() + "|" + lib.getBookYears() + "|", lib.getBookDetails());
    }
}