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
        booksInLibrary.put(book.getBookTitle(), book);
    }

    public void addMovies(Movie movie) { moviesInLibrary.put(movie.getMovieName(), movie);}

    public void removeBooks(Book book) {
        booksInLibrary.remove(book.getBookTitle());
    }

    public void removeMovies(Movie movie) { moviesInLibrary.remove(movie.getMovieName());}

    public List<Book> getBooks() {
        return new LinkedList<>(booksInLibrary.values());
    }

    public List<Movie> getMovies() { return new LinkedList<>(moviesInLibrary.values()); }

    public List<String> getBookTitles() {
        List<String> titles = booksInLibrary.values().stream().map(book -> book.getBookTitle()).collect(toList());
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

    public String getBookDetails() {
        String bookDetails = "";
        for (Book book : sortedBooks()) {
            bookDetails += "|" + book.getBookTitle() + "|" + book.getBookAuthor() + "|" + book.getBookYear() + "|" + "\n";
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

        Comparator<Book> howToSort = Comparator.comparing(Book::getBookTitle);

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
}
