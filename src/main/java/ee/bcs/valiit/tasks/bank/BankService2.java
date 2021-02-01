package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankService2 {

    @Autowired
    BankRepository2 bankRepository2;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createCustomer(String firstname, String lastname, String address) {
        bankRepository2.insertIntoCustomer(firstname, lastname, address);
    }

    public void createAccount(String accountNr, int customer_id) {
        bankRepository2.insertIntoAccount(accountNr, customer_id);
    }

    public BigDecimal accountBalance(String accountNr) {
        return bankRepository2.returnBalance(accountNr);
    }

    public void depositMoney(String accountNr, BigDecimal amount) {

        BigDecimal balance = bankRepository2.returnBalance(accountNr);
        BigDecimal newBalance = balance.add(amount);
        bankRepository2.updateBalance(accountNr, newBalance);
        bankRepository2.depositHistory(accountNr, amount, newBalance);

    }

    public void withdrawMoney(String accountNr, BigDecimal amount) {

        BigDecimal balance = bankRepository2.returnBalance(accountNr);
        BigDecimal newBalance = balance.subtract(amount);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bankRepository2.updateBalance(accountNr, newBalance);
        bankRepository2.withdrawHistory(accountNr, amount, newBalance);
    }

    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {

        BigDecimal fromAccountBalance = bankRepository2.returnBalance(fromAccount);
        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);

        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bankRepository2.updateBalance(fromAccount, newFromAccountBalance);
        BigDecimal toAccountBalance = bankRepository2.returnBalance(toAccount);
        BigDecimal newToAccountBalance = toAccountBalance.add(amount);
        bankRepository2.updateBalance(toAccount, newToAccountBalance);
        bankRepository2.transferHistory(fromAccount, toAccount, amount, newToAccountBalance);
    }
}
