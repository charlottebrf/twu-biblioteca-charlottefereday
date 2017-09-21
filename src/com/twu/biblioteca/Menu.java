package com.twu.biblioteca;

import com.twu.biblioteca.commands.*;

import java.util.LinkedList;
import java.util.List;

public class Menu {
    private final List<Command> commands;
    private final Printer printer;

    public Menu(UserAccount account, Library library, Printer printer, LibraryRegister register, Keyboard keyboard) {
        this.printer = printer;
        this.commands = new LinkedList<>();
        commands.add(new DisplayBooksCommand(library, printer));
        commands.add(new DisplayMoviesCommand(library, printer));
        commands.add(new ChecksOutBooksCommand(library, printer, keyboard, account, register));
        commands.add(new ChecksOutMoviesCommand(library, printer, keyboard, register));
        commands.add(new ReturnsBooksCommand(library, printer, keyboard, account, register));
        commands.add(new ExitProgramCommand(printer));
        commands.add(new DisplayAccountDetailsCommand(printer, account, keyboard));
    }

    public Menu(UserAccount account, Library library, Printer printer, LibraryRegister register) {
        this(account, library, printer, register, new Keyboard());
    }

    public String process(String selection) {
        int selectionNum = Integer.parseInt(selection);
        commands.get(selectionNum - 1).execute();
        return "";
    }

    public void printMainMenu() {
        printer.display("\n**** Main Menu ****\n\n");
        printer.display("1. List Books\n2. List Movies\n3. Checkout Books\n4. Checkout Movies\n5. Return Books\n6. Exit\n7. See account details");
    }
}

