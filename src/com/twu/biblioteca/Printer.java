package com.twu.biblioteca;

public class Printer {

    private String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    private String list = "List Books";
    private String menu = "Main Menu";

    public String getWelcome() { return this.welcome; }

    public String mainMenu() { return "****" + this.menu + "****" + "\n\n" + this.list; }
}
