package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public String createAccount(String accountNr) {
        bankRepository.createAccount(accountNr);
        return "Account created";
    }

    public BigDecimal accountBalance(String accountNr) {
        return bankRepository.accountBalance(accountNr);
    }

    public String depositMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bankRepository.accountBalance(accountNr);
        BigDecimal newBalance = balance.add(amount);
        bankRepository.updateBalance(accountNr, newBalance);
        return "Money deposited";

    }

    public String withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bankRepository.accountBalance(accountNr);
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bankRepository.updateBalance(accountNr, newBalance);
        return "Money withdrawn";
    }


  /*  public String transferMoney(String fromAccount, String toAccount, BigDecimal amount) {

        BigDecimal balance = bankRepository.accountBalance(accountNr);
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bankRepository.updateBalance(accountNr, newBalance);

    }*/
}
