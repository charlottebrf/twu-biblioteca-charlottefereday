package com.twu.biblioteca;

public class Movie {

    private final MovieName name;
    private final Year year;
    private final Director director;
    private final MovieRating rating;

    public Movie(MovieName name, Year year, Director director, MovieRating rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public Movie getMovie() {
        return this;
    }

    public String getMovieName() {
        return this.name.getName();
    }

    public int getMovieYear() {
        return this.year.getYear();
    }

    public String getMovieDirector() {
        return this.director.getDirector();
    }

    public int getMovieRating() {
        return this.rating.getRating();
    }
}
