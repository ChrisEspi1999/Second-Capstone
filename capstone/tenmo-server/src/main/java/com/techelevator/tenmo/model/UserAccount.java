package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class UserAccount {

    private Balance balance;
    private int userAccountId;
    private int userId;

    public UserAccount(Balance balance, int userAccountId, int userId) {
        this.balance = balance;
        this.userAccountId = userAccountId;
        this.userId = userId;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
