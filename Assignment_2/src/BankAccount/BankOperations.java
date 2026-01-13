package BankAccount;

public interface BankOperations {
	 void deposit(double amount) throws InvalidAmountException;
	 void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException;
	 double checkBalance();
}
