package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank2")
@RestController
public class BankController2 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/bank2/createAccount?account_nr=EE123
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("account_nr") String accountNr){
        String sql = "INSERT INTO account (account_nr, balance) VALUES (:account_nr, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_nr", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
        //accountMap.put(accountNr, BigDecimal.ZERO);
    }

    // http://localhost:8080/bank2/accountBalance?account_nr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("account_nr") String accountNr){
        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        // return accountMap.get(accountNr);
    }

    // http://localhost:8080/bank2/depositMoney?account_nr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("account_nr") String accountNr, @RequestParam("amount") BigDecimal amount){
        // BigDecimal balance = accountMap.get(accountNr);
        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.add(amount);

        // accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("account_nr", accountNr);
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    // http://localhost:8080/bank2/withdrawMoney?account_nr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("account_nr") String accountNr, @RequestParam("amount") BigDecimal amount){
        //BigDecimal balance = accountMap.get(accountNr);
        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.subtract(amount);
        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Not enough money");
        }

        //accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("account_nr", accountNr);
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    // http://localhost:8080/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount){
        // BigDecimal fromAccountBalance = accountMap.get(fromAccount);
        String sql = "SELECT balance FROM account where account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", fromAccount);
        BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if(newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Not enough money");
        }

        // accountMap.put(fromAccount, newFromAccountBalance);
        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("account_nr", fromAccount);
        paramMap2.put("balance", newFromAccountBalance);
        jdbcTemplate.update(sql2, paramMap2);

        // BigDecimal toAccountBalance = accountMap.get(toAccount);
        String sql3 = "SELECT balance FROM account where account_nr = :account_nr";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("account_nr", toAccount);
        BigDecimal toAccountBalance = jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);

        BigDecimal newToAccountBalance = toAccountBalance.add(amount);

        // accountMap.put(toAccount, newToAccountBalance);
        String sql4 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap4 = new HashMap();
        paramMap4.put("account_nr", toAccount);
        paramMap4.put("balance", newToAccountBalance);
        jdbcTemplate.update(sql4, paramMap4);
    }
}
