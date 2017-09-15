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

    public String checkIsValidOption() {
        System.out.println("Select a valid option!");
        return this.exitProgram();
    }

    public String exitProgram() {
        System.out.println("You have selected quit: exiting the program now");
        return "";
    }

    public String successOrFailureMessage(String stringifiedTitle) {
        String message = "";
        if (library.hasBookTitleInLibrary(stringifiedTitle) == true) {
            message = "That book is not available.";
        } else if (library.hasBookTitleInLibrary(stringifiedTitle) == false) {
            message = "Thank you! Enjoy the book";
        }
        return message;
    }

    //    //Todo: figure out how I can get the scanner object in here so line 33 can work
    public String process(String selection) {
        String menuChoice = "";
        switch (selection) {
            case "1":  menuChoice = this.library.getBookDetails();
                break;
            case "2": menuChoice = this.checkOut(userInputBookTitle);
                break;
            default: menuChoice = this.checkIsValidOption();
                break;
            case "3": return this.exitProgram();
        }
        return menuChoice;
    }

//    //Todo: figure out how I can get the scanner object in here so line 33 can work & refactor as very long
    public String checkOut(Scanner userInputBookTitle) {
        String stringifiedTitle = userInputBookTitle.next();
        String resultString = "";
        if (library.hasBookTitleInLibrary(stringifiedTitle) == true) {
            printer.checkOutMessage();
            Book returnedBook = library.findBookFromTitle(userInputBookTitle);
            library.removeBooks(returnedBook);
            resultString = this.successOrFailureMessage(stringifiedTitle );
        } else {
            resultString = this.successOrFailureMessage(stringifiedTitle);
        }
        return resultString;
    }

}


