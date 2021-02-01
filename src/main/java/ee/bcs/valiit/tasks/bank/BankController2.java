package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("bank2")
@RestController
public class BankController2 {

    @Autowired
    private BankService2 bankService2;
//    @Autowired
//    private NamedParameterJdbcTemplate jdbcTemplate;

    HashMap<String, BigDecimal> accountMap = new HashMap<>();
// postmapping ja requestbody
    // http://localhost:8080/bank2/createCustomer?firstname=Priit&lastname=Tuust&address=Kalevi 7
    @GetMapping("createCustomer")
    public void createCustomer(@RequestParam("firstname") String firstname,
                               @RequestParam("lastname") String lastname,
                               @RequestParam("address") String address) {
        bankService2.createCustomer(firstname, lastname, address);
    }

    // http://localhost:8080/bank2/createAccount?accountNr=EE124&customer_id=1
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr,
                              @RequestParam("customer_id") int customer_id) {
        bankService2.createAccount(accountNr, customer_id);
    }

    // http://localhost:8080/bank2/accountBalance?accountNr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        return bankService2.accountBalance(accountNr);
    }

    // http://localhost:8080/bank2/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        // BigDecimal balance = accountMap.get(accountNr); VANA
        bankService2.depositMoney(accountNr, amount);
    }

    // http://localhost:8080/bank2/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        //BigDecimal balance = accountMap.get(accountNr);
        bankService2.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8080/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        bankService2.transferMoney(fromAccount, toAccount, amount);
    }
}
