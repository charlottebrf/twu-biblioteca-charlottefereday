package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    @Test
    public void createsAnAuthorObject() {
        Author rowling = new Author("J.K.Rowlng");
        assertEquals("J.K.Rowlng", rowling.getAuthor());
    }
}