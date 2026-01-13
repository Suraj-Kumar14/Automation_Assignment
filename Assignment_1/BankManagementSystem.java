import java.util.Scanner;
// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accNo, String name, double initialBalance) {
        this.accountNumber = accNo;
        this.accountHolder = name;
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Amount Deposited Successfully!");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InsufficientBalanceException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        System.out.println("Amount Withdrawn Successfully!");
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance       : " + balance);
    }
}

// Main Class
public class BankManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        try {
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            if (balance < 0) {
                throw new IllegalArgumentException("Initial balance cannot be negative");
            }

            account = new BankAccount(accNo, name, balance);

        } catch (Exception e) {
            System.out.println("Error while creating account: " + e.getMessage());
            sc.close();
            return;
        }

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                        break;

                    case 3:
                        System.out.println("Current Balance: " + account.getBalance());
                        break;

                    case 4:
                        account.displayAccountDetails();
                        break;

                    case 5:
                        System.out.println("Thank you for using Bank System!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }
            } catch (InsufficientBalanceException | IllegalArgumentException e) {
                System.out.println("Transaction Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
