package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void createsABookObject() {
        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone", "J.K.Rowlng", 1997);
        assertEquals(harryPotter1, harryPotter1.getBook(harryPotter1));
    }
}