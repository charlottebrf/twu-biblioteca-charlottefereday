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

//    public Menu() {
//        this(new Keyboard());
//    }

//    public Menu(Library library, Book book, Printer printer) {
//        this(new Keyboard());
//        this.library = library;
//        this.book = book;
//        this.printer = printer;
//    }
//
//    public Menu(Keyboard keyboard) {
//    }

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
    public String checkOutBook() {
        String stringifiedTitle = keyboard.read();
        if (library.hasBookTitleInLibrary(stringifiedTitle)) {
            printer.checkOutMessage();
            Book checkedOutBook = library.findBookFromTitle();
            library.removeBooks(checkedOutBook);
        }
        return checkedOutSuccessOrFailureMessage(stringifiedTitle );
    }

    public String returnBook() {
        String stringifiedTitle = keyboard.read();
        if (!library.hasBookTitleInLibrary(stringifiedTitle)) {
            printer.returnMessage();
            Book returnedBook = library.findBookFromTitle();
            library.addBooks(returnedBook);
        }
        return returnedSuccessOrFailureMessage(stringifiedTitle);
    }

    //    //Todo: figure out how I can get the scanner object in here so line 33 can work
    public String process() {
        String selection = keyboard.read();
        String menuChoice = "";
        switch (selection) {
            case "1":  menuChoice = this.library.getBookDetails();
                break;
            case "2": menuChoice = this.checkOutBook();
                break;
            case "3": menuChoice = this.returnBook();
                break;
            default: menuChoice = this.checkIsValidOption();
                break;
            case "4": return this.exitProgram();
        }
        return menuChoice;
    }

}


