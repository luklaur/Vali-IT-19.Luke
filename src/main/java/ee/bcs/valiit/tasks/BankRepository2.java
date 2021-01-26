package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository2 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void insertIntoAccount(String accountNr, int customer_id) {

        String sql = "INSERT INTO account (account_number, balance, customer_id) VALUES (:accountNumber, :balance, :customer_id)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        paramMap.put("customer_id", customer_id);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal returnBalance(String accountNr) {

        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public void updateBalance(String accountNr, BigDecimal newBalance) {

        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public void insertIntoCustomer(String firstname, String lastname, String address) {

        String sql = "INSERT INTO customer (firstname, lastname, address) VALUES (:firstname, :lastname, :address)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("firstname", firstname);
        paramMap.put("lastname", lastname);
        paramMap.put("address", address);
        jdbcTemplate.update(sql, paramMap);
    }

    public void depositHistory(String toAccount, BigDecimal amount) {

        String sql = "INSERT INTO transactionhistory (to_account, amount, time, transaction_type) VALUES (:accountNumber, :amountParameter, :timeParameter, :transaction_type)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", toAccount);
        paramMap.put("amountParameter", amount);
        paramMap.put("timeParameter", LocalDateTime.now());
        paramMap.put("transaction_type", "deposit");
        jdbcTemplate.update(sql, paramMap);
    }

    public void withdrawHistory(String fromAccount, BigDecimal amount) {

        String sql = "INSERT INTO transactionhistory (from_account, amount, time, transaction_type) VALUES (:accountNumber, :amountParameter, :timeParameter, :transaction_type)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", fromAccount);
        paramMap.put("amountParameter", amount);
        paramMap.put("timeParameter", LocalDateTime.now());
        paramMap.put("transaction_type", "withdraw");
        jdbcTemplate.update(sql, paramMap);
    }


    public void transferHistory(String fromAccount, String toAccount, BigDecimal amount) {

        String sql = "INSERT INTO transactionhistory (from_account, to_account, amount, time, transaction_type) VALUES (:fromAccount, :toAccount, :amountParameter, :timeParameter, :transaction_type)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("fromAccount", fromAccount);
        paramMap.put("toAccount", toAccount);
        paramMap.put("amountParameter", amount);
        paramMap.put("timeParameter", LocalDateTime.now());
        paramMap.put("transaction_type", "transfer");
        jdbcTemplate.update(sql, paramMap);
    }
}
