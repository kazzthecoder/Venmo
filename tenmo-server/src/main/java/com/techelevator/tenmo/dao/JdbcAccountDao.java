package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao{


        private JdbcTemplate jdbcTemplate;

        public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        public Account getUserAccount(String username){
            String sql ="SELECT account_id, ac.user_id, balance\n" +
                    "FROM account AS ac\n" +
                    "JOIN tenmo_user As tu ON tu.user_id = ac.user_id\n" +
                    "WHERE tu.username = ILIKE ?;";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
            if (rowSet.next()) {
                return mapRowToAccount(rowSet);
            } throw new UsernameNotFoundException("User " + username + " was not found.");

        };


        public void deposit(Account account, BigDecimal amount) {

        };

        public void withdraw(Account account,BigDecimal amount){

        } ;

        public List<Account> getAccountsWithUsername(){
            return null;
        }

        @Override
        public Account getByAccountId(int account_id) throws AccountNotFoundException {
            String sql = "SELECT account_id, user_id, balance FROM account WHERE account_id = ?;";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,  account_id);
            if (rowSet.next()) {
                Account account = mapRowToAccount(rowSet);
                return account;
            } else {
                throw new AccountNotFoundException("cannot find account with ID: " + account_id);
            }

                /// just added. testing.
        }

        @Override
        public BigDecimal getBalance (int account_id) throws AccountNotFoundException {
            String sql = "SELECT * FROM account WHERE account_id = ? ";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, account_id);
            if (rowSet.next()) {
                Account account = mapRowToAccount(rowSet);
                return account.getBalance();
            }
            throw new UsernameNotFoundException("User " + account_id + " was not found.");
        }

//        @Override
//        public Account getBalance() {
//            return null;
//        }

        ;

        private Account mapRowToAccount(SqlRowSet rs) {
            Account account = new Account();
            account.setAccount_id(rs.getInt("account_id"));
            account.setUser_id(rs.getInt("user_id"));
            account.setBalance(rs.getBigDecimal("balance"));
            return account;
        }
    }


