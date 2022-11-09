package bank;

import org.junit.*;
import static org.junit.Assert.*;


import java.math.BigDecimal;

public class BankAccountTest {
    @Test public void getBalance_InNewAccount() {
        BankAccount acc = new BankAccount();
        assertEquals("Balance of new account should be 0", BigDecimal.valueOf(0), acc.getBalance());
    }

    @Test public void deposit_InNewAccountOnce() {
        BankAccount acc = new BankAccount();
        acc.deposit(BigDecimal.valueOf(1000));

        assertEquals("Deposit of 1000 into a new account has balance £1000", BigDecimal.valueOf(1000), acc.getBalance());
    }

    @Test public void deposit_InNewAccountTwice() {
        BankAccount acc = new BankAccount();
        acc.deposit(BigDecimal.valueOf(1000));
        acc.deposit(BigDecimal.valueOf(500));

        assertEquals("Deposit of 1000 and 500 into a new account has balance £1500", BigDecimal.valueOf(1500), acc.getBalance());
    }

    @Test public void deposit_InNewAccount_ThenWithdraw() {
        BankAccount acc = new BankAccount();
        acc.deposit(BigDecimal.valueOf(1000));
        acc.withdraw(BigDecimal.valueOf(500));

        assertEquals("Deposit of 1000 and withdraw 500 into a new account has balance £500", BigDecimal.valueOf(500), acc.getBalance());
    }
}
