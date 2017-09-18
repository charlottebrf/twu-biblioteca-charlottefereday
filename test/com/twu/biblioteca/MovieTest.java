package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    MovieName name = new MovieName("Kill Bill");
    Year year = new Year(2002);
    Director director = new Director("Quentin Tarantino");
    MovieRating rating = new MovieRating(5);
    Movie killBill = new Movie(name, year, director, rating);

    @Before
    public void setUp() {
        killBill = new Movie(name, year, director, rating);
    }

    @Test
    public void createsAMovieObject() {
        assertEquals(killBill, killBill.getMovie());
    }

    @Test
    public void getsMovieName() {
        assertEquals("Kill Bill", killBill.getMovieName());
    }

    @Test
    public void getsMovieYear() {
        assertEquals(2002, killBill.getMovieYear());
    }

    @Test
    public void getsDirector()  {
        assertEquals("Quentin Tarantino", killBill.getMovieDirector());
    }

    @Test
    public void getMovieRating() {
        assertEquals(5, killBill.getMovieRating());
    }
}
