package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.UserAccount;

import java.math.BigDecimal;

public interface UserAccountDAO {

    Balance getBalance(String user);
    UserAccount getAccountWithUserId(int userId);
    UserAccount getAccountWithAccountId(int accountId);

    void accountUpdate(UserAccount accountToUpdate);

}
