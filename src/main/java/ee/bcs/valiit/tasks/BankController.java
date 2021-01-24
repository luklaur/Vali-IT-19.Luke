package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("tasks")
@RestController
public class BankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/tasks/createAccount?accountNr=EE123
    @PostMapping("createAccount")
    public String createAccount(@RequestParam("accountNr") String account_nr) {
        String sql = "INSERT INTO account (account_nr, balance) VALUES (:account_nrParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", account_nr);
        paramMap.put("balanceParameter", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
        return "New account added";
    }


    // http://localhost:8080/solution/bank/accountBalance?accountNr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        // return accountMap.get(accountNr);
    }

    // http://localhost:8080/tasks/depositMoney
    @PutMapping("depositMoney")
    public String depositMoney(@RequestBody Bank poogen) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", poogen.getAccount());
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.add(poogen.getBalance());

        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", poogen.getAccount());
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
        return "Money deposited";
    }


    // http://localhost:8080/tasks/withdrawMoney
    @PutMapping("withdrawMoney")
    public String withdrawMoney(@RequestBody Bank poogen2) {
        String sql = "SELECT balance FROM account WHERE account = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", poogen2.getAccount());
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.subtract(poogen2.getBalance());
        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Not enough money");
        }

        String sql2 = "UPDATE account SET balance = :balance WHERE account = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", poogen2.getAccount());
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
        return "Money withdrawn";

    }

    // http://localhost:8080/tasks/transferMoney?fromAccount=EE748&toAccount=EE124&amount=100
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount){
        String sql = "SELECT balance FROM account where account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", fromAccount);
        BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if(newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Not enough money");
        }

        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("account_nr", fromAccount);
        paramMap2.put("balance", newFromAccountBalance);
        jdbcTemplate.update(sql2, paramMap2);

        String sql3 = "SELECT balance FROM account where account_nr = :account_nr";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("account_nr", toAccount);
        BigDecimal toAccountBalance = jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);

        BigDecimal newToAccountBalance = toAccountBalance.add(amount);

        String sql4 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap4 = new HashMap();
        paramMap4.put("account_nr", toAccount);
        paramMap4.put("balance", newToAccountBalance);
        jdbcTemplate.update(sql4, paramMap4);
    }


}
