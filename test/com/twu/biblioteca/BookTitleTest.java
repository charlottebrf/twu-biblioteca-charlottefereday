package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTitleTest {

    @Test
    public void createsABookTitleObject() {
        BookTitle title = new BookTitle("Harry Potter and the Philosopher's Stone");
        assertEquals(title, title.getTitle(title));
    }
}