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
    private BankService2 bankService2;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/bank2/createCustomer?firstname=Priit&lastname=Tuust&address=Kalevi 7

    @GetMapping("createCustomer")
    public void createCustomer(@RequestParam("firstname") String firstname,
                               @RequestParam("lastname") String lastname,
                               @RequestParam("address") String address) {
        bankService2.createCustomer(firstname, lastname, address);

//        String sql = "INSERT INTO customer (firstname, lastname, address) VALUES (:firstname, :lastname, :address)";
//        Map<String, Object> paramMap = new HashMap();
//        paramMap.put("firstname", firstname);
//        paramMap.put("lastname", lastname);
//        paramMap.put("address", address);
//        jdbcTemplate.update(sql, paramMap);
    }


    // http://localhost:8080/bank2/createAccount?accountNr=EE124&customer_id=1
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr,
                              @RequestParam("customer_id") int customer_id) {
        bankService2.createAccount(accountNr, customer_id);
//        String sql = "INSERT INTO account2 (account_number, balance) VALUES (:accountNumber, :balance)";
//        Map<String, Object> paramMap = new HashMap();
//        paramMap.put("accountNumber", accountNr);
//        paramMap.put("balance", BigDecimal.ZERO);
//        jdbcTemplate.update(sql, paramMap);
        //accountMap.put(accountNr, BigDecimal.ZERO);
    }

    // http://localhost:8080/bank2/accountBalance?accountNr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        return bankService2.accountBalance(accountNr);
//        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//         return accountMap.get(accountNr);
    }

    // http://localhost:8080/bank2/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        // BigDecimal balance = accountMap.get(accountNr); VANA
        bankService2.depositMoney(accountNr, amount);
//        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

//        BigDecimal newBalance = balance.add(amount);

        // accountMap.put(accountNr, newBalance); VANA

//        String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", accountNr);
//        paramMap2.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap2);
    }

    // http://localhost:8080/bank2/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        //BigDecimal balance = accountMap.get(accountNr);
        bankService2.withdrawMoney(accountNr, amount);

//        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

//        BigDecimal newBalance = balance.subtract(amount);
//        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
//        }

        //accountMap.put(accountNr, newBalance);
//        String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", accountNr);
//        paramMap2.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap2);
    }

    // http://localhost:8080/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        // BigDecimal fromAccountBalance = accountMap.get(fromAccount);
        bankService2.transferMoney(fromAccount, toAccount, amount);

//        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", fromAccount);
//        BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

//        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
//        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
//        }

        // accountMap.put(fromAccount, newFromAccountBalance);
//        String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", fromAccount);
//        paramMap2.put("balance", newFromAccountBalance);
//        jdbcTemplate.update(sql2, paramMap2);

        // BigDecimal toAccountBalance = accountMap.get(toAccount);
//        String sql3 = "SELECT balance FROM account2 where account_number = :accountNumber";
//        Map<String, Object> paramMap3 = new HashMap<>();
//        paramMap3.put("accountNumber", toAccount);
//        BigDecimal toAccountBalance = jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);

//        BigDecimal newToAccountBalance = toAccountBalance.add(amount);

        // accountMap.put(toAccount, newToAccountBalance);
//        String sql4 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap4 = new HashMap();
//        paramMap4.put("accountNumber", toAccount);
//        paramMap4.put("balance", newToAccountBalance);
//        jdbcTemplate.update(sql4, paramMap4);
    }
}
