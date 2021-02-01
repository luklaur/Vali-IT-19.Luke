package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("tasks")
@RestController
public class BankController {
//    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    @Autowired
    private BankService bankService;

    // http://localhost:8080/tasks/createAccount?account_nr=EE123
    @PostMapping("createAccount")
    public String createAccount(@RequestParam("account_nr") String accountNr) {
        return bankService.createAccount(accountNr);
    }


    // http://localhost:8080/tasks/accountBalance?account_nr=EE748
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("account_nr") String accountNr) {
        return bankService.accountBalance(accountNr);
    }

    // http://localhost:8080/tasks/depositMoney?account_nr=EE789&amount=500
    @PutMapping("depositMoney")
    public String depositMoney(@RequestParam("account_nr") String accountNr,
                               @RequestParam("amount") BigDecimal amount) {
        return bankService.depositMoney(accountNr, amount);
    }

    // http://localhost:8080/tasks/withdrawMoney?account_nr=EE789&amount=500
    @PutMapping("withdrawMoney")
    public String withdrawMoney(@RequestParam("account_nr") String accountNr,
                                @RequestParam("amount") BigDecimal amount) {
        return bankService.withdrawMoney(accountNr, amount);
    }

  /*  // http://localhost:8080/tasks/transferMoney?fromAccount=EE748&toAccount=EE124&amount=100
    @GetMapping("transferMoney")
    public String transferMoney(@RequestParam("fromAccount") String fromAccount,
                                @RequestParam("toAccount") String toAccount,
                                @RequestParam("amount") BigDecimal amount) {
        return bankService.transferMoney(fromAccount, toAccount, amount);
    }*/

}
    /*  // http://localhost:8080/tasks/transferMoney?fromAccount=EE748&toAccount=EE124&amount=100
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        String sql = "SELECT balance FROM account where account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", fromAccount);
        BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
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
    }*/

//        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("account_nr", poogen.getAccount());
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//
//        BigDecimal newBalance = balance.add(poogen.getBalance());
//
//        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
//        Map<String, Object> paramMap2 = new HashMap<>();
//        paramMap2.put("account_nr", poogen.getAccount());
//        paramMap2.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap2);
//        return "Money deposited";



 /*   // http://localhost:8080/tasks/withdrawMoney
    @PutMapping("withdrawMoney")
    public String withdrawMoney(@RequestBody Bank poogen2) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", poogen2.getAccount());
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.subtract(poogen2.getBalance());
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }

        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", poogen2.getAccount());
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
        return "Money withdrawn";

    }*/


