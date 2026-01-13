package UniversityManagement;

import java.util.Scanner;

public class UniversityManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice=0;

        do {
            System.out.println("\n===== University Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Remove Student by ID");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Convert HashMap to TreeMap");
            System.out.println("7. Count Students Course-wise");
            System.out.println("8. Display All Courses");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter number 1-9.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Student ID (SXXX): ");
                        String id = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());

                        Student s = new Student(id, name, course, marks);
                        manager.addStudent(s);

                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks input!");
                    }
                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to remove: ");
                    String removeID = sc.nextLine();
                    try {
                        manager.removeStudent(removeID);
                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to search: ");
                    String searchID = sc.nextLine();
                    try {
                        Student s = manager.searchStudent(searchID);
                        System.out.println("Student Found: " + s);
                    } catch (InvalidInputException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    manager.sortStudentsByMarks();
                    break;

                case 6:
                    manager.convertHashMapToTreeMap();
                    break;

                case 7:
                    manager.countStudentsCourseWise();
                    break;

                case 8:
                    manager.displayAllCourses();
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Enter 1-9.");
            }

        } while (choice != 9);

        sc.close();
    }
}