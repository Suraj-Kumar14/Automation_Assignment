import java.util.*;
import java.util.regex.Pattern;

// Custom Exception for invalid input
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

// Student class
class Student {
    private String rollNo;
    private String name;
    private String email;
    private String phone;

    public Student(String rollNo, String name, String email, String phone) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getRollNo() {
        return rollNo;
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
        return "Roll No: " + rollNo + ", Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }
}

// Interface for Student Operations
interface StudentOperations {
    void addStudent(Student student) throws InvalidInputException;
    void displayStudents();
    void removeStudent(String rollNo) throws InvalidInputException;
    Student searchStudent(String rollNo) throws InvalidInputException;
}

// StudentManager using ArrayList and Vector
class StudentManager implements StudentOperations {
    private List<Student> studentList; // ArrayList
    private Vector<Student> studentVector; // Demonstrate Vector

    public StudentManager() {
        studentList = new ArrayList<>();
        studentVector = new Vector<>();
    }

    // Validate using regex
    private void validateStudent(Student student) throws InvalidInputException {
        // Roll no: R followed by 3 digits (e.g., R001)
        if (!student.getRollNo().matches("^R\\d{3}$")) {
            throw new InvalidInputException("Invalid Roll Number! Format: RXXX");
        }
        // Name: letters and space only
        if (!student.getName().matches("^[A-Za-z ]+$")) {
            throw new InvalidInputException("Invalid Name! Only letters allowed");
        }
        // Email validation
        if (!student.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new InvalidInputException("Invalid Email ID!");
        }
        // Phone: 10 digits
        if (!student.getPhone().matches("^\\d{10}$")) {
            throw new InvalidInputException("Invalid Phone Number!");
        }
        // Check for duplicate roll number
        for (Student s : studentList) {
            if (s.getRollNo().equals(student.getRollNo())) {
                throw new InvalidInputException("Roll Number already exists!");
            }
        }
    }

    // Add student
    @Override
    public void addStudent(Student student) throws InvalidInputException {
        validateStudent(student);
        studentList.add(student);     // Add to ArrayList
        studentVector.add(student);   // Also add to Vector
        System.out.println("Student added successfully!");
    }

    // Display all students
    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display!");
            return;
        }
        System.out.println("=== Student Records (ArrayList) ===");
        for (Student s : studentList) {
            System.out.println(s);
        }
        System.out.println("\n=== Student Records (Vector) ===");
        for (Student s : studentVector) {
            System.out.println(s);
        }
    }

    // Remove student by roll number
    @Override
    public void removeStudent(String rollNo) throws InvalidInputException {
        boolean removed = false;
        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            Student s = itr.next();
            if (s.getRollNo().equals(rollNo)) {
                itr.remove();
                removed = true;
                break;
            }
        }
        // Also remove from vector
        studentVector.removeIf(s -> s.getRollNo().equals(rollNo));

        if (removed) {
            System.out.println("Student with Roll No " + rollNo + " removed successfully!");
        } else {
            throw new InvalidInputException("Student with Roll No " + rollNo + " not found!");
        }
    }

    // Search student by roll number
    @Override
    public Student searchStudent(String rollNo) throws InvalidInputException {
        for (Student s : studentList) {
            if (s.getRollNo().equals(rollNo)) {
                return s;
            }
        }
        throw new InvalidInputException("Student with Roll No " + rollNo + " not found!");
    }
}

// Main class
public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice=0;

        do {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Remove Student by Roll Number");
            System.out.println("4. Search Student by Roll Number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number between 1-5.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Roll No (RXXX): ");
                        String rollNo = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Phone (10 digits): ");
                        String phone = sc.nextLine();

                        Student student = new Student(rollNo, name, email, phone);
                        manager.addStudent(student);

                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No to remove: ");
                    String removeRoll = sc.nextLine();
                    try {
                        manager.removeStudent(removeRoll);
                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to search: ");
                    String searchRoll = sc.nextLine();
                    try {
                        Student found = manager.searchStudent(searchRoll);
                        System.out.println("Student Found: " + found);
                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Select 1-5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
