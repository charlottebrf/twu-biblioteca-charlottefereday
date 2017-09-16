package com.twu.biblioteca;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

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

    //Todo: change any strings printed here to be printed by the printer as console logs

    public String checkIsValidOption() {
        System.out.println("Select a valid option!");
        return this.exitProgram();
    }

    public String exitProgram() {
        System.out.println("You have selected quit: exiting the program now");
        return "";
    }

    public String checkedOutSuccessOrFailureMessage(String stringifiedTitle) {
        String message = "";
        if (library.hasBookTitleInLibrary(stringifiedTitle)) {
            message = "That book is not available.";
        } else {
            message = "Thank you! Enjoy the book";
        }
        return message;
    }

    public String returnedSuccessOrFailureMessage(String stringifiedTitle) {
        String message = "";
        if (library.hasBookTitleInLibrary(stringifiedTitle)) {
            message = "Thank you for returning the book.";
        } else {
            message = "That is not a valid book to return.";
        }
        return message;
    }

    //Todo: figure out how I can get the scanner object in here so line 33 can work & refactor as very long
    //Todo: think about responsbility - is the menu the correct place or should this be refactored to the library to check books & printer class to console log
//    Todo: fix this to add in a book registry: which keeps track of all the books & also asks the user for the title, year & date
    public String checkOutBook() {
        String title = keyboard.read();
        if (library.hasBookTitleInLibrary(title)) {
            printer.checkOutMessage();
            Book checkedOutBook = library.findBookFromTitle();
            library.removeBooks(checkedOutBook);
        }
        return checkedOutSuccessOrFailureMessage(title);
    }

    public String returnBook() {
        String title = keyboard.read();
        //Todo: can't return the book as no book will be returned
        if (!library.hasBookTitleInLibrary(title)) {
            printer.returnMessage();

//            Todo: fix this to add in a book registry: which keeps track of all the books & also asks the user for the title, year & date
//            library.addBooks(title);
        }
        return returnedSuccessOrFailureMessage(title);
    }

    //    //Todo: figure out how I can get the scanner object in here so line 33 can work
    public String process(String selection) {
        String menuChoice = "";
        switch (selection) {
            case "1":  menuChoice = library.getBookDetails();
                break;
            case "2": menuChoice = checkOutBook();
                break;
            case "3": menuChoice = returnBook();
                break;
            default: menuChoice = checkIsValidOption();
                break;
            case "4": return exitProgram();
        }
        return menuChoice;
    }

}


