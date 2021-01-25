package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public String createAccount(String account_nr) {
        bankRepository.createAccount(account_nr);
        return "Account created";
    }

    public BigDecimal accountBalance(@RequestParam("account_nr") String account_nr) {
        bankRepository.accountBalance(account_nr);
        return accountBalance(account_nr);
    }
}
