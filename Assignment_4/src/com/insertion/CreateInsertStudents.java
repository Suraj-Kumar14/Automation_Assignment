package com.insertion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class CreateInsertStudents {
Connection c=null;
Statement s=null;
PreparedStatement ps=null;
Scanner sc=new Scanner(System.in);
CreateInsertStudents(){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/DB",
				"root",
				"arhamKhan1786@0"
				);
		System.out.println("Connection Successful");
		s=c.createStatement();
		String createTable= "CREATE TABLE IF NOT EXISTS Students ("+
		"ID INT PRIMARY KEY, " +
				"NAME VARCHAR(50))";
		s.executeUpdate(createTable);
		System.out.println("Table Students created / already exists");
		System.out.print("Enter Student ID: ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Student Name: ");
		String name=sc.nextLine();
		
		String insertQuery="INSERT INTO Students VALUES (?,?)";
		ps=c.prepareStatement(insertQuery);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.executeUpdate();
		System.out.println("Record inserted successfully");
	}
	catch(ClassNotFoundException e) {
		System.out.println("JDBC Driver not found");
		e.printStackTrace();
	}
	catch(SQLException e) {
		System.out.println("SQL Error");
		e.printStackTrace();
	}
	finally {
		try {
			if(ps!=null) ps.close();
			if(s!=null) s.close();
			if(c!=null) c.close();
			sc.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new CreateInsertStudents();
	}

}