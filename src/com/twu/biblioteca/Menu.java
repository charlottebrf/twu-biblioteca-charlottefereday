package com.twu.biblioteca;
import java.util.Scanner;

public class Menu {
    private final Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public String process(String selection) {

        String menuChoice = "";
        switch (selection) {
            case "1":  menuChoice = this.library.getBookDetails();
                break;
            case "2": menuChoice = this.checkOut();
                break;
            default: menuChoice = this.checkIsValidOption();
                break;
            case "3": return this.exitProgram();
        }
        return menuChoice;
    }

    public String checkIsValidOption() {
        System.out.println("Select a valid option!");
        return this.exitProgram();
    }

    public String exitProgram() {
        System.out.println("You have selected quit: exiting the program now");
        return "";
    }

    public String checkOut() {
         System.out.println("Please write the exact title of the book you would like to check out");
         printer.
    }

    public void inputBookTitle(Scanner title) {
        String stringifiedTitle = "";
        stringifiedTitle = title;
        //turn scanner into string
        //give string to method to check if title is in library
        //if it is remove it from the library
        //else give an error message

    }
}


