package bank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.ArrayList;
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
    public void printStatement_NoTransactions() {
        ArrayList<HashMap> mockTransactions = new ArrayList<HashMap>();
        Statement statement = new Statement();
        String expectedStatement = "date || credit || debit || balance";
        statement.printStatement(mockTransactions);

        assertEquals("printStatement in new account gives header only", expectedStatement, outputStreamCaptor.toString().trim());
    }

    @Test public void printStatement_WithTransactions() {
        ArrayList<HashMap> mockTransactions = new ArrayList<HashMap>();
        HashMap<String, String> mockTransaction1 = new HashMap<String, String>();
        mockTransaction1.put("type", "credit");
        mockTransaction1.put("amount", "1000.00");
        mockTransaction1.put("date", "10/01/2012");
        mockTransaction1.put("balance", "1000.00");
        mockTransactions.add(mockTransaction1);
        HashMap<String, String> mockTransaction2 = new HashMap<String, String>();
        mockTransaction2.put("type", "credit");
        mockTransaction2.put("amount", "2000.00");
        mockTransaction2.put("date", "13/01/2012");
        mockTransaction2.put("balance", "3000.00");
        mockTransactions.add(mockTransaction2);
        HashMap<String, String> mockTransaction3 = new HashMap<String, String>();
        mockTransaction3.put("type", "debit");
        mockTransaction3.put("amount", "500.00");
        mockTransaction3.put("date", "14/01/2012");
        mockTransaction3.put("balance", "2500.00");
        mockTransactions.add(mockTransaction3);

        Statement statement = new Statement();
        statement.printStatement(mockTransactions);

        String expectedStatement = "date || credit || debit || balance" +
                "\n14/01/2012 || || 500.00 || 2500.00" +
                "\n13/01/2012 || 2000.00 || || 3000.00" +
                "\n10/01/2012 || 1000.00 || || 1000.00";

        assertEquals("Statement prints newest transactions first", expectedStatement, outputStreamCaptor.toString().trim());

    }
}
