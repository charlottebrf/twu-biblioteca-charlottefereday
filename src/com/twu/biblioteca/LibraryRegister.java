package com.twu.biblioteca;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LibraryRegister {

    private Map<String, Book> booksInRegister;
    private Map<String, Movie> moviesInRegister;
    private final Keyboard keyboard;

    public LibraryRegister(Keyboard keyboard) {
        booksInRegister = new HashMap<String, Book>();
        moviesInRegister = new HashMap<String, Movie>();
        this.keyboard = keyboard;
    }

    public LibraryRegister() {
        this(new Keyboard());
    }

    public void addBooksToRegister(Book book) { booksInRegister.put(book.title.getTitle(), book); }

    public void addMoviesToRegister(Movie movie) { moviesInRegister.put(movie.getMovieName(), movie);}

    public List<Book> getBooksInRegister() {
        return new LinkedList<>(booksInRegister.values());
    }

    public List<Movie> getMoviesInRegister() { return  new LinkedList<>(moviesInRegister.values());}

    public Book findBookInRegisterFromTitle(String desiredTitle) {
        return booksInRegister.getOrDefault(desiredTitle, Book.NO_BOOK);
    }

    public Movie findMovieInRegisterFromName(String desiredName) {
        return moviesInRegister.getOrDefault(desiredName, Movie.NO_MOVIE);
    }

    public void removesBooksFromRegister(Book book) { booksInRegister.remove(book.title.getTitle());}

    public void removesMoviesFromRegister(Movie movie) { moviesInRegister.remove(movie.getMovieName());}

    public boolean hasBookTitleInRegister(String title) { return booksInRegister.containsKey(title);}

    public boolean hasMovieNameInRegister(String name) { return moviesInRegister.containsKey(name);}
}
