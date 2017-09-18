package com.twu.biblioteca;

import java.math.BigInteger;

public class UserPhoneNumber {
    private final BigInteger number;

    public UserPhoneNumber(BigInteger number) {
        this.number = number;
    }

    public BigInteger getNumber() {
        return this.number;
    }
}
