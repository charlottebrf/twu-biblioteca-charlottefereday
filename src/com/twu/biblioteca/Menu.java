package com.twu.biblioteca;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Menu {
    private final Library library;
    private final Book book;
    private final Printer printer;

    public Menu(Library library, Book book, Printer printer) {
        this.library = library;
        this.book = book;
        this.printer = printer;
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
        if (library.hasBookTitleInLibrary(stringifiedTitle) == true) {
            message = "That book is not available.";
        } else if (library.hasBookTitleInLibrary(stringifiedTitle) == false) {
            message = "Thank you! Enjoy the book";
        }
        return message;
    }

    public String returnedSuccessOrFailureMessage(String stringifiedTitle) {
        String message = "";
        if (library.hasBookTitleInLibrary(stringifiedTitle) == true) {
            message = "Thank you for returning the book.";
        } else if (library.hasBookTitleInLibrary(stringifiedTitle) == false) {
            message = "That is not a valid book to return.";
        }
        return message;
    }

    //Todo: figure out how I can get the scanner object in here so line 33 can work & refactor as very long
    //Todo: think about responsbility - is the menu the correct place or should this be refactored to the library to check books & printer class to console log
    public String checkOutBook(Scanner userInputBookTitle) {
        String stringifiedTitle = userInputBookTitle.next();
        String resultString = "";
        if (library.hasBookTitleInLibrary(stringifiedTitle) == true) {
            printer.checkOutMessage();
            Book checkedOutBook = library.findBookFromTitle(userInputBookTitle);
            library.removeBooks(checkedOutBook);
            resultString = this.checkedOutSuccessOrFailureMessage(stringifiedTitle );
        } else {
            resultString = this.checkedOutSuccessOrFailureMessage(stringifiedTitle);
        }
        return resultString;
    }

    public String returnBook(Scanner userInputBookTitle) {
        String stringifiedTitle = userInputBookTitle.next();
        String resultString = "";
        if (library.hasBookTitleInLibrary(stringifiedTitle) == false) {
            printer.returnMessage();
            Book returnedBook = library.findBookFromTitle(userInputBookTitle);
            library.addBooks(returnedBook);
            resultString = this.returnedSuccessOrFailureMessage(stringifiedTitle);
        } else {
            resultString = this.returnedSuccessOrFailureMessage(stringifiedTitle);
        }
        return resultString;
    }

    //    //Todo: figure out how I can get the scanner object in here so line 33 can work
    public String process(String selection) {
        String menuChoice = "";
        switch (selection) {
            case "1":  menuChoice = this.library.getBookDetails();
                break;
//            case "2": menuChoice = this.checkOutBook(userInputBookTitle);
//                break;
//            case "3": menuChoice = this.returnBook(userInputBookTitle);
//                break;
            default: menuChoice = this.checkIsValidOption();
                break;
            case "4": return this.exitProgram();
        }
        return menuChoice;
    }

}


