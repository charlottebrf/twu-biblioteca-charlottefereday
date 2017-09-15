package com.twu.biblioteca;

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
//            case "2": menuChoice = this.checkOut();
//                break;
            default: menuChoice = this.checkIsValidOption(selection);
                break;
            case "3": return this.exitProgram();
        }
        return menuChoice;
    }

    public String checkIsValidOption(String selection) {
            return "Select a valid option!";
    }

    public String exitProgram() {
        System.out.println("You have selected quit: exiting the program now");
        return "";
    }
//
//    public String checkOut() {
//    }
}


