package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTitleTest {

    BookTitle title = new BookTitle("Harry Potter and the Philosopher's Stone");

    @Test
    public void getsABookTitle() {
        assertEquals("Harry Potter and the Philosopher's Stone", title.getTitle());
    }
}