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

    //Todo: update this so that library checks that the title is no longer in the library
    public String successMessage() {
        return "Congratulations you have returned your book";
    }

    //Todo: figure out how I can get the scanner object in here so line 33 can work
    public String checkOut(Scanner userInputBookTitle) {
        printer.checkOutMessage();
        Book returnedBook = library.findBookFromTitle(userInputBookTitle);
        library.removeBooks(returnedBook);
        return this.successMessage();
    }

}


