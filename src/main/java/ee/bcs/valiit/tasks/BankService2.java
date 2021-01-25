package ee.bcs.valiit.tasks;

import ch.qos.logback.core.BasicStatusManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService2 {

    @Autowired
    BankRepository2 bankRepository2;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr) {
        bankRepository2.insertIntoAccount(accountNr);

//        String sql = "INSERT INTO account2 (account_number, balance) VALUES (:accountNumber, :balance)";
//        Map<String, Object> paramMap = new HashMap();
//        paramMap.put("accountNumber", accountNr);
//        paramMap.put("balance", BigDecimal.ZERO);
//        jdbcTemplate.update(sql, paramMap);
    }


    public BigDecimal accountBalance(String accountNr) {

        return bankRepository2.returnBalance(accountNr);

//        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }


    public void depositMoney(String accountNr, BigDecimal amount) {

        BigDecimal balance = bankRepository2.returnBalance(accountNr);

//        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.add(amount);

        bankRepository2.updateBalance(accountNr, newBalance);

//        String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", accountNr);
//        paramMap2.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap2);
    }

    public void withdrawMoney(String accountNr, BigDecimal amount) {

        BigDecimal balance = bankRepository2.returnBalance(accountNr);


//        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }

        bankRepository2.updateBalance(accountNr, newBalance);


//        String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", accountNr);
//        paramMap2.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap2);
    }

    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {

        BigDecimal fromAccountBalance = bankRepository2.returnBalance(fromAccount);

//        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", fromAccount);
//        BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);


        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }

        bankRepository2.updateBalance(fromAccount, newFromAccountBalance);

//        String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", fromAccount);
//        paramMap2.put("balance", newFromAccountBalance);
//        jdbcTemplate.update(sql2, paramMap2);

        BigDecimal toAccountBalance = bankRepository2.returnBalance(toAccount);

//        String sql3 = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap3 = new HashMap<>();
//        paramMap3.put("accountNumber", toAccount);
//        BigDecimal toAccountBalance = jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);

        BigDecimal newToAccountBalance = toAccountBalance.add(amount);

        bankRepository2.updateBalance(toAccount, newToAccountBalance);

//        String sql4 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap4 = new HashMap();
//        paramMap4.put("accountNumber", toAccount);
//        paramMap4.put("balance", newToAccountBalance);
//        jdbcTemplate.update(sql4, paramMap4);
    }
}
