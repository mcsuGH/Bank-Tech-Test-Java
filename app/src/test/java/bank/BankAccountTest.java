package bank;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class BankAccountTest {
    @Test public void getBalance_InNewAccount() {
        BankAccount acc = new BankAccount();
        assertEquals("Balance of new account should be 0", BigDecimal.valueOf(0), acc.getBalance());
    }
}
