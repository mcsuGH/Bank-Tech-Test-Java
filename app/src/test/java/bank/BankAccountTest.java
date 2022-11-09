package bank;

import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalDateTime;


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

    @Test public void getTransactionHistory_InNewAccount() {
        BankAccount acc = new BankAccount();
        ArrayList<HashMap> mockHistory = new ArrayList<HashMap>();

        assertEquals("New account has empty history", mockHistory, acc.getTransactionHistory());
    }

    @Test public void getTransactionHistory_AfterDeposit() {
        String instantExpected = "2012-01-10T16:26:30Z";
        Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));
        Instant instant = Instant.now();
        LocalDateTime dateTime = LocalDateTime.now(clock);

        BankAccount acc = new BankAccount();
        acc.deposit(BigDecimal.valueOf(1000), dateTime);
        ArrayList<HashMap> mockHistory = new ArrayList<HashMap>();
        HashMap<String, String> mockTransaction = new HashMap<String, String>();
        mockTransaction.put("date", "10/01/2012");
        mockTransaction.put("type", "credit");
        mockTransaction.put("amount", "1000.00");
        mockTransaction.put("balance", "1000.00");
        mockHistory.add(mockTransaction);

        assertEquals("Transaction is added into history", mockHistory, acc.getTransactionHistory());
    }
}
