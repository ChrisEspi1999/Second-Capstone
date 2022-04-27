package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void giveMoney(BigDecimal amount){
        BigDecimal newBalance = new BigDecimal(String.valueOf(balance)).subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) >= 0){
            this.balance = newBalance;
        }
    }
    public void getMoney(BigDecimal amount){
        this.balance = new BigDecimal(String.valueOf(balance)).add(amount);
    }
}
