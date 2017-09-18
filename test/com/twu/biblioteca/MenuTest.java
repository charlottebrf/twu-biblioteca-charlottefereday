package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    Library library = new Library();
    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowling"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowling"), new Year(1998));
    Movie killBill = new Movie(new MovieName("Kill Bill"), new Year(2002), new Director("Quentin Tarantino"), new MovieRating(5));
    Movie cinderella = new Movie(new MovieName("Cinderella"), new Year(2015), new Director("Kenneth Branagh"), new MovieRating());
    Printer printer = new Printer();
    LibraryRegister register = new LibraryRegister();

    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream(stringy.getBytes());
    }

    Menu menu = new Menu(library, printer, register);

    @Before
    public void setUp() {
        menu = new Menu(library, printer, register);
        library.addBooks(hP2);
        library.addBooks(harryPotter1);
        library.addMovies(killBill);
        library.addMovies(cinderella);
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
    }

//    "1. List Books\n2. List Movies\n3. Checkout Books\n4. Checkout Movies\n5. Return Books\n6. Exit"

    @Test
    public void canDisplayBooksInLibrary() {
        assertEquals("|Harry Potter and the Chamber of Secrets|J.K.Rowling|1998|\n|Harry Potter and the Philosopher's Stone|J.K.Rowling|1997|\n",
                menu.process("1"));
    }

    @Test
    public void canDisplayMoviesInLibrary() {
        assertEquals("|Cinderella|2015|Kenneth Branagh|0|\n|Kill Bill|2002|Quentin Tarantino|5|\n", menu.process("2"));
    }

    @Test
    public void givesAMesageforAnInvalidOption() {
        assertEquals("Select a valid option!", menu.process("x"));
    }


    @Test
    public void givesAQuitOption() {
        assertEquals("You have selected quit: exiting the program now", menu.process("6"));
    }

    @Test
    public void willCheckOutAnAvailableBook() {
        Keyboard keyboard = new Keyboard(toStream("Harry Potter and the Philosopher's Stone"));
        Library lib2 = new Library(keyboard);
        lib2.addBooks(hP2);
        lib2.addBooks(harryPotter1);
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
        Menu menu2 = new Menu(lib2, printer, register, keyboard);

        assertEquals("Thank you! Enjoy the book", menu2.process("3"));
    }

    @Test
    public void willCheckOutAnAvailableMovie() {
        Keyboard keyboard = new Keyboard(toStream("Kill Bill"));
        Library lib3 = new Library(keyboard);
        lib3.addMovies(cinderella);
        lib3.addMovies(killBill);
        register.addMoviesToRegister(cinderella);
        register.addMoviesToRegister(killBill);
        Menu menu3 = new Menu(lib3, printer, register, keyboard);

        assertEquals("Thank you! Enjoy the movie", menu3.process("4"));
    }

    @Test
    public void willNotCheckOutAnUnavailableBook() {
        Keyboard keyboard = new Keyboard(toStream("heqvdkjewvcjms"));
        Library lib2 = new Library(keyboard);
        lib2.addBooks(hP2);
        lib2.addBooks(harryPotter1);
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
        Menu menu3 = new Menu(lib2, printer, register, keyboard);

        assertEquals("That book is not available.", menu3.process("2"));
    }

    @Test
    public void willReturnABookIfNotInLibrary() {
        Keyboard keyboard = new Keyboard(toStream("Harry Potter and the Philosopher's Stone"));
        Library lib2 = new Library(keyboard);
        Menu menu2 = new Menu(lib2, printer, register, keyboard);
        lib2.addBooks(hP2);
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
        assertEquals("Thank you for returning the book.", menu2.process("3"));
    }

    @Test
    public void willNotReturnABookIfAlreadyInLibrary() {
        Keyboard keyboard = new Keyboard(toStream("heqvdkjewvcjms"));
        Library lib2 = new Library(keyboard);
        Menu menu2 = new Menu(lib2, printer, register, keyboard);
        lib2.addBooks(hP2);
        lib2.addBooks(harryPotter1);
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
        assertEquals("That is not a valid book to return.", menu2.process("3"));
    }
}