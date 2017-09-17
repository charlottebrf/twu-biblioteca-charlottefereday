package com.twu.biblioteca;

public class Menu {
    private final Library library;
    private final Book book;
    private final Printer printer;
    private final Keyboard keyboard;


    public Menu(Library library, Book book, Printer printer, Keyboard keyboard) {
        this.library = library;
        this.book = book;
        this.printer = printer;
        this.keyboard = keyboard;
    }

    public Menu(Library library, Book book, Printer printer) {
        this(library, book, printer, new Keyboard());
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
        if (library.hasBookTitleInLibrary(title)) {
            return printer.display("That book is not available.");
        } else {
            return printer.display("Thank you! Enjoy the book");
        }
    }

    public String returnedSuccessOrFailureMessage(String title) {
        if (library.hasBookTitleInLibrary(title)) {
            return printer.display("Thank you for returning the book.");
        } else {
            return printer.display("That is not a valid book to return.");
        }
    }

    //Todo: figure out how I can get the scanner object in here so line 33 can work & refactor as very long
    //Todo: think about responsbility - is the menu the correct place or should this be refactored to the library to check books & printer class to console log
//    Todo: fix this to add in a book registry: which keeps track of all the books & also asks the user for the title, year & date
    public String checkOutBook() {
        String title = keyboard.read();
        if (library.hasBookTitleInLibrary(title)) {
            printer.display("You have chosen to check out a book, redirecting you now");
            Book checkedOutBook = library.findBookFromTitle();
            library.removeBooks(checkedOutBook);
            return checkedOutSuccessOrFailureMessage(title);
        } else {
            return checkedOutSuccessOrFailureMessage(title);
        }
    }

    public String returnBook() {
        String title = keyboard.read();
        //Todo: can't return the book as no book will be returned
        if (!library.hasBookTitleInLibrary(title)) {
            printer.display("You have chosen to return a book, redirecting you now");
//            Todo: fix this to add in a book registry: which keeps track of all the books & also asks the user for the title, year & date
            Book returnedBook = library.findBookFromTitle();
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


