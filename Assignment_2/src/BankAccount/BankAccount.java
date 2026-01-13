package BankAccount;

class BankAccount implements BankOperations, CustomerOperations {
    private String customerName;
    private String customerEmail;
    private double balance;

    // Constructor
    public BankAccount(String name, String email, double initialBalance) {
        this.customerName = name;
        this.customerEmail = email;
        this.balance = initialBalance;
    }
    
    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive!");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Current balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    // CustomerOperations methods
    @Override
    public void showCustomerInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Email: " + customerEmail);
        System.out.println("Account Balance: " + balance);
    }
    
    @Override
    public void updateCustomerInfo(String name, String email) {
        this.customerName = name;
        this.customerEmail = email;
        System.out.println("Customer info updated!");
    }
}