package com.student;
import java.sql.*;
import java.util.Scanner;
public class StudentService {
Scanner sc=new Scanner(System.in);

	public void addStudent() {
		try(Connection con=DBConnection.getConnection()){
			System.out.print("Enter Eno: ");
			int id=sc.nextInt();
			PreparedStatement psCheck=con.prepareStatement("SELECT ID FROM STUDENT WHERE ID =?");
			psCheck.setInt(1,id);
			ResultSet rs=psCheck.executeQuery();
			if(rs.next()) {
				throw new Exception("Student Eno already exists!");
			}
			System.out.print("Enter Name: ");
			String name=sc.next();
			System.out.print("Enter Branch: ");
			String branch=sc.next();
			if(branch.isEmpty()) 
				throw new Exception("Branch cannot be empty!");
			System.out.print("Enter Percentage: ");
			float per=sc.nextFloat();
			if(per<=0)
				throw new Exception("Percentage must be positive!");
			System.out.print("Enter Year of Passing: ");
			int yop=sc.nextInt();
			System.out.print("Enter Semester: ");
			int sem=sc.nextInt();
			if(sem<=0)
				throw new Exception("Semester cannot be empty!");
			PreparedStatement ps = con.prepareStatement(
			        "INSERT INTO STUDENT VALUES (?,?,?,?,?,?)");
	
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, branch);
			ps.setFloat(4, per);
			ps.setInt(5, yop);
			ps.setInt(6, sem);
			
			ps.executeUpdate();
			System.out.println("Student Added Successfully");
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayAll() {
		try(Connection con=DBConnection.getConnection()){
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " +
			rs.getString(2) + " " +
						rs.getString(3) + " " + 
			rs.getFloat(4) + " " + 
				rs.getInt(5) + " " +
			rs.getInt(6));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void searchStudent() {
		try(Connection con=DBConnection.getConnection()){
			System.out.print("Enter Eno: ");
			int id=sc.nextInt();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("Student Found: ");
				System.out.println(rs.getInt(1)+ " " + rs.getString(2));
			}
			else {
				System.out.println("Student Not Found");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateBranch() {
		try(Connection con=DBConnection.getConnection()){
			System.out.print("Enter Eno: ");
			int id=sc.nextInt();
			System.out.print("Enter New Branch: ");
			String branch=sc.next();
			PreparedStatement ps=con.prepareStatement("UPDATE STUDENT SET BRANCH =? WHERE ID=?");
			ps.setString(1, branch);
			ps.setInt(2, id);
			int row=ps.executeUpdate();
			if(row>0)
				System.out.println("Branch Updated");
			else
				System.out.println("Student Not Found");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void deleteStudent() {
		try(Connection con=DBConnection.getConnection()){
			System.out.print("Enter Eno: ");
			int id=sc.nextInt();
			PreparedStatement ps=con.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
			ps.setInt(1,id);
			int row=ps.executeUpdate();
			if(row>0)
				System.out.println("Student Deleted");
			else
				System.out.println("Student Not Found");
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displaySorted() {
		try(Connection con=DBConnection.getConnection()){
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM STUDENT ORDER BY PERCENTAGE DESC");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " +
			rs.getString(2) + " " + 
						rs.getFloat(4));
				
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	
		}
	
}