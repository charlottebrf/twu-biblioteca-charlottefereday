package com.twu.biblioteca;

import java.math.BigInteger;
import java.util.*;

public class UserAccount {
    final private UserName userName;
    final private UserEmailAddress email;
    final private UserPhoneNumber phoneNumber;
    final public UserLogin login;
    final private  Map<String, Book> booksInAccount;

    public UserAccount(UserLogin login, UserName userName, UserEmailAddress email, UserPhoneNumber phoneNumber) {
        this.login = login;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        booksInAccount = new HashMap<String, Book>();
    }

    public String getUserName() { return this.userName.getUserName(); }
    public String getUserEmailAddress() { return this.email.getEmail(); }
    public BigInteger getUserNumber() { return this.phoneNumber.getNumber(); }

    public UserAccount getUserAccount() {
        return this;
    }

    public void addBooksToAccount(Book book) {
        booksInAccount.put(book.title.getTitle(), book);
    }

    public List<Book> getBooksInAccount() {
        return new LinkedList<>(booksInAccount.values());
    }

    public String getBooksInAccountDetails() {
        String bookDetails = "";
        for (Book book : sortedBooks()) {
            bookDetails += "|" + book.title.getTitle() + "|" + book.getBookAuthor() + "|" + book.getBookYear() + "|" + "\n";
        }

        return bookDetails;
    }

    public List<Book> sortedBooks() {
        List<Book> books = new LinkedList<>(booksInAccount.values());

        Comparator<Book> howToSort = Comparator.comparing(book -> book.title.getTitle());

        books.sort(howToSort);
        return books;
    }

    public void removeBooksFromAccount(Book book) { booksInAccount.remove(book.title.getTitle());}

}
