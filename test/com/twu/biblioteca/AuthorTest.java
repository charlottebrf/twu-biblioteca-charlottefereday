package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    Author rowling = new Author("J.K.Rowlng");

    @Test
    public void getsAuthorName() {
        assertEquals("J.K.Rowlng", rowling.getAuthor());
    }
}