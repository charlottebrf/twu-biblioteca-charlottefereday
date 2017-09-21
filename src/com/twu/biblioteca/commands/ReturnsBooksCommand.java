package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;

public class ReturnsBooksCommand implements Command {

    private final Library library;
    private final Printer printer;
    private final Keyboard keyboard;
    private final UserAccount account;
    private final LibraryRegister register;

    public ReturnsBooksCommand(Library library, Printer printer, Keyboard keyboard, UserAccount account, LibraryRegister register) {
        this.library = library;
        this.printer = printer;
        this.keyboard = keyboard;
        this.account = account;
        this.register = register;
    }

    @Override
    public void execute() {
        String title = null;
        if (userLogin()) {
            printer.display("You have chosen to return a book. Please enter the title of the book you'd like to return:");
            title = keyboard.read();
        } else {
            printer.display("We don't recognise those account details, redirecting you to the main menu.");
        }

        if (register.hasBookTitleInRegister(title) && !library.hasBookTitleInLibrary(title)) {
            Book returnedBook = register.findBookInRegisterFromTitle(title);
            library.addBooks(returnedBook);
            account.removeBooksFromAccount(returnedBook);
            printer.display("Thank you for returning the book.");
        } else {
            printer.display("That is not a valid book to return.");
        }
    }

    public boolean userLogin() {
        printer.display("To complete this action, you will first need to sign in. Please enter your Library number:");
        LibraryNumber convertedLibraryNumber = keyboard.readLibraryNumber();
        printer.display("Please now enter you password:");
        Password convertedPassword = keyboard.readPassword();
        return account.login.isValid(convertedLibraryNumber, convertedPassword);
    }

    @Override
    public String intent() {
        return "Return books";
    }
}
