package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransactionDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import java.math.BigDecimal;

//As an authenticated user of the system, I need to be able to send a transfer of a specific amount of TE Bucks to a registered user.
//  COMPLETED //      I should be able to choose from a list of users to send TE Bucks to.
//        I must not be allowed to send money to myself.
//        A transfer includes the User IDs of the from and to users and the amount of TE Bucks.
//        The receiver's account balance is increased by the amount of the transfer.
//        The sender's account balance is decreased by the amount of the transfer.
//        I can't send more TE Bucks than I have in my account.
//        I can't send a zero or negative amount.
//        A Sending Transfer has an initial status of Approved.

@RequestMapping ("/transactions/")
@RestController
public class TransactionController {

    private TransactionDao transactionDao;

    public TransactionController (TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

//    @RequestMapping (path = "/transfer", method = RequestMethod.POST)
//    private Transaction transferByAccountId (@PathVariable int transaction_id, BigDecimal amount)     // do we need a throws method, complete this section... GET TRANSACTIONS
//    return





}
