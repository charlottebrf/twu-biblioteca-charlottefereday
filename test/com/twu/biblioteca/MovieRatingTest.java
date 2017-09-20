package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieRatingTest {


    @Test
    public void getsAMovieRating() {
        MovieRating rating = new MovieRating(5);
        assertEquals(5, rating.getRating());
    }

    @Test
    public void givesZeroIfNotRated() {
        MovieRating rating2 = new MovieRating();
        assertEquals(0, rating2.getRating());
    }

    @Test
    public void onlyAcceptsRatingBetweenOneToTen() {
        MovieRating rating3 = new MovieRating(10);
        assertEquals(10, rating3.getRating());
    }
}