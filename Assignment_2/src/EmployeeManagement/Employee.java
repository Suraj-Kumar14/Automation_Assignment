package EmployeeManagement;

class Employee {
    private String empID;
    private String name;
    private String email;
    private String phone;

    public Employee(String empID, String name, String email, String phone) {
        this.empID = empID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "ID: " + empID + ", Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }
}