package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Clock;

public class BankAccount {
    BigDecimal balance = BigDecimal.ZERO;
    ArrayList<HashMap> transactionHistory = new ArrayList<HashMap>();

    public BigDecimal getBalance() {
        return balance;
    }

    private void setBalance(BigDecimal num) {
        balance = num;
    }

    public ArrayList<HashMap> getTransactionHistory() {
        return transactionHistory;
    }

    private void recordTransaction(String type, String amount, String date, String balance) {
        HashMap<String, String> newTransaction = new HashMap<String, String>();
        newTransaction.put("type", type);
        newTransaction.put("amount", amount);
        newTransaction.put("date", date);
        newTransaction.put("balance", balance);
        transactionHistory.add(newTransaction);
    }

    public void deposit(BigDecimal num, LocalDateTime date) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String formattedAmount = String.format("%.2f", num);
        BigDecimal newBalance = balance.add(num);
        setBalance(newBalance);
        String formattedBalance = String.format("%.2f", getBalance());

        recordTransaction("credit", formattedAmount, formattedDate, formattedBalance);
    }

    public void withdraw(BigDecimal num, LocalDateTime date) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String formattedAmount = String.format("%.2f", num);
        BigDecimal newBalance = balance.subtract(num);
        setBalance(newBalance);
        String formattedBalance = String.format("%.2f", getBalance());

        recordTransaction("debit", formattedAmount, formattedDate, formattedBalance);
    }

    public void printStatement() {
        Statement.printStatement(transactionHistory);
    }
}
