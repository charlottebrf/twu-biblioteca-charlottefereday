package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectorTest {
    Director director = new Director("Quentin Tarantino");

    @Test
    public void getsDirectorName() {
        assertEquals("Quentin Tarantino", director.getDirector());
    }
}