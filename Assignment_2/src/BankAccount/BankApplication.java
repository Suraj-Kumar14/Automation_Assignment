package BankAccount;

public class BankApplication {
	
	public static void main(String[] args) {
        BankAccount account = new BankAccount("Suraj Kumar", "suraj@example.com", 5000);

        account.showCustomerInfo();
        System.out.println();

        // Deposit
        try {
            account.deposit(2000);
            account.deposit(-500); // will throw exception
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            account.withdraw(1000);
            account.withdraw(7000); // will throw exception
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Update customer info
        account.updateCustomerInfo("Suraj K.", "surajk@gmail.com");
        System.out.println();

        account.showCustomerInfo();
    }
}
