package p1;

class BankAccount {
    private String accountNumber;
    private String name;
    private double balance;

    public BankAccount(String accountNumber, String name, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = initialDeposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
            return true;
        } else {
            return false; // Insufficient funds
        }
    }
}

