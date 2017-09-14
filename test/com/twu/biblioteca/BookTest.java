package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void createsABookObject() {
        BookTitle title = new BookTitle("Harry Potter and the Philosopher's Stone");
        Book harryPotter1 = new Book(title, "J.K.Rowlng", 1997);
        assertEquals(harryPotter1, harryPotter1.getBook(harryPotter1));
    }

    @Test
    public void getsBookTitle() {
        BookTitle title = new BookTitle("Harry Potter and the Philosopher's Stone");
        Book harryPotter1 = new Book(title, "J.K.Rowlng", 1997);
        assertEquals(title, harryPotter1.getBookTitle(harryPotter1));
    }
}