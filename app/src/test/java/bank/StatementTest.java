package bank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class StatementTest {
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
    @Test
    public void printStatement_InNewAccount() {
        Statement statement = new Statement();
        String expectedStatement = "date || credit || debit || balance";
        statement.printStatement();

        assertEquals("printStatement in new account gives header only", expectedStatement, outputStreamCaptor.toString().trim());
    }
}
