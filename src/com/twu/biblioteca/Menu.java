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
                new ExitProgramCommand(printer).execute();
                break;
            case "7":
                new DisplayAccountDetailsCommand(printer, account, keyboard).execute();
                break;
            default:
                new NotValidOptionCommand(printer).execute();
                break;
        }
        return "";
    }
}

