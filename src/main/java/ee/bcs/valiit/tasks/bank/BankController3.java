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

    public String makeRandomString() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        String randomString = "EE" + String.valueOf(randomNumber);
        return randomString;
    }


// postmapping ja requestbody

//    @Autowired
//    private BankService3 bankService3;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/bank3/createCustomer
    @PostMapping("createCustomer")
    public void createCustomer(@RequestBody Bank customer) {
        String sql = "INSERT INTO customer (firstname, lastname, address) VALUES (:firstName, :lastName, :address)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("firstName", customer.getFirstName());
        paramMap.put("lastName", customer.getLastName());
        paramMap.put("address", customer.getAddress());
        jdbcTemplate.update(sql, paramMap);
    }

    // http://localhost:8080/bank3/createCustomer
   /* @PostMapping("createCustomer")
    public void createCustomer(@RequestBody Bank customer) {
        String sql1 = "INSERT INTO customer (firstname, lastname, address) VALUES (:firstName, :lastName, :address)";
        String sql2 = "INSERT INTO account (account_number, balance, customer_id) VALUES (:account_number, :balance, :customer_id)";
        Map<String, Object> paramMap1 = new HashMap();
        Map<String, Object> paramMap2 = new HashMap();
        paramMap1.put("firstName", customer.getFirstName());
        paramMap1.put("lastName", customer.getLastName());
        paramMap1.put("address", customer.getAddress());
        paramMap2.put("account_number", makeRandomString());
        paramMap2.put("balance", BigDecimal.ZERO);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql1, paramMap1);
        jdbcTemplate.update(sql2, new MapSqlParameterSource(paramMap2), keyHolder);
    }*/

}
