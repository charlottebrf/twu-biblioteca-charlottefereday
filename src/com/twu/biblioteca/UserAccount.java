package com.twu.biblioteca;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserAccount {
    final private UserName userName;
    final private UserEmailAddress email;
    final private UserPhoneNumber phoneNumber;
    final private UserLogin login;
    final private  Map<String, Book> booksInAccount;
    final private  Map<String, UserLogin> loginDetails;

    public UserAccount(UserLogin login, UserName userName, UserEmailAddress email, UserPhoneNumber phoneNumber) {
        this.login = login;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        booksInAccount = new HashMap<String, Book>();
        loginDetails = new HashMap<String, UserLogin>();
    }

    public UserAccount getUserAccount() {
        return this;
    }

    public void addBooksToAccount(Book book) {
        booksInAccount.put(book.title.getTitle(), book);
    }

    public void addAccountDetails(UserLogin userLogin) { loginDetails.put(()), userLogin);}

    public List<Book> getBooksInAccount() {
        return new LinkedList<>(booksInAccount.values());
    }

    public void removeBooksFromAccount(Book book) { booksInAccount.remove(book.title.getTitle());}

    public boolean isValid(Integer libraryNumber) {
        return loginDetails.containsKey(libraryNumber);
    }

}
