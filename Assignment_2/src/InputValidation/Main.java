package InputValidation;

import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        RegexValidation validation=new RegexValidation();
	        int choice = 0;

	        do {
	            System.out.println("\n===== Input Validation Menu =====");
	            System.out.println("1. Validate Mobile Number");
	            System.out.println("2. Validate Email ID");
	            System.out.println("3. Validate Username");
	            System.out.println("4. Validate Password");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            
	            try {
	                choice = Integer.parseInt(sc.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid choice! Please enter a number.");
	                continue;
	            }

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Mobile Number: ");
	                    String mobile = sc.nextLine();
	                    try {
	                        validation.validateMobile(mobile);
	                    } catch (InvalidInputException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter Email ID: ");
	                    String email = sc.nextLine();
	                    try {
	                        validation.validateEmail(email);
	                    } catch (InvalidInputException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;

	                case 3:
	                    System.out.print("Enter Username: ");
	                    String username = sc.nextLine();
	                    try {
	                        validation.validateUsername(username);
	                    } catch (InvalidInputException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;

	                case 4:
	                    System.out.print("Enter Password: ");
	                    String password = sc.nextLine();
	                    try {
	                        validation.validatePassword(password);
	                    } catch (InvalidInputException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;

	                case 5:
	                    System.out.println("Exiting program...");
	                    break;

	                default:
	                    System.out.println("Invalid choice! Please select 1-5.");
	            }

	        } while (choice != 5);

	        sc.close();
	    }

}
