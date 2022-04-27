package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.UserAccount;

public interface UserAccountServ {

    Balance getBalance(AuthenticatedUser authenticatedUser);
    UserAccount getAccountWithUserId(AuthenticatedUser authenticatedUser, int userId);
    UserAccount getAccountWithAccountId(AuthenticatedUser authenticatedUser, int accountId);
}
