package com.twu.biblioteca;

public class Menu {
    private final Library library;
    private final Book book;
    private final Printer printer;
    private final Keyboard keyboard;
    private final BookRegister register;


    public Menu(Library library, Book book, Printer printer, BookRegister register, Keyboard keyboard) {
        this.library = library;
        this.book = book;
        this.printer = printer;
        this.register = register;
        this.keyboard = keyboard;
    }

    public Menu(Library library, Book book, Printer printer, BookRegister register) {
        this(library, book, printer, register, new Keyboard());
    }

    //todo: properly format the strings
    public String displayLibraryBooks() {
        String bookList = "";
        bookList = library.getBookDetails();
        String header = printer.display("|              Book Title               |   Author  | Year|\n");
        printer.display(header + bookList);
        return header + bookList;
    }

    //todo: refactor to be able to invoke exitProgram()
    public String checkIsValidOption() {
        return printer.display("Select a valid option!");
//        exitProgram();
    }

    //todo: refactor to be able to invoke exitProgram()
    public String exitProgram() {
        return printer.display("You have selected quit: exiting the program now");
//        System.exit(0);
    }

    public String checkedOutSuccessOrFailureMessage(String title) {
        if (library.findBookFromTitle(title) == Book.NO_BOOK && register.hasBookTitleInRegister(title) ) {
            return printer.display("Thank you! Enjoy the book");
        } else {
            return printer.display("That book is not available.");
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
        String title = keyboard.read();
        if (register.hasBookTitleInRegister(title) && library.hasBookTitleInLibrary(title) ) {
            printer.display("You have chosen to check out a book, redirecting you now");
            Book checkedOutBook = library.findBookFromTitle(title);
            library.removeBooks(checkedOutBook);
            return checkedOutSuccessOrFailureMessage(title);
        } else {
            return checkedOutSuccessOrFailureMessage(title);
        }
    }

    public String returnBook() {
        String title = keyboard.read();
        if (register.hasBookTitleInRegister(title) && !library.hasBookTitleInLibrary(title)) {
            printer.display("You have chosen to return a book, redirecting you now");
            Book returnedBook = register.findBookInRegisterFromTitle(title);
            library.addBooks(returnedBook);
            return returnedSuccessOrFailureMessage(title);
        } else {
            return returnedSuccessOrFailureMessage(title);
        }
    }

    public String process(String selection) {
        String result = "";
        switch (selection) {
            case "1":  result = displayLibraryBooks();
                break;
            case "2": result = checkOutBook();
                break;
            case "3": result = returnBook();
                break;
            case "4": result = exitProgram();
                break;
            default: result = checkIsValidOption();
                break;
        }
        return result;
    }

}


