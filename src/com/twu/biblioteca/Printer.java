package com.twu.biblioteca;

public class Printer {

    private String welcome = "Welcome to the new Biblioteca App: we are open for business!";

    public Printer(String welcome) {
        this.welcome = welcome;
    }

    public String getWelcome() { return this.welcome; }
}
