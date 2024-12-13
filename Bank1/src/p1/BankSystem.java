package p1;

import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingUtilities;



public class BankSystem {
    private static BankSystem instance;
    private Map<String, BankAccount> accounts;

    private BankSystem() {
        this.accounts = new HashMap<>();
    }

    public static BankSystem getInstance() {
        if (instance == null) {
            instance = new BankSystem();
        }
        return instance;
    }

    public void createAccount(String accountNumber, String name, double initialDeposit) {
        BankAccount account = new BankAccount(accountNumber, name, initialDeposit);
        accounts.put(accountNumber, account);
    }

    public void deleteAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Other methods for account management...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}


