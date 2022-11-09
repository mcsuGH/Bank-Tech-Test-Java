package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

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

    public void deposit(BigDecimal num) {
        BigDecimal newBalance = balance.add(num);
        setBalance(newBalance);
    }

    public void withdraw(BigDecimal num) {
        BigDecimal newBalance = balance.subtract(num);
        setBalance(newBalance);
    }

    public void printStatement() {
        Statement.printStatement(transactionHistory);
    }
}
