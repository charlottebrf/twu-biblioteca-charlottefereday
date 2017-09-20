package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayMoviesCommandTest {
    Library library = new Library();
    Movie cinderella = new Movie(new MovieName("Cinderella"), new Year(2015), new Director("Kenneth Branagh"), new MovieRating());

    @Test
    public void listsMoviesInLibrary() {
        library.addMovies(cinderella);
        FakePrinter fakePrinter = new FakePrinter();
        DisplayMoviesCommand command = new DisplayMoviesCommand(library, fakePrinter);
        command.execute();

        assertEquals("|Film Name|Year|Director|Rating|\n|Cinderella|2015|Kenneth Branagh|0|\n", fakePrinter.output());
    }
}