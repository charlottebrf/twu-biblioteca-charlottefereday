package com.twu.biblioteca;

import java.math.BigInteger;

public class BibliotecaApp {
    private final Printer printer;
    private final Library library;
    private final Menu menu;
    private final Keyboard keyboard;

    public BibliotecaApp(Printer printer, Library library, Menu menu, Keyboard keyboard) {
        this.printer = printer;
        this.library = library;
        this.menu = menu;
        this.keyboard = keyboard;
    }

    public void printWelcome() {
        printer.display("Welcome to the new Biblioteca App: we are open for business!");
    }


    public void interactiveMenu() {
        String userInput = "";
        while (userInput.equals("")) {
            menu.printMainMenu();
            userInput = keyboard.read();
            userInput = menu.process(userInput);
        }
       return;
    }

    public static void main(String[] args) {
        Library library = new Library();
        Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
        Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));
        Book alphabet = new Book(new BookTitle("AAA"), new Author("BBBB"), new Year(2009));
        Movie killBill = new Movie(new MovieName("Kill Bill"), new Year(2002), new Director("Quentin Tarantino"), new MovieRating(5));
        Movie cinderella = new Movie(new MovieName("Cinderella"), new Year(2015), new Director("Kenneth Branagh"), new MovieRating());
        Movie alphabet2 = new Movie(new MovieName("AAA"), new Year(1111), new Director("BBB"), new MovieRating());
        library.addBooks(harryPotter1);
        library.addBooks(hP2);
        library.addMovies(killBill);
        library.addMovies(cinderella);
        library.addMovies(alphabet2);
        LibraryRegister register = new LibraryRegister();
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
        register.addBooksToRegister(alphabet);
        register.addMoviesToRegister(killBill);
        register.addMoviesToRegister(cinderella);
        register.addMoviesToRegister(alphabet2);

        int num = 1234567;
        LibraryNumber libnum = new LibraryNumber(num);
        Password password = new Password("abcdefgh");
        UserLogin login = new UserLogin(libnum,password);
        UserName userName = new UserName("Charlotte Fereday");
        UserEmailAddress email = new UserEmailAddress("foo@foo.com");
        BigInteger cell = new BigInteger("0123456789");
        UserPhoneNumber number = new UserPhoneNumber(cell);
        UserAccount account = new UserAccount(login, userName, email, number);
        account.addBooksToAccount(harryPotter1);

        Printer printer = new Printer();
        Keyboard keyboard = new Keyboard();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printer, library, new Menu(account, library, printer, register, keyboard), keyboard);

        bibliotecaApp.printWelcome();
        bibliotecaApp.interactiveMenu();
    }

}



