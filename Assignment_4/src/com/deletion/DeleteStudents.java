package com.deletion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Connection c=null;
PreparedStatement ps=null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	c=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/DB",
			"root",
			"dfhjd1786@0");
	System.out.println("Connection Successful");
	String deleteQuery="DELETE FROM STUDENT WHERE YEAR_OF_PASSING = ? AND BRANCH = ?";
	ps=c.prepareStatement(deleteQuery);
	ps.setInt(1, 2024);
	ps.setString(2, "Civil");
	int rows=ps.executeUpdate();
	if(rows>0) {
		System.out.println("Deleted" + rows + "Civil students passed in 2024");
		
	}
	else {
		System.out.println("No matching recors found");
	}
	
}
catch(Exception e) {
	System.out.print("SQL Error");
	e.printStackTrace();
}
finally {
	try {
		if(ps!=null) ps.close();
		if(c!=null) c.close();
		
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
	}

}