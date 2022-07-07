package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountNotFoundException;

@RestController
public class AccountController {
    AccountDao accountDao;

    //getUserAccount - GET
    //getAccountBalance - GET

    @RequestMapping (path = "/{id}", method = RequestMethod.GET)
    public Account getById (@PathVariable int id) throws AccountNotFoundException {
        return accountDao.getById(id);
    }

    @RequestMapping (path = "/balance", method = RequestMethod.GET)
    public void getBalance (@PathVariable int id) throws AccountNotFoundException {
        return ;                                               // just added. testing.
    }


}
