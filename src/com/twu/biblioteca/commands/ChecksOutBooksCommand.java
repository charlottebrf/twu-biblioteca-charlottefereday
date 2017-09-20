package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;

public class ChecksOutBooksCommand implements Command {

    private final Library library;
    private final Printer printer;
    private final Keyboard keyboard;
    private UserAccount account;
    private LibraryRegister libraryRegister;

    public ChecksOutBooksCommand(Library library, Printer printer, Keyboard keyboard, UserAccount account, LibraryRegister libraryRegister) {

        this.library = library;
        this.printer = printer;
        this.keyboard = keyboard;
        this.account = account;
        this.libraryRegister = libraryRegister;
    }

    @Override
    public void execute() {
        String title = null;
        if (userLogin()) {
            printer.display("You have chosen to check out a book. Please enter the title of the book you'd like to check out:");
            title = keyboard.read();
        } else {
             checkIsValidOption();
        }

        if (libraryRegister.hasBookTitleInRegister(title) && library.hasBookTitleInLibrary(title)) {
            Book checkedOutBook = library.findBookFromTitle(title);
            library.removeBooks(checkedOutBook);
            account.addBooksToAccount(checkedOutBook);
            printer.display("Thank you! Enjoy the book");
        } else {
            printer.display("That book is not available.");
        }
    }

    public boolean userLogin() {
        printer.display("To complete this action, you will first need to sign in. Please enter your Library number:");
        LibraryNumber convertedLibraryNumber = keyboard.readLibraryNumber();
        printer.display("Please now enter you password:");
        Password convertedPassword = keyboard.readPassword();
        return account.login.isValid(convertedLibraryNumber, convertedPassword);
    }

    public void checkIsValidOption() {
        printer.display("Select a valid option!");
    }
}
