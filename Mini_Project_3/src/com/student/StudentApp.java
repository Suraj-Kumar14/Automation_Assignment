package com.student;

import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        if (!Login.authenticate())
            return;

        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student By ID (Eno)");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: service.addStudent(); break;
                case 2: service.displayAll(); break;
                case 3: service.searchStudent(); break;
                case 4: service.updateBranch(); break;
                case 5: service.deleteStudent(); break;
                case 6: service.displaySorted(); break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}