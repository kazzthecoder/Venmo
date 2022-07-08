package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transaction;

public interface TransactionDao  {

    int sendTransaction(Transaction transaction);
    int getTransactionID(Transaction transaction);



}
