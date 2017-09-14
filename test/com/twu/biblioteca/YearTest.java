package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {
    Year year = new Year(1997);

    @Test
    public void getsYear() {
        assertEquals(1997, year.getYear());
    }
}