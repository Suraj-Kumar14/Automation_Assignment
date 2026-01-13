package EmployeeManagement;

public interface EmployeeOperations {
	void addEmployee(Employee emp) throws InvalidInputException;
    void displayEmployees();
    Employee searchEmployee(String empID) throws InvalidInputException;
    void removeEmployee(String empID) throws InvalidInputException;
}
