package com.twu.biblioteca;

public class Password {

    private final String password;
    public static final Password NO_PASSWORD = new Password("xxx");

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean equals(Object aPassword) {
        Password p = (Password) aPassword;
        return getPassword().equals(((Password) aPassword).getPassword());
    }
}
