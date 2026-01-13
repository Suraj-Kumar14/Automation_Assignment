package EmployeeManagement;

import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        int choice = 0;

        do {
            System.out.println("\n===== Employee Management Menu =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Remove Employee by ID");
            System.out.println("5. Demonstrate Null Key/Value Support");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter number 1-6.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Employee ID (EXXX): ");
                        String empID = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Phone (10 digits): ");
                        String phone = sc.nextLine();

                        Employee emp = new Employee(empID, name, email, phone);
                        manager.addEmployee(emp);

                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    manager.displayEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    String searchID = sc.nextLine();
                    try {
                        Employee found = manager.searchEmployee(searchID);
                        System.out.println("Employee Found: " + found);
                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to remove: ");
                    String removeID = sc.nextLine();
                    try {
                        manager.removeEmployee(removeID);
                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    manager.demonstrateNullSupport();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Select 1-6.");
            }

        } while (choice != 6);

        sc.close();
    }
}