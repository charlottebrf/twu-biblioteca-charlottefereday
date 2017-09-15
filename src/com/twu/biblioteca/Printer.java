package com.twu.biblioteca;

public class Printer {
//    Todo: change this to be console logs
    private String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    private String list = "1. List Books\n2. checkout books\n3. Exit";
    private String menu = "Main Menu";

    public void getWelcome() { System.out.println(welcome); }

    public void getMainMenu() { System.out.println(list); }

    public void getMenuHeader() { System.out.println("****" + this.menu + "****" + "\n\n"); }
}
