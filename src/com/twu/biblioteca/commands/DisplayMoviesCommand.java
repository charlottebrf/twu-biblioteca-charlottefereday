package com.twu.biblioteca.commands;

import com.twu.biblioteca.Command;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Printer;

public class DisplayMoviesCommand implements Command {

    private final Library library;
    private final Printer printer;

    public DisplayMoviesCommand(Library library, Printer printer) {

        this.library = library;
        this.printer = printer;
    }

    @Override
    public void execute() {
        String header = "|Film Name|Year|Director|Rating|\n";
        printer.display(header + library.getMovieDetails());
    }

    @Override
    public String intent() {
        return "Display movies";
    }
}
