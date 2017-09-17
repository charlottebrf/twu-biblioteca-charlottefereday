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

    public void checkIsValidOption() {
        printer.selectValidOptionMessage();
        exitProgram();
    }

    public void exitProgram() {
        printer.exitMenuMessage();
        System.exit(0);
    }

    public void checkedOutSuccessOrFailureMessage(String title) {
        if (library.hasBookTitleInLibrary(title)) {
            printer.notAvailableMessage();
        } else {
            printer.availableMessage();
        }
    }

    public void returnedSuccessOrFailureMessage(String title) {
        if (library.hasBookTitleInLibrary(title)) {
            printer.returnedMessage();
        } else {
            printer.notReturnedMessage();
        }
    }

    //Todo: figure out how I can get the scanner object in here so line 33 can work & refactor as very long
    //Todo: think about responsbility - is the menu the correct place or should this be refactored to the library to check books & printer class to console log
//    Todo: fix this to add in a book registry: which keeps track of all the books & also asks the user for the title, year & date
    public void checkOutBook() {
        String title = keyboard.read();
        if (library.hasBookTitleInLibrary(title)) {
            printer.checkOutMessage();
            Book checkedOutBook = library.findBookFromTitle();
            library.removeBooks(checkedOutBook);
            checkedOutSuccessOrFailureMessage(title);
        } else {
            checkedOutSuccessOrFailureMessage(title);
        }
    }

    public void returnBook() {
        String title = keyboard.read();
        //Todo: can't return the book as no book will be returned
        if (!library.hasBookTitleInLibrary(title)) {
            printer.returnMessage();
            returnedSuccessOrFailureMessage(title);
//            Todo: fix this to add in a book registry: which keeps track of all the books & also asks the user for the title, year & date
//            library.addBooks(title);
        } else {
            returnedSuccessOrFailureMessage(title);
        }
    }

    public void process(String selection) {
        switch (selection) {
            case "1":  library.getBookDetails();
                break;
            case "2": checkOutBook();
                break;
            case "3": returnBook();
                break;
            default: checkIsValidOption();
                break;
            case "4": exitProgram();
                break;
        }
    }

}


