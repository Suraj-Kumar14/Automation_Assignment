package EmployeeManagement;

import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.dat";
    private static Map<Integer, Employee> employees = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    // Load employees from file
    @SuppressWarnings("unchecked")
    private static void loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (HashMap<Integer, Employee>) ois.readObject();
        } catch (Exception e) {
            employees = new HashMap<>();
        }
    }

    // Save employees to file
    private static void saveEmployees() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }
    
    private static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            if (employees.containsKey(id)) throw new Exception("Employee ID must be unique!");

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0) throw new Exception("Salary must be positive!");

            System.out.print("Enter Department: ");
            String dept = sc.next();
            if (dept.isEmpty()) throw new Exception("Department cannot be empty!");

            Employee emp = new Employee(id, name, salary, dept);
            employees.put(id, emp);
            saveEmployees();
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.values().forEach(System.out::println);
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        Employee emp = employees.get(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found!");
        }
    }
    
    private static void updateSalary() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        Employee emp = employees.get(id);
        if (emp != null) {
            System.out.print("Enter new Salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0) {
                System.out.println("Salary must be positive!");
                return;
            }
            emp.setSalary(salary);
            saveEmployees();
            System.out.println("Salary updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        if (employees.remove(id) != null) {
            saveEmployees();
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void displaySortedEmployees() {
        List<Employee> list = new ArrayList<>(employees.values());
        list.sort(Comparator.comparing(Employee::getName));
        list.forEach(System.out::println);
    }

    private static void displayDepartments() {
        Set<String> departments = new HashSet<>();
        for (Employee emp : employees.values()) {
            departments.add(emp.getDepartment());
        }
        System.out.println("Departments: " + departments);
    }

    private static boolean login() {
        System.out.print("Enter Username: ");
        String user = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();

        return user.equals("admin") && pass.equals("1234");
    }

    // 🔹 Main Menu
    public static void main(String[] args) {
        loadEmployees();
        if (!login()) {
            System.out.println("Invalid login! Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: displayAllEmployees(); break;
                case 3: searchEmployee(); break;
                case 4: updateSalary(); break;
                case 5: deleteEmployee(); break;
                case 6: displaySortedEmployees(); break;
                case 7: displayDepartments(); break;
                case 8: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}








