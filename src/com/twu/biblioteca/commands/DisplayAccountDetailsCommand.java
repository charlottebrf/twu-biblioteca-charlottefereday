package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;

public class DisplayAccountDetailsCommand implements Command {

    private final Printer printer;
    private final UserAccount account;
    private Keyboard keyboard;

    public DisplayAccountDetailsCommand(Printer printer, UserAccount account, Keyboard keyboard) {

        this.printer = printer;
        this.account = account;
        this.keyboard = keyboard;
    }

    @Override
    public void execute() {
        if (userLogin()) {
            printer.display("You have chosen to view your account details. Please find this listed below:");
            printer.display("User Name:" + account.getUserName() );
            printer.display("Email address:" + account.getUserEmailAddress());
            printer.display("Phone number:" + account.getUserNumber());
            printer.display("Books in account:" + account.getBooksInAccountDetails());
        } else {
            printer.display("We don't recognise those account details, redirecting you to the main menu");
        }
    }

    public boolean userLogin() {
        printer.display("To complete this action, you will first need to sign in. Please enter your Library number:");
        LibraryNumber convertedLibraryNumber = keyboard.readLibraryNumber();
        printer.display("Please now enter you password:");
        Password convertedPassword = keyboard.readPassword();
        return account.login.isValid(convertedLibraryNumber, convertedPassword);
    }

}
