/*
package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("tasks")
@RestController
public class Lesson4Controller {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/tasks/createAccount?accountNr=EE123
    @PostMapping("createAccount")
    public String createAccount(@RequestParam("accountNr") String account_nr, int balance) {
        String sql = "INSERT INTO account (account_nr, balance) VALUES (:account_nrParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", account_nr);
        paramMap.put("balanceParameter", balance);
        jdbcTemplate.update(sql, paramMap);
        return "New account added";
    }


    // http://localhost:8080/solution/bank/accountBalance?accountNr=EE123
    public BigDecimal accountBalance() {
        return BigDecimal.ZERO;
    }


    // http://localhost:8080/tasks/bank/depositMoney
    @PutMapping("depositMoney")
    public String depositMoney(@RequestBody Bank abc) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", abc.getAccount());
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.add(abc.getBalance());

        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", abc.getAccount());
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
        return "Money withrawn";
    }


 */
/*   // http://localhost:8080/solution/bank/withdrawMoney?accountNr=EE123&amount=12
    @PutMapping("withrawMoney")
    public String withdrawMoney(@RequestBody ???) {
        String sql = "SELECT balance FROM account WHERE account = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", ???.getAccount());
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.subtract(???.getAmount());

        String sql2 ="UPDATE account SET balance = :balance WHERE account = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", ???.getAccount());
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2)
        return "Money withrawn";

    }*//*


    // http://localhost:8080/solution/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    public void transferMoney() {

    }


}
*/
