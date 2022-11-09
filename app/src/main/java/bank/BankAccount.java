package bank;

import java.math.BigDecimal;

public class BankAccount {
    BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance() {
        return balance;
    }

    private void setBalance(BigDecimal num) {
        balance = num;
    }

    public void deposit(BigDecimal num) {
        BigDecimal newBalance = balance.add(num);
        setBalance(newBalance);
    }

    public void withdraw(BigDecimal num) {
        BigDecimal newBalance = balance.subtract(num);
        setBalance(newBalance);
    }

    public void printStatement() {
        System.out.println("date || credit || debit || balance");
    }
}
