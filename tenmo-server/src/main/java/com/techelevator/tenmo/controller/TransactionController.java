package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransactionDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.InsufficientFundsException;
import com.techelevator.tenmo.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//As an authenticated user of the system, I need to be able to send a transfer of a specific amount of TE Bucks to a registered user.
//  COMPLETED //      I should be able to choose from a list of users to send TE Bucks to.
//  COMPLETED //      I must not be allowed to send money to myself.
//  COMPLETED //      A transfer includes the User IDs of the from and to users and the amount of TE Bucks.
//  COMPLETED //      The receiver's account balance is increased by the amount of the transfer.
//  COMPLETED //      The sender's account balance is decreased by the amount of the transfer.
//  COMPLETED //      I can't send more TE Bucks than I have in my account.
//  COMPLETED //      I can't send a zero or negative amount.
//  COMPLETED //      A Sending Transfer has an initial status of Approved.

//  COMPLETED //      As an authenticated user of the system, I need to be able to see transfers I have sent or received.
//        As an authenticated user of the system, I need to be able to retrieve the details of any transfer based upon the transfer ID.



@RequestMapping ("/transaction")
@RestController
public class TransactionController {

    private TransactionDao transactionDao;
    private AccountDao accountDao;

    public TransactionController(TransactionDao transactionDao, AccountDao accountDao) {
        this.transactionDao = transactionDao;
        this.accountDao = accountDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public void sendTransaction(@RequestBody Transaction transaction) throws InsufficientFundsException,  AccountNotFoundException {
       if (transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0 ) {
           throw new InsufficientFundsException();
       }
        Account senderAccount = accountDao.getByAccountId(transaction.getSender_id());
        Account receiverAccount = accountDao.getByAccountId(transaction.getReceiver_id());
        if(senderAccount.getBalance().compareTo(transaction.getAmount()) < 0) {
            throw new InsufficientFundsException();
        }
        accountDao.updateBalance(senderAccount,senderAccount.getBalance().subtract(transaction.getAmount()));
        accountDao.updateBalance(receiverAccount,receiverAccount.getBalance().add(transaction.getAmount()));
        transactionDao.sendTransaction(transaction);
    }


    @RequestMapping (path = "{account_id}", method = RequestMethod.GET)
    public List<Transaction> seeTransactions (@PathVariable int account_id) throws AccountNotFoundException {
        return transactionDao.seeTransactions(account_id);
    }

    @RequestMapping (path = "getBy/{transaction_id}", method = RequestMethod.GET)
    public Transaction getTransactionById (@PathVariable int transaction_id) throws AccountNotFoundException {
        return transactionDao.getTransactionById(transaction_id);
    }



    }









