package BankAccountProject;

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " in Current Account.");
    }

    @Override
    public void withdraw(double amount) {
        // Allow overdraft up to 1000
        if (balance + 1000 >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " from Current Account.");
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}

