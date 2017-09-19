package com.twu.biblioteca;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class LibraryNumberTest {
    int credential = 123-4567;
    LibraryNumber number = new LibraryNumber(credential);

    @Test
    public void getsLibraryNumber() throws Exception {
        assertEquals(credential, number.getNumber());
    }
}