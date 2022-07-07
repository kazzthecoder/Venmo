package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

@RequestMapping("/accounts/")
@RestController
public class AccountController {


    private AccountDao accountDao;


   public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
   }
    //getUserAccount - GET
    //getAccountBalance - GET

    @RequestMapping (path = "/{account_id}", method = RequestMethod.GET)
    public Account getByAccountId (@PathVariable int account_id) throws AccountNotFoundException {
        return accountDao.getByAccountId(account_id);
    }

    @RequestMapping (path = "/{account_id}/balance", method = RequestMethod.GET)
    public BigDecimal getBalance (@PathVariable int account_id) throws AccountNotFoundException {
        return accountDao.getBalance(account_id);
    }


}
