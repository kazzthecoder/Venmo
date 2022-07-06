package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

public class JdbcAccountDao {

    @Component
    public class JdbcAccount implements AccountDao {

        private JdbcTemplate jdbcTemplate;

        public JdbcAccount(JdbcTemplate jdbcTemplate) {
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
        };

        private Account mapRowToAccount(SqlRowSet rs) {
            Account account = new Account();
            account.setAccount_id(rs.getInt("account_id"));
            account.setUser_id(rs.getInt("user_id"));
            account.setBalance(rs.getBigDecimal("balance"));
            return account;
        }
    }

}
