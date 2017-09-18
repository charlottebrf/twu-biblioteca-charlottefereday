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

//    Todo: figure out how to make sure that rating number is greater than 1 & less than 10
//    public boolean rating(int ratingNumber) {
//        if ((ratingNumber >= 1) && (ratingNumber <= 10)) {
//            return true;
//        }
//    }
//}
//    public MovieRating(int ratingNumber) {
//        if (rating(ratingNumber)) {
//            this.ratingNumber = ratingNumber;
//        } else {
//            throw new IllegalArgumentException("value is out of range for a movie rating");
//        }
//    }

}
