package bank;

import java.math.BigDecimal;

public class BankAccount {
    BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal num) {
        balance = balance.add(num);
    }

    public void withdraw(BigDecimal num) {
        balance = balance.subtract(num);
    }
}
