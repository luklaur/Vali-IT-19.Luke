package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public String createAccount(String accountNr) {
        bankRepository.createAccount(accountNr);
        return "Account created";
    }

    public BigDecimal accountBalance(@RequestParam("account_nr") String accountNr) {
        return bankRepository.accountBalance(accountNr);
    }

    public String depositMoney(@RequestParam("account_nr") String accountNr,
                               @RequestParam("amount") BigDecimal amount) {
        BigDecimal balance = bankRepository.accountBalance(accountNr);
        BigDecimal newBalance = balance.add(amount);
        bankRepository.updateBalance(accountNr, newBalance);
        return "Money deposited";

    }

}
