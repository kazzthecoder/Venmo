package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcTransactionDao implements TransactionDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcTransactionDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private int transaction_id;
    private int sender_id;
    private int receiver_id;
    private BigDecimal amount;
    private String status;

    @Override
    public Transaction sendTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (sender_id, receiver_id, amount, status) VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql,transaction.getSender_id(), transaction.getReceiver_id(), transaction.getAmount(), transaction.getStatus();
    }


   private Transaction mapRowToTransaction (SqlRowSet rowSet) {       // is this what we need? should it be SET or GET? we used set methods in Jdbc Account Dao
       Transaction transaction = new Transaction();
       transaction.setTransaction_id(rowSet.getInt("transaction_id"));
        transaction.setSender_id(rowSet.getInt("sender_id"));
        transaction.setReceiver_id(rowSet.getInt("receiver_id"));
        transaction.setAmount(rowSet.getBigDecimal("amount"));
        transaction.setStatus(rowSet.getString("status"));
        return transaction;
   }


}

