package com.twu.biblioteca;

import sun.security.util.Password;

public class Menu {
    private final Library library;
    private final Printer printer;
    private final Keyboard keyboard;
    private final LibraryRegister register;
    private final UserAccount account;

    public Menu(UserAccount account, Library library, Printer printer, LibraryRegister register, Keyboard keyboard) {
        this.account = account;
        this.library = library;
        this.printer = printer;
        this.register = register;
        this.keyboard = keyboard;
    }

    public Menu(UserAccount account, Library library, Printer printer, LibraryRegister register) {
        this(account, library, printer, register, new Keyboard());
    }

    public String displayLibraryBooks() {
        String header = "|              Book Title               |   Author  | Year|\n";
        printer.display(header + library.getBookDetails());
        return library.getBookDetails();
    }

    public String displayLibraryMovies() {
        String header = "|Film Name|Year|Director|Rating|\n";
        printer.display(header + library.getMovieDetails());
        return library.getMovieDetails();
    }

    public String checkIsValidOption() {
        return printer.display("Select a valid option!");
    }

    public String exitProgram() {
        return printer.display("You have selected quit: exiting the program now");
    }

    public String checkedOutSuccessOrFailureMessage(String title) {
        if (library.findBookFromTitle(title) == Book.NO_BOOK && register.hasBookTitleInRegister(title)) {
            return printer.display("Thank you! Enjoy the book");
        } else {
            return printer.display("That book is not available.");
        }
    }

    //Todo: see if possible to refactor movie additions so not duplicating code

    public String checkedOutMovieSuccessOrFailureMessage(String name) {
        if(library.findMovieFromName(name) == Movie.NO_MOVIE && register.hasMovieNameInRegister(name)) {
            return printer.display("Thank you! Enjoy the movie");
        } else {
            return printer.display("That movie is not available.");
        }
    }

    public String returnedSuccessOrFailureMessage(String title) {
        if (library.findBookFromTitle(title) != Book.NO_BOOK && register.hasBookTitleInRegister(title)) {
            return printer.display("Thank you for returning the book.");
        } else {
            return printer.display("That is not a valid book to return.");
        }
    }

    public String checkOutBook() {
        String title;
        if (userLogin()) {
            printer.display("You have chosen to check out a book. Please enter the title of the book you'd like to check out:");
            title = keyboard.read();
        } else {
            return exitProgram();
        }

        if (register.hasBookTitleInRegister(title) && library.hasBookTitleInLibrary(title)) {
            Book checkedOutBook = library.findBookFromTitle(title);
            library.removeBooks(checkedOutBook);
            return checkedOutSuccessOrFailureMessage(title);
        } else {
            return checkedOutSuccessOrFailureMessage(title);
        }
    }


    public String checkOutMovie() {
        printer.display("You haven chosen to check out a movie. Please enter the name of the movie you'd like to check out:");
        String name = keyboard.read();
        if(register.hasMovieNameInRegister(name) && library.hasMovieNameInLibrary(name)) {
            Movie checkedOuMovie = library.findMovieFromName(name);
            library.removeMovies(checkedOuMovie);
            return checkedOutMovieSuccessOrFailureMessage(name);
        } else {
            return checkedOutMovieSuccessOrFailureMessage(name);
        }
    }

    public String returnBook() {
        printer.display("You have chosen to return a book. Please enter the title of the book you'd like to return:");
        String title = keyboard.read();
        if (register.hasBookTitleInRegister(title) && !library.hasBookTitleInLibrary(title)) {
            Book returnedBook = register.findBookInRegisterFromTitle(title);
            library.addBooks(returnedBook);
            return returnedSuccessOrFailureMessage(title);
        } else {
            return returnedSuccessOrFailureMessage(title);
        }
    }

    public boolean userLogin() {
        printer.display("To complete this action, you will first need to sign in. Please enter your Library number:");
        LibraryNumber convertedLibraryNumber = keyboard.readLibraryNumber();
        printer.display("Please now enter you password:");
        com.twu.biblioteca.Password convertedPassword = keyboard.readPassword();
        return account.login.isValid(convertedLibraryNumber, convertedPassword);
    }

    public String process(String selection) {
        String result = "";
        switch (selection) {
            case "1":
                result = displayLibraryBooks();
                break;
            case "2":
                result = displayLibraryMovies();
                break;
            case "3":
                result = checkOutBook();
                break;
            case "4":
                result = checkOutMovie();
                break;
            case "5":
                result = returnBook();
                break;
            case "6":
                result = exitProgram();
                break;
            default:
                result = checkIsValidOption();
                break;
        }
        return result;
    }

}


