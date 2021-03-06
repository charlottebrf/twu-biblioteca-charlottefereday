package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));
    Movie killBill = new Movie(new MovieName("Kill Bill"), new Year(2002), new Director("Quentin Tarantino"), new MovieRating(5));
    Movie cinderella = new Movie(new MovieName("Cinderella"), new Year(2015), new Director("Kenneth Branagh"), new MovieRating());
    Library lib = new Library();

    @Before
    public void setUp() {
        lib = new Library();
        lib.addBooks(harryPotter1);
        lib.addBooks(hP2);
        lib.addMovies(killBill);
        lib.addMovies(cinderella);
    }

    @Test
    public void addsABookToTheLibrary() {
        LinkedList<Book> expectedBooksInLib = new LinkedList<Book>();
        expectedBooksInLib.add(hP2);
        expectedBooksInLib.add(harryPotter1);

        assertEquals(expectedBooksInLib, lib.getBooks());
    }

    @Test
    public void addsAMovieToTheLibrary() {
        LinkedList<Movie> expectedMoviesInLib = new LinkedList<>();
        expectedMoviesInLib.add(killBill);
        expectedMoviesInLib.add(cinderella);

        assertEquals(expectedMoviesInLib, lib.getMovies());
    }

    @Test
    public void getsABookTitleFromTheLibrary() {
        LinkedList<String> title = new LinkedList<String>();
        title.add(harryPotter1.title.getTitle());
        title.add(hP2.title.getTitle());
        Collections.sort(title);

        assertEquals(title, lib.getBookTitles());
    }

    @Test
    public void getsAMovieNameFromTheLibrary() throws Exception {
        LinkedList<String> names = new LinkedList<>();
        names.add(killBill.getMovieName());
        names.add(cinderella.getMovieName());
        Collections.sort(names);

        assertEquals(names, lib.getMovieNames());
    }

    @Test
    public void getsAllBookInformationFromTheLibrary() {
        assertEquals("|Harry Potter and the Chamber of Secrets|J.K.Rowlng|1998|\n|Harry Potter and the Philosopher's Stone|J.K.Rowlng|1997|\n", lib.getBookDetails());
    }

    @Test
    public void getsAllMovieInformationFromTheLibrary() {
        assertEquals("|Cinderella|2015|Kenneth Branagh|0|\n|Kill Bill|2002|Quentin Tarantino|5|\n", lib.getMovieDetails());
    }

    @Test
    public void updatesListOfBooksOnceABookHasBeenCheckedOut() {
        lib.removeBooks(hP2);
        LinkedList<String> title = new LinkedList<String>();
        String hpTitle = new BookTitle("Harry Potter and the Philosopher's Stone").getTitle();
        title.add(hpTitle);

        assertEquals(title, lib.getBookTitles());
    }

    @Test
    public void updatesListOfMoviesOnceAMovieHasBeenCheckedOut() {
        lib.removeMovies(cinderella);
        LinkedList<String> name = new LinkedList<>();
        String killBillName = new MovieName("Kill Bill").getName();
        name.add(killBillName);

        assertEquals(name, lib.getMovieNames());
    }

    @Test
    public void returnsABookObjectWhenGivenABookTitle() {
        assertEquals(harryPotter1, lib.findBookFromTitle(harryPotter1.title.getTitle()));
    }

    @Test
    public void returnsAMovieObjectWhenGivenAMovieName() {
        assertEquals(killBill, lib.findMovieFromName(killBill.getMovieName()));
    }

    @Test
    public void returnsNoBookObjectWhenGivenANonExistentBookTitle() {
        assertEquals(Book.NO_BOOK, lib.findBookFromTitle("heqvdkjewvcjms"));
    }

    @Test
    public void returnsNoMovieObjectWhenGivenANonExistentMovieTitle() {
        assertEquals(Movie.NO_MOVIE, lib.findMovieFromName("heqvdkjewvcjms"));
    }

    @Test
    public void returnsFalseIfBookIsNotInTheLibrary() {
        lib.removeBooks(hP2);
        String title = hP2.title.getTitle();

        assertEquals(false, lib.hasBookTitleInLibrary(title));
    }

    @Test
    public void returnsFalseIfMovieIsNotInTheLibrary() throws Exception {
        lib.removeMovies(cinderella);
        String name = cinderella.getMovieName();

        assertEquals(false, lib.hasMovieNameInLibrary(name));
    }

    @Test
    public void returnsTrueIfBookIsInTheLibrary() {
        String title = hP2.title.getTitle();

        assertEquals(true, lib.hasBookTitleInLibrary(title));
    }

    @Test
    public void returnsTrueIfMovieIsInTheLibrary() {
        String name = killBill.getMovieName();

        assertEquals(true, lib.hasMovieNameInLibrary(name));
    }
}