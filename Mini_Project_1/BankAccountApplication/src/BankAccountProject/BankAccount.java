package BankAccountProject;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation (Getters)
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // Abstract Methods
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

