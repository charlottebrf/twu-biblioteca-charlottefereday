package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class LibraryRegisterTest {
    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));
    Movie killBill = new Movie(new MovieName("Kill Bill"), new Year(2002), new Director("Quentin Tarantino"), new MovieRating(5));
    Movie cinderella = new Movie(new MovieName("Cinderella"), new Year(2015), new Director("Kenneth Branagh"), new MovieRating());

    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream(stringy.getBytes());
    }

    LibraryRegister register = new LibraryRegister();

    @Before
    public void setUp() throws Exception {
        register = new LibraryRegister();
        register.addBooksToRegister(harryPotter1);
        register.addBooksToRegister(hP2);
        register.addMoviesToRegister(killBill);
        register.addMoviesToRegister(cinderella);
    }

    @Test
    public void booksCanBeAddedToRegister() {
        LinkedList<Book> expectedBooksInRegister = new LinkedList<Book>();
        expectedBooksInRegister.add(hP2);
        expectedBooksInRegister.add(harryPotter1);

        assertEquals(expectedBooksInRegister, register.getBooksInRegister());
    }

    @Test
    public void moviesCanBeAddedToRegister() {
        LinkedList<Movie> expectedMoviesInRegister = new LinkedList<Movie>();
        expectedMoviesInRegister.add(killBill);
        expectedMoviesInRegister.add(cinderella);

        assertEquals(expectedMoviesInRegister, register.getMoviesInRegister());
    }

    @Test
    public void bookTitlesCanBeSearchedForInRegister() {
        assertEquals(harryPotter1, register.findBookInRegisterFromTitle("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void movieNamesCanBeSearchedForInRegister() {
        assertEquals(killBill, register.findMovieInRegisterFromName("Kill Bill"));
    }

    @Test
    public void returnsNoBookWhenNotFoundFromRegister() {
        assertEquals(Book.NO_BOOK, register.findBookInRegisterFromTitle("heqvdkjewvcjms"));
    }

    @Test
    public void returnsNoMovieWhenNotFoundInRegister() {
        assertEquals(Movie.NO_MOVIE, register.findMovieInRegisterFromName("heqvdkjewvcjms"));
    }

    @Test
    public void booksCanBeRemovedFromRegister() {
        LinkedList<Book> expectedBooksInRegister = new LinkedList<Book>();
        expectedBooksInRegister.add(hP2);
        register.removesBooksFromRegister(harryPotter1);

        assertEquals(expectedBooksInRegister, register.getBooksInRegister());
    }

    @Test
    public void moviesCanBeRemovedFromRegister() {
        LinkedList<Movie> expectedMoviesInRegister = new LinkedList<Movie>();
        expectedMoviesInRegister.add(cinderella);
        register.removesMoviesFromRegister(killBill);

        assertEquals(expectedMoviesInRegister, register.getMoviesInRegister());
    }

    @Test
    public void returnsTrueIfBookIsPresent() {
        assertEquals(true, register.hasBookTitleInRegister("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void returnsTrueIfMovieIsPresent() {
        assertEquals(true, register.hasMovieNameInRegister("Kill Bill"));
    }

    @Test
    public void returnsFalseIfBookIsNotPresent() {
        assertEquals(false, register.hasBookTitleInRegister("heqvdkjewvcjms"));
    }

    @Test
    public void returnsFalseIfMovieIsNotPresent() {
        assertEquals( false, register.hasMovieNameInRegister("heqvdkjewvcjms"));
    }
}