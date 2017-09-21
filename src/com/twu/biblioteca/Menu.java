package com.twu.biblioteca;

import com.twu.biblioteca.commands.*;

public class Menu {
    private final Library library;
    private final Printer printer;
    private final Keyboard keyboard;
    private final LibraryRegister register;
    private final UserAccount account;

    public Menu(UserAccount account, Library library, Printer printer, LibraryRegister register, Keyboard keyboard) {
        this.account = account;
        this.library = library;
        this.printer = printer;
        this.register = register;
        this.keyboard = keyboard;
    }

    public Menu(UserAccount account, Library library, Printer printer, LibraryRegister register) {
        this(account, library, printer, register, new Keyboard());
    }

    public String checkIsValidOption() {
        return printer.display("Select a valid option!");
    }


    public boolean userLogin() {
        printer.display("To complete this action, you will first need to sign in. Please enter your Library number:");
        LibraryNumber convertedLibraryNumber = keyboard.readLibraryNumber();
        printer.display("Please now enter you password:");
        com.twu.biblioteca.Password convertedPassword = keyboard.readPassword();
        return account.login.isValid(convertedLibraryNumber, convertedPassword);
    }

    public String seeAccountDetails() {
        if (userLogin()) {
            printer.display("You have chosen to view your account details. Please find this listed below:");
            printer.display("User Name:" + account.getUserName() );
            printer.display("Email address:" + account.getUserEmailAddress());
            printer.display("Phone number:" + account.getUserNumber());
            printer.display("Books in account:" + account.getBooksInAccountDetails());
            return "You have chosen to view your account details. Please find this listed below:";
        } else {
            return  printer.display("We don't recognise those account details, redirecting you to the main menu");
        }
    }

    public String process(String selection) {
        switch (selection) {
            case "1":
                new DisplayBooksCommand(library, printer).execute();
                break;
            case "2":
                new DisplayMoviesCommand(library, printer).execute();
                break;
            case "3":
                new ChecksOutBooksCommand(library, printer, keyboard, account, register).execute();
                break;
            case "4":
                new ChecksOutMoviesCommand(library, printer, keyboard, register).execute();
                break;
            case "5":
               new ReturnsBooksCommand(library, printer, keyboard, account, register).execute();
                break;
            case "6":
                new ExitProgramCommand(printer);
                break;
            case "7":
                seeAccountDetails();
                break;
            default:
                checkIsValidOption();
                break;
        }
        return "";
    }


}


