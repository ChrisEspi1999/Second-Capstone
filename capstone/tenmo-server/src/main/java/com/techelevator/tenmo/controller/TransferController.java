package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.*;
import com.techelevator.tenmo.model.TransferDescription;
import com.techelevator.tenmo.model.TransferStatus;
import com.techelevator.tenmo.model.Transfers;
import com.techelevator.tenmo.model.UserAccount;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

public class TransferController {
    UserAccountDAO userAccountDAO;
    UserDao userDao;
    TransfersDAO transfersDAO;
    TransferDescriptionDAO transferDescriptionDAO;
    TransferStatusDAO transferStatusDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/transfer/{id}", method = RequestMethod.POST)
    public void addTransfer(@RequestBody Transfers transfers, @PathVariable int id){

        BigDecimal amountTransferred = transfers.getAmount();
        UserAccount userAccountFrom = userAccountDAO.getAccountWithAccountId(transfers.getFromAccount());
        UserAccount userAccountTo = userAccountDAO.getAccountWithAccountId(transfers.getToAccount());

        userAccountFrom.getBalance().giveMoney(amountTransferred);
        userAccountTo.getBalance().getMoney(amountTransferred);

        transfersDAO.createTransfer(transfers);
        userAccountDAO.accountUpdate(userAccountFrom);
        userAccountDAO.accountUpdate(userAccountTo);
    }
    @RequestMapping(path = "/transfer_type/filter", method = RequestMethod.GET)
    public TransferDescription getTypeByDescription(@RequestParam String desc){
        return transferDescriptionDAO.description(desc);
    }

    @RequestMapping(path = "transfer_status/filter", method = RequestMethod.GET)
    public TransferStatus getStatusByDescription(@RequestParam String desc){
        return transferStatusDAO.statusDescription(desc);
    }



}
