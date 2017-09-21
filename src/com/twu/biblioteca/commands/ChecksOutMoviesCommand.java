package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;

public class ChecksOutMoviesCommand implements Command {

    private final Printer printer;
    private final Keyboard keyboard;
    private LibraryRegister register;
    private Library library;

    public ChecksOutMoviesCommand(Library library, Printer printer, Keyboard keyboard, LibraryRegister register) {
        this.library = library;
        this.printer = printer;
        this.keyboard = keyboard;
        this.register = register;
    }

    @Override
    public String intent() {
        return "Check out movies";
    }

    @Override
    public void execute() {
        String name;
        printer.display("You haven chosen to check out a movie. Please enter the name of the movie you'd like to check out:");
        name = keyboard.read();
        if(register.hasMovieNameInRegister(name) && library.hasMovieNameInLibrary(name)) {
            Movie checkedOutMovie = library.findMovieFromName(name);
            library.removeMovies(checkedOutMovie);
            printer.display("Thank you! Enjoy the movie");
        } else {
            printer.display("That movie is not available");
        }
    }
}
