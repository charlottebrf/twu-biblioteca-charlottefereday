package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ChecksOutMoviesCommandTest {
    Library library = new Library();
    Movie cinderella = new Movie(new MovieName("Cinderella"), new Year(2015), new Director("Kenneth Branagh"), new MovieRating());
    LibraryRegister register = new LibraryRegister();
    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream(stringy.getBytes());
    }

    @Before
    public void setUp() {
        library.addMovies(cinderella);
        register.addMoviesToRegister(cinderella);
    }

    @Test
    public void checksOutAMovie() {
        Keyboard keyboard = new Keyboard(toStream("Cinderella"));
        FakePrinter fakePrinter = new FakePrinter();
        ChecksOutMoviesCommand command = new ChecksOutMoviesCommand(library, fakePrinter, keyboard, register );
        command.execute();
        assertEquals("Thank you! Enjoy the movie", fakePrinter.output());
    }

    @Test
    public void doesNotCheckOutAMovieNotInLibrary() {
        Keyboard keyboard = new Keyboard(toStream("wfEFS"));
        FakePrinter fakePrinter = new FakePrinter();
        ChecksOutMoviesCommand command = new ChecksOutMoviesCommand(library, fakePrinter, keyboard, register );
        command.execute();
        assertEquals("That movie is not available", fakePrinter.output());
    }
}