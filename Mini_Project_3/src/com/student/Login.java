package com.student;

import java.util.Scanner;

public class Login {

    public static boolean authenticate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (user.equals("admin") && pass.equals("admin123")) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Invalid Username or Password");
            return false;
        }
    }
}