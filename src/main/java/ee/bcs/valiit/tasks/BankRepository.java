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


    public void createAccount(String account_nr) {
        String sql = "INSERT INTO account (account_nr, balance) VALUES (:account_nrParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", account_nr);
        paramMap.put("balanceParameter", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public void accountBalance(String account_nr){
        String sql = "SELECT balance FROM account where account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account", account_nr);
        jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

}
