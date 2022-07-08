package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/accounts")
@RestController
public class AccountController {


    private AccountDao accountDao;


   public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
   }
    //getUserAccount - GET//getAccountBalance - GET



    @RequestMapping (path = "/{account_id}", method = RequestMethod.GET)
    public Account getByAccountId (@PathVariable int account_id) throws AccountNotFoundException {
        return accountDao.getByAccountId(account_id);
    }

    @RequestMapping (path = "/{account_id}/balance", method = RequestMethod.GET)
    public BigDecimal getBalance (@PathVariable int account_id) throws AccountNotFoundException {
        return accountDao.getBalance(account_id);
    }

    @RequestMapping (path = "/{account_id}/balance", method = RequestMethod.PUT)
    public Account updateBalance(@RequestBody Account account, @PathVariable int account_id) throws AccountNotFoundException {
       return accountDao.updateBalance(account, account.getBalance());






    }

    @RequestMapping (path = "/{account_id}/users", method = RequestMethod.GET)
    public List<Account> ListRegisteredUsersToSendMoney (@PathVariable int account_id) throws AccountNotFoundException {
        return accountDao.ListRegisteredUsersToSendMoney(account_id);

    }
}
