package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class UserAccountTest {
    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));

    LibraryNumber libnum = new LibraryNumber(123-4567);
    Password password = new Password("abcdefgh");
    UserLogin login = new UserLogin();
    UserName userName = new UserName("Charlotte Fereday");
    UserEmailAddress email = new UserEmailAddress("foo@foo.com");
    BigInteger cell = new BigInteger("0123456789");
    UserPhoneNumber number = new UserPhoneNumber(cell);

    UserAccount account = new UserAccount(login, userName, email, number);

    @Before
    public void setUp() throws Exception {
        account = new UserAccount(login, userName, email, number);
        account.addBooksToAccount(harryPotter1);
        account.addBooksToAccount(hP2);
        login.addUserLogin(libnum, password);
    }

    @Test
    public void getsAUserAccount() {
        assertEquals(account, account.getUserAccount());
    }

    @Test
    public void getsListOfsCheckedOutBookFromAccount() {
        LinkedList<Book> expectedBooksInAccount = new LinkedList<Book>();
        expectedBooksInAccount.add(hP2);
        expectedBooksInAccount.add(harryPotter1);

        assertEquals(expectedBooksInAccount, account.getBooksInAccount());
    }

    @Test
    public void canRemoveAddedBooksFromAccount() {
        LinkedList<Book> expectedBooksInAccount = new LinkedList<Book>();
        expectedBooksInAccount.add(hP2);
        account.removeBooksFromAccount(harryPotter1);

        assertEquals(expectedBooksInAccount, account.getBooksInAccount() );
    }

    @Test
    public void checksIfValidAccount() {
        assertEquals(true, account.isValid());
    }
}