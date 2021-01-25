package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void createAccount(String accountNr) {
        String sql = "INSERT INTO account (account_nr, balance) VALUES (:account_nrParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", accountNr);
        paramMap.put("balanceParameter", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal accountBalance(String accountNr) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }


    public void updateBalance(String accountNr, BigDecimal newBalance) {
        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("account_nr", accountNr);
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }


}
