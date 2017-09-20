package com.twu.biblioteca;

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
        return header + library.getBookDetails();
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
            return checkIsValidOption();
        }

        if (register.hasBookTitleInRegister(title) && library.hasBookTitleInLibrary(title)) {
            Book checkedOutBook = library.findBookFromTitle(title);
            library.removeBooks(checkedOutBook);
            account.addBooksToAccount(checkedOutBook);
            return checkedOutSuccessOrFailureMessage(title);
        } else {
            return checkedOutSuccessOrFailureMessage(title);
        }
    }


    public String checkOutMovie() {
        String name;
            printer.display("You haven chosen to check out a movie. Please enter the name of the movie you'd like to check out:");
            name = keyboard.read();
        if(register.hasMovieNameInRegister(name) && library.hasMovieNameInLibrary(name)) {
            Movie checkedOutMovie = library.findMovieFromName(name);
            library.removeMovies(checkedOutMovie);
            return checkedOutMovieSuccessOrFailureMessage(name);
        } else {
            return checkedOutMovieSuccessOrFailureMessage(name);
        }
    }

    public String returnBook() {
        String title;
        if (userLogin()) {
            printer.display("You have chosen to return a book. Please enter the title of the book you'd like to return:");
            title = keyboard.read();
        } else {
            return checkIsValidOption();
        }

        if (register.hasBookTitleInRegister(title) && !library.hasBookTitleInLibrary(title)) {
            Book returnedBook = register.findBookInRegisterFromTitle(title);
            library.addBooks(returnedBook);
            account.removeBooksFromAccount(returnedBook);
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

    public String seeAccountDetails() {
        if (userLogin()) {
            printer.display("You have chosen to view your account details. Please find this listed below:");
            printer.display("User Name:" + account.getUserName() );
            printer.display("Email address:" + account.getUserEmailAddress());
            printer.display("Phone number:" + account.getUserNumber());
            return "You have chosen to view your account details. Please find this listed below:";
        } else {
            return exitProgram();
        }
    }

    public String process(String selection) {
        String result = "";
        switch (selection) {
            case "1":
                displayLibraryBooks();
                break;
            case "2":
                displayLibraryMovies();
                break;
            case "3":
                checkOutBook();
                break;
            case "4":
                checkOutMovie();
                break;
            case "5":
               returnBook();
                break;
            case "6":
                return exitProgram();
            case "7":
                seeAccountDetails();
                break;
            default:
                checkIsValidOption();
                break;
        }
        return result;
    }

}


