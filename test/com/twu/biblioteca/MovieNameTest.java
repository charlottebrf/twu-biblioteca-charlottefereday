package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieNameTest {

    MovieName name = new MovieName("Kill Bill");

    @Test
    public void getsAMovieName() {
        assertEquals("Kill Bill", name.getName());
    }
}