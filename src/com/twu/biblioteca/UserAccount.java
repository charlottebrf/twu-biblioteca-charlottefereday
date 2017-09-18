package com.twu.biblioteca;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserAccount {

    final private UserLogin login;
    final private UserName userName;
    final private UserEmailAddress email;
    final private UserPhoneNumber phoneNumber;
    final private  Map<String, Book> booksInAccount;

    public UserAccount(UserLogin login, UserName userName, UserEmailAddress email, UserPhoneNumber phoneNumber) {
        this.login = login;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        booksInAccount = new HashMap<String, Book>();
    }

    public UserAccount getUserAccount() {
        return this;
    }

    public void addBooksToAccount(Book book) {
        booksInAccount.put(book.title.getTitle(), book);
    }

    public List<Book> getBooksInAccount() {
        return new LinkedList<>(booksInAccount.values());
    }

    public void removeBooksFromAccount(Book book) { booksInAccount.remove(book.title.getTitle());}

    public boolean isValid(LibraryNumber libraryNumber) {
        return login.containsKey(libraryNumber);
    }

}
