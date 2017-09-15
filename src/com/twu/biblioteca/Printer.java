package com.twu.biblioteca;

public class Printer {
//    Todo: change this to be console logs
    private String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    private String list = "1. List Books";
    private String menu = "Main Menu";

    public String getWelcome() { return this.welcome; }

    public String getmainMenu() { return this.list; }

    public String getMenuHeader() { return "****" + this.menu + "****" + "\n\n"; }
}
