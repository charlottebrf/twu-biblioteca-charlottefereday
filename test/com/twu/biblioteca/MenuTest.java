package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    Library library = new Library();
    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowling"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowling"), new Year(1998));
    Movie killBill = new Movie(new MovieName("Kill Bill"), new Year(2002), new Director("Quentin Tarantino"), new MovieRating(5));
    Movie cinderella = new Movie(new MovieName("Cinderella"), new Year(2015), new Director("Kenneth Branagh"), new MovieRating());
    Printer printer = new Printer();
    LibraryRegister register = new LibraryRegister();


    int num = 1234567;
    LibraryNumber libnum = new LibraryNumber(num);
    int num2 = 7689000;
    LibraryNumber libnum2 = new LibraryNumber(num2);
    Password password = new Password("abcdefgh");
    UserLogin login = new UserLogin(libnum, password);

    UserName userName = new UserName("Charlotte Fereday");
    UserEmailAddress email = new UserEmailAddress("foo@foo.com");
    BigInteger cell = new BigInteger("0123456789");
    UserPhoneNumber number = new UserPhoneNumber(cell);
    UserAccount account = new UserAccount(login, userName, email, number);


    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream(stringy.getBytes());
    }
    java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();


    Menu menu = new Menu(account, library, printer, register);

    @Before
    public void setUp() {
        menu = new Menu(account, library, printer, register);
        library.addBooks(hP2);
        library.addBooks(harryPotter1);
        library.addMovies(killBill);
        library.addMovies(cinderella);
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
        register.addMoviesToRegister(killBill);
        register.addMoviesToRegister(cinderella);
        account.addBooksToAccount(hP2);
    }


    @Test
    public void givesAMesageforAnInvalidOption() {
        System.setOut(new java.io.PrintStream(outputStream));
        System.out.print("Select a valid option!");
        assertEquals(outputStream.toString(), menu.checkIsValidOption());
    }



    @Test
    public void aValidLoginCanUseCheckoutOrReturnServices() {
        Keyboard username1 = new Keyboard(toStream("1234567\nabcdefgh\n"));
        Menu menu2 = new Menu(account, library, printer, register, username1);

        assertEquals(true, menu2.userLogin());
    }

    @Test
    public void InvalidLoginCannotUseCheckoutOrReturnServices() {
        Keyboard username1 = new Keyboard(toStream("67\nabcdefgh\n"));
        Menu menu2 = new Menu(account, library, printer, register, username1);

        assertEquals(false, menu2.userLogin());
    }

    @Test
    public void validUserCanSeeTheirAccountDetails() {
        System.setOut(new java.io.PrintStream(outputStream));
        System.out.print("You have chosen to view your account details. Please find this listed below:");
        Keyboard username1 = new Keyboard(toStream("1234567\nabcdefgh\n"));
        Menu menu2 = new Menu(account, library, printer, register, username1);

        assertEquals(outputStream.toString(), menu2.seeAccountDetails());
    }
}