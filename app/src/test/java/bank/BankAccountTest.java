package bank;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalDateTime;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BankAccountTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
    @Test public void getBalance_InNewAccount() {
        BankAccount acc = new BankAccount();
        assertEquals("Balance of new account should be 0", BigDecimal.valueOf(0), acc.getBalance());
    }

    @Test public void deposit_InNewAccountOnce() throws Exception {
        BankAccount acc = new BankAccount();
        acc.deposit(BigDecimal.valueOf(1000));

        assertEquals("Deposit of 1000 into a new account has balance £1000", BigDecimal.valueOf(1000), acc.getBalance());
    }

    @Test public void deposit_InNewAccountTwice() throws Exception {
        BankAccount acc = new BankAccount();
        acc.deposit(BigDecimal.valueOf(1000));
        acc.deposit(BigDecimal.valueOf(500));

        assertEquals("Deposit of 1000 and 500 into a new account has balance £1500", BigDecimal.valueOf(1500), acc.getBalance());
    }

    @Test public void deposit_InNewAccount_ThenWithdraw() throws Exception {
        BankAccount acc = new BankAccount();
        acc.deposit(BigDecimal.valueOf(1000));
        acc.withdraw(BigDecimal.valueOf(500));

        assertEquals("Deposit of 1000 and withdraw 500 into a new account has balance £500", BigDecimal.valueOf(500), acc.getBalance());
    }

    @Test public void getTransactionHistory_InNewAccount() throws Exception {
        BankAccount acc = new BankAccount();
        ArrayList<HashMap> mockHistory = new ArrayList<HashMap>();

        assertEquals("New account has empty history", mockHistory, acc.getTransactionHistory());
    }

    @Test public void getTransactionHistory_AfterDeposit() throws Exception {
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

    @Test public void printBalance() throws Exception {
        BankAccount acc = new BankAccount();
        acc.deposit(BigDecimal.valueOf(1000));
        acc.deposit(BigDecimal.valueOf(2000));
        acc.withdraw(BigDecimal.valueOf(500));

        acc.printBalance();
        String expectedBalance = "Current Balance: £2500.00";

        assertEquals("Shows current balance formatted", expectedBalance, outputStreamCaptor.toString().trim());

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test public void withdraw_ThrowExceptionWhenWithdrawTooMuch() throws Exception {
        BankAccount acc = new BankAccount();
        thrown.expect(Exception.class);
        thrown.expectMessage("You cannot withdraw more money than you have in your account");
        acc.withdraw(BigDecimal.valueOf(1000));
    }
}
