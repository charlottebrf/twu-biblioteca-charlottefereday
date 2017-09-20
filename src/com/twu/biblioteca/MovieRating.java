package com.twu.biblioteca;

public class MovieRating {
    private final int ratingNumber;

    public MovieRating(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public int getRating() {
        return this.ratingNumber;
    }

    public MovieRating() {
        this(0);
    }

}
