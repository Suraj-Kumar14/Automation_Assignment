package EmployeeManagement;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

class EmployeeManager implements EmployeeOperations {
    private HashMap<String, Employee> hashMap;
    private Hashtable<String, Employee> hashTable;
    private TreeMap<String, Employee> treeMap;

    public EmployeeManager() {
        hashMap = new HashMap<>();
        hashTable = new Hashtable<>();
        treeMap = new TreeMap<>();
    }

    // Regex Validation
    private void validateEmployee(Employee emp) throws InvalidInputException {
        // Employee ID: E followed by 3 digits
        if (!emp.getEmpID().matches("^E\\d{3}$")) {
            throw new InvalidInputException("Invalid Employee ID! Format: EXXX");
        }
        
        if (!emp.getName().matches("^[A-Za-z ]+$")) {
            throw new InvalidInputException("Invalid Name! Only letters allowed");
        }
        
        if (!emp.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new InvalidInputException("Invalid Email ID!");
        }
       
        if (!emp.getPhone().matches("^\\d{10}$")) {
            throw new InvalidInputException("Invalid Phone Number!");
        }
       
        if (hashMap.containsKey(emp.getEmpID())) {
            throw new InvalidInputException("Employee ID already exists!");
        }
    }

    // Add Employee
    @Override
    public void addEmployee(Employee emp) throws InvalidInputException {
        validateEmployee(emp);

        hashMap.put(emp.getEmpID(), emp);

        try {
            hashTable.put(emp.getEmpID(), emp); 
        } catch (NullPointerException e) {
            System.out.println("Hashtable does not support null key/value.");
        }

        try {
            treeMap.put(emp.getEmpID(), emp); 
        } catch (NullPointerException e) {
            System.out.println("TreeMap does not support null key.");
        }

        System.out.println("Employee added successfully!");
    }

    // Display all employees
    @Override
    public void displayEmployees() {
        System.out.println("\n=== Employees in HashMap ===");
        hashMap.forEach((k, v) -> System.out.println(v));

        System.out.println("\n=== Employees in Hashtable ===");
        hashTable.forEach((k, v) -> System.out.println(v));

        System.out.println("\n=== Employees in TreeMap (Sorted by ID) ===");
        treeMap.forEach((k, v) -> System.out.println(v));
    }

    // Search employee by ID
    @Override
    public Employee searchEmployee(String empID) throws InvalidInputException {
        if (hashMap.containsKey(empID)) {
            return hashMap.get(empID);
        }
        throw new InvalidInputException("Employee with ID " + empID + " not found!");
    }

    // Remove employee by ID
    @Override
    public void removeEmployee(String empID) throws InvalidInputException {
        if (!hashMap.containsKey(empID)) {
            throw new InvalidInputException("Employee with ID " + empID + " not found!");
        }
        hashMap.remove(empID);
        hashTable.remove(empID);
        treeMap.remove(empID);
        System.out.println("Employee with ID " + empID + " removed successfully!");
    }

    
    public void demonstrateNullSupport() {
        System.out.println("\n--- Demonstrating Null Key/Value Support ---");

        
        hashMap.put(null, new Employee("E999", "NullKeyEmp", "null@emp.com", "1234567890"));
        hashMap.put("E998", null);
        System.out.println("HashMap after adding null key and null value:");
        hashMap.forEach((k,v) -> System.out.println("Key: " + k + ", Value: " + v));

        
        try {
            hashTable.put(null, new Employee("E997", "NullKey", "null@emp.com", "1234567890"));
        } catch (NullPointerException e) {
            System.out.println("Hashtable does not allow null key.");
        }
        try {
            hashTable.put("E996", null);
        } catch (NullPointerException e) {
            System.out.println("Hashtable does not allow null value.");
        }

       
        try {
            treeMap.put(null, new Employee("E995", "NullKeyTree", "null@emp.com", "1234567890"));
        } catch (NullPointerException e) {
            System.out.println("TreeMap does not allow null key.");
        }
        System.out.println("-------------------------------------------\n");
    }
}
