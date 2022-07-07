package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    public Account getUserAccount(String username);
    public void deposit(Account account, BigDecimal amount) ;
    public void withdraw(Account account,BigDecimal amount) ;
    public List<Account> getAccountsWithUsername();
    public Account getById(int id) throws AccountNotFoundException;
  //  public Account void getBalance();
    BigDecimal getBalance(int id) throws AccountNotFoundException;   // just added. testing.
}
