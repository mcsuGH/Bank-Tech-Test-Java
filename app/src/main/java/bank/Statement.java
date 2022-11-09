package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Statement {

    public static void printStatement(ArrayList<HashMap> transactions) {
        Collections.reverse(transactions);
        System.out.println("date || credit || debit || balance");
        for (HashMap transaction : transactions) {
            StringBuilder transactionDetails = new StringBuilder();
            if (transaction.get("type").equals("credit")) {
                String details = String.format("%s || %s || || %s", transaction.get("date"), transaction.get("amount"), transaction.get("balance"));
                transactionDetails.append(details);
            }  else if (transaction.get("type").equals("debit")) {
                String details = String.format("%s || || %s || %s", transaction.get("date"), transaction.get("amount"), transaction.get("balance"));
                transactionDetails.append(details);
            }

            System.out.println(transactionDetails);
        }
    }
}
