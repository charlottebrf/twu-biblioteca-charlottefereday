package com.twu.biblioteca;

public class Printer {
//    Todo: format these so they are centred
    private String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    private String list = "1. List Books\n2. checkout books\n3. Exit";
    private String menu = "Main Menu";
    private String checkOut = "You have chosen to check out a book, redirecting you now";
    private String returnBook = "You have chosen to return a book, redirecting you now";
    private String exitMenu = "You have selected quit: exiting the program now";
    private String selectValidOption = "Select a valid option!";
    private String notAvailable = "That book is not available.";
    private String available = "Thank you! Enjoy the book";
    private String returned = "Thank you for returning the book.";
    private String notReturned = "That is not a valid book to return.";

    public void getWelcome() { System.out.println(welcome); }

    public void getMainMenu() { System.out.println(list); }

    public void getMenuHeader() { System.out.println("****" + this.menu + "****" + "\n\n"); }

    public void checkOutMessage() { System.out.println(checkOut); }

    public void returnMessage() { System.out.println(returnBook); }

    public void exitMenuMessage() { System.out.println(exitMenu); }

    public void selectValidOptionMessage() { System.out.println(selectValidOption); }

    public void notAvailableMessage() { System.out.println(notAvailable);}

    public void availableMessage() { System.out.println(available);}

    public void returnedMessage() { System.out.println(returned);}

    public void notReturnedMessage() { System.out.println(notReturned);}
}
