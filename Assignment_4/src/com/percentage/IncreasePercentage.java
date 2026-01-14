package com.percentage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


	public class IncreasePercentage {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	Connection c=null;
	PreparedStatement ps=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		c=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/DB",
				"root",
				"arhamKhan1786@0");
		System.out.println("Connection Successful");
		String updateQuery="UPDATE Student SET PERCENTAGE=PERCENTAGE + 5 WHERE BRANCH = ? ";
		ps=c.prepareStatement(updateQuery);
		ps.setString(1, "CSE");
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Percentage increased by 5% fro CSE students");
			
		}
		else {
			System.out.println("No CSE students is found");
		}
	}
	catch(Exception e) {
		System.out.println("SQL Error");
		e.printStackTrace();
	}
	finally {
		try {
			if(ps!=null) ps.close();
			if(c!=null) c.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		}
	
	
}