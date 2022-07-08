package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcTransactionDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcTransactionDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }









//    private Transaction mapRowToTransaction (SqlRowSet, rowSet) {       // is this what we need? should it be SET or GET? we used set methods in Jdbc Account Dao
//        Transaction transaction = new Transaction();
//        transaction.getTransaction_id();
//        transaction.getReceiver_id();
//        transaction.getReceiver_id();
//        transaction.getAmount();
//        transaction.getReceiver_id();
//
//    }
}

