package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String createAccount(@RequestParam("accountNr") String account_nr) {
        String sql = "INSERT INTO account (account_nr) VALUES (:account_nrParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", account_nr);
        jdbcTemplate.update(sql, paramMap);
        return "New account added";
    }



    // http://localhost:8080/solution/bank/accountBalance?accountNr=EE123
    public BigDecimal accountBalance(){
        return BigDecimal.ZERO;
    }





    // http://localhost:8080/solution/bank/depositMoney?accountNr=EE123&amount=12
        @PostMapping("depositMoney")
        public String depositMoney(@RequestParam("balance") String balance) {
            String sql = "INSERT INTO account (balance) VALUES (:balanceParameter)";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("balanceParameter", balance);
            jdbcTemplate.update(sql, paramMap);
            return "New account added";
        }


    // http://localhost:8080/solution/bank/withdrawMoney?accountNr=EE123&amount=12
    public void withdrawMoney(){

    }

    // http://localhost:8080/solution/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    public void transferMoney(){

    }





}
