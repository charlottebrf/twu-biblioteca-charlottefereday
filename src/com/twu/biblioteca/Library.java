package com.twu.biblioteca;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Library {

    private Map<String, Book> booksInLibrary;
    private Map<String, Movie> moviesInLibrary;
    private final Keyboard keyboard;

    public Library(Keyboard keyboard) {
        booksInLibrary = new HashMap<String, Book>();
        moviesInLibrary = new HashMap<String, Movie>();
        this.keyboard = keyboard;
    }

    public Library() {
        this(new Keyboard());
    }

    public void addBooks(Book book) {
        booksInLibrary.put(book.title.getTitle(), book);
    }

    public void addMovies(Movie movie) { moviesInLibrary.put(movie.getMovieName(), movie);}

    public void removeBooks(Book book) {
        booksInLibrary.remove(book.title.getTitle());
    }

    public void removeMovies(Movie movie) { moviesInLibrary.remove(movie.getMovieName());}

    public List<Book> getBooks() {
        return new LinkedList<>(booksInLibrary.values());
    }

    public List<Movie> getMovies() { return new LinkedList<>(moviesInLibrary.values()); }

    public List<String> getBookTitles() {
        List<String> titles = booksInLibrary.values().stream().map(book -> book.title.getTitle()).collect(toList());
        Collections.sort(titles);
        return titles;
    }

    public List<String> getMovieNames() {
        List<String> names = moviesInLibrary.values().stream().map(movie -> movie.getMovieName()).collect(toList());
        Collections.sort(names);
        return names;
    }

    public Book findBookFromTitle(String desiredTitle) {
        return booksInLibrary.getOrDefault(desiredTitle, Book.NO_BOOK);
    }

    public Movie findMovieFromName(String desiredName) {
        return moviesInLibrary.getOrDefault(desiredName, Movie.NO_MOVIE);
    }

    public String getBookDetails() {
        String bookDetails = "";
        for (Book book : sortedBooks()) {
            bookDetails += "|" + book.title.getTitle() + "|" + book.getBookAuthor() + "|" + book.getBookYear() + "|" + "\n";
        }

        return bookDetails;
    }

    public String getMovieDetails() {
        String movieDetails = "";
        for (Movie movie : sortedMovies()) {
            movieDetails += "|" + movie.getMovieName() + "|" + movie.getMovieYear() + "|" + movie.getMovieDirector() + "|" + movie.getMovieRating() + "|" + "\n";
        }
        return movieDetails;
    }

    public List<Book> sortedBooks() {
        List<Book> books = new LinkedList<>(booksInLibrary.values());

        Comparator<Book> howToSort = Comparator.comparing(book -> book.title.getTitle());

        books.sort(howToSort);
        return books;
    }

    public List<Movie> sortedMovies() {
        List<Movie> movies = new LinkedList<>(moviesInLibrary.values());

        Comparator<Movie> howToSort = Comparator.comparing(Movie::getMovieName);

        movies.sort(howToSort);
        return movies;
    }

    public boolean hasBookTitleInLibrary(String title) {
        return booksInLibrary.containsKey(title);
    }

    public boolean hasMovieNameInLibrary(String name) { return moviesInLibrary.containsKey(name); }
}
