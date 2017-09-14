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

    BookTitle secondHP = new BookTitle("Harry Potter and the Chamber of Secrets");
    Author rowling2 = new Author("J.K.Rowlng");
    Year year2 = new Year(1998);
    Book hP2 = new Book(secondHP, rowling2, year2);

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
        lib.addBooks(hP2);
        lib.addBooks(harryPotter1);

        assertEquals("|" + secondHP.getTitle() + "|" + rowling2.getAuthor() + "|" + year2.getYear() + "|" + "\n" +
                               "|" + firstHP.getTitle() + "|" + rowling.getAuthor() + "|" + year.getYear() + "|" + "\n",
                                lib.getBookDetails());
    }
}