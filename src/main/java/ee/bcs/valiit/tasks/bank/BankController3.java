package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequestMapping("banker")
@RestController
public class BankController3 {

    //    @Autowired
//    private BankService3 bankService3;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public String makeRandomString() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        String randomString = "EE" + String.valueOf(randomNumber);
        return randomString;
    }

    // töötab postmanis ja brauseris
    // http://localhost:8080/banker/createCustomer
    @PostMapping("createCustomer")
    public void createCustomer(@RequestBody Bank customer) {
        String sql = "INSERT INTO customer (firstname, lastname, address) VALUES (:firstName, :lastName, :address)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("firstName", customer.getFirstName());
        paramMap.put("lastName", customer.getLastName());
        paramMap.put("address", customer.getAddress());
        jdbcTemplate.update(sql, paramMap);
    }

    // töötab postmanis
    // http://localhost:8080/banker/createAccount
    @PostMapping("createAccount")
    public void createAccount(@RequestBody Bank customer) {
//        String sql = "INSERT INTO account (account_number, balance, customer_id_key) VALUES (:account_number, :balance, :customerid)";
        String sql = "INSERT INTO account (account_number, balance, customer_id_key) VALUES (:account_number, :balance, :customerid)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_number", customer.getAccount());
        paramMap.put("balance", BigDecimal.ZERO);
        paramMap.put("customerid", customer.getCustomerid());
        jdbcTemplate.update(sql, paramMap);
    }

    // töötab postmanis
    // http://localhost:8080/banker/accountBalance
    @PostMapping("accountBalance")
    public BigDecimal returnBalance(@RequestBody Bank customer) {
        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", customer.getAccount());
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    // töötab postmanis
    // http://localhost:8080/banker/depositMoney
    @PostMapping("depositMoney")
    public void depositMoney(@RequestBody Bank customer) {
        String sql = "SELECT balance FROM account WHERE account_number = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", customer.getAccount());
        paramMap.put("amount", customer.getAmount());
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.add(customer.getAmount());

        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", customer.getAccount());
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    // töötab postmanis
    // http://localhost:8080/banker/withdrawMoney
    @PostMapping("withdrawMoney")
    public void withdrawMoney(@RequestBody Bank customer) {
        String sql = "SELECT balance FROM account WHERE account_number = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", customer.getAccount());
        paramMap.put("amount", customer.getAmount());
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.subtract(customer.getAmount());

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }

        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", customer.getAccount());
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    //töötab postmanis
    // http://localhost:8080/banker/transferMoney
    @PostMapping("transferMoney")
    public void transferMoney(@RequestBody Bank customer) {

        String sql1 = "SELECT balance FROM account WHERE account_number = :account_nr";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("account_nr", customer.getFromAccount());
        paramMap1.put("amount", customer.getAmount());
        BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql1, paramMap1, BigDecimal.class);

        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(customer.getAmount());

        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }

        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", customer.getFromAccount());
        paramMap2.put("balance", newFromAccountBalance);
        jdbcTemplate.update(sql2, paramMap2);

        String sql3 = "SELECT balance FROM account WHERE account_number = :account_nr";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("account_nr", customer.getToAccount());
        paramMap3.put("amount", customer.getAmount());
        BigDecimal toAccountBalance = jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);

        BigDecimal newToAccountBalance = toAccountBalance.add(customer.getAmount());

        String sql4 = "UPDATE account SET balance = :balance WHERE account_number = :account_nr";
        Map<String, Object> paramMap4 = new HashMap<>();
        paramMap4.put("account_nr", customer.getToAccount());
        paramMap4.put("balance", newToAccountBalance);
        jdbcTemplate.update(sql4, paramMap4);
    }


    // ei tööta
// http://localhost:8080/banker/createCustomerAndAccount
  /*  @PostMapping("createCustomerAndAccount")
    public void createCustomerAndAccount(@RequestBody Bank customer) {
        String sql1 = "INSERT INTO customer (firstname, lastname, address) VALUES (:firstName, :lastName, :address)";
        String sql2 = "INSERT INTO account (account_number, balance, customer_id_key) VALUES (:account_number, :balance, :customer_id_key)";
        Map<String, Object> paramMap1 = new HashMap();
        Map<String, Object> paramMap2 = new HashMap();
        paramMap1.put("firstName", customer.getFirstName());
        paramMap1.put("lastName", customer.getLastName());
        paramMap1.put("address", customer.getAddress());
        jdbcTemplate.update(sql1, paramMap1);

        KeyHolder keyHolder = new GeneratedKeyHolder();


        int keyHolder = jdbcTemplate.queryForObject(sql2, paramMap2, int.class);

        jdbcTemplate.update(sql2, new MapSqlParameterSource(paramMap2), keyHolder);

        paramMap2.put("account_number", makeRandomString());
        paramMap2.put("balance", BigDecimal.ZERO);
        paramMap2.put("customer_id_key", keyHolder);
        jdbcTemplate.update(sql2, paramMap2);



    }*/
}