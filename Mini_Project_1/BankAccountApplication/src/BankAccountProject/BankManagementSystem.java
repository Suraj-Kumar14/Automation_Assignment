package BankAccountProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankManagementSystem {
    private static final String FILE_NAME = "accounts.txt";
    private static Map<String, BankAccount> accounts = new HashMap<>();

    // Save accounts to file
    private static void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load accounts from file
    @SuppressWarnings("unchecked")
    private static void loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (HashMap<String, BankAccount>) ois.readObject();
        } catch (Exception e) {
            accounts = new HashMap<>();
        }
    }
    
    public static void main(String[] args) {
        loadAccounts();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();
                    System.out.print("Enter Holder Name: ");
                    String name = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Enter Account Type (Savings/Current): ");
                    String type = sc.next();

                    BankAccount acc;
                    if (type.equalsIgnoreCase("Savings")) {
                        acc = new SavingsAccount(accNo, name, bal);
                    } else {
                        acc = new CurrentAccount(accNo, name, bal);
                    }
                    accounts.put(accNo, acc);
                    saveAccounts();
                    System.out.println("Account Created Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    System.out.print("Enter Amount: ");
                    double dep = sc.nextDouble();
                    if (accounts.containsKey(accNo)) {
                        accounts.get(accNo).deposit(dep); // Runtime Polymorphism
                        saveAccounts();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    System.out.print("Enter Amount: ");
                    double wd = sc.nextDouble();
                    if (accounts.containsKey(accNo)) {
                        accounts.get(accNo).withdraw(wd); // Runtime Polymorphism
                        saveAccounts();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    if (accounts.containsKey(accNo)) {
                        System.out.println("Balance: " + accounts.get(accNo).getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    if (accounts.containsKey(accNo)) {
                        accounts.get(accNo).displayAccountDetails();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}





