package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    BookTitle firstHP = new BookTitle("Harry Potter and the Philosopher's Stone");
    Author rowling = new Author("J.K.Rowlng");
    Year year = new Year(1997);
    Book harryPotter1 = new Book(firstHP, rowling, year);

    @Before
    public void setUp() {
        Book harryPotter1 = new Book(firstHP, rowling, year);
        BookTitle firstHP = new BookTitle("Harry Potter and the Philosopher's Stone");
        Author rowling = new Author("J.K.Rowlng");
    }

    @Test
    public void createsABookObject() {
        assertEquals(harryPotter1, harryPotter1.getBook());
    }

    @Test
    public void getsBookTitle() {
        assertEquals("Harry Potter and the Philosopher's Stone", harryPotter1.getBookTitle());
    }

    @Test
    public void getsBookAuthor() {
        assertEquals("J.K.Rowlng", harryPotter1.getBookAuthor());
    }

    @Test
    public void getsYear() {
        assertEquals(1997, harryPotter1.getBookYear());
    }
}