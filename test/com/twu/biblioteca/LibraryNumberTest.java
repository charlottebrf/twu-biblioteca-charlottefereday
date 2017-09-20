package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryNumberTest {
    int credential = 1234567;
    LibraryNumber number = new LibraryNumber(credential);

    @Test
    public void getsLibraryNumber() throws Exception {
        assertEquals(credential, number.getNumber());
    }
}