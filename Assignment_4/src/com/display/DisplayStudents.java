
package com.display;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DisplayStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Connection c=null;
PreparedStatement ps=null;
ResultSet rs=null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	c=DriverManager.getConnection(
			
			"jdbc:mysql://localhost:3306/DB",
			"root",
			"arhamKhan1786@0");
	System.out.println("Connection Successful");
	String selectQuery="SELECT * FROM STUDENT WHERE SEMESTER =? AND BRANCH =? ";
	ps=c.prepareStatement(selectQuery);
	ps.setInt(1, 7);
	ps.setString(2, "CSE");
	
	rs=ps.executeQuery();
	System.out.println("ID\tNAME\tBRANCH\tSEMESTER");
	System.out.println("----------------------------------");
	
	boolean found=false;
	while(rs.next()) {
		found=true;
		System.out.print(rs.getInt("ID"));
		System.out.print(rs.getString("NAME") + "\t\t");
		System.out.print(rs.getString("BRANCH") + "\t");
		System.out.println(rs.getInt("SEMESTER"));
		
	}
	if(!found) {
		System.out.println("No records found");
	}
}catch(Exception e) {
	System.out.println("SQL Error");
	e.printStackTrace();
}finally {
	try {
		if(rs!=null) rs.close();
		if(ps!=null)ps.close();
		if(c!=null) c.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	}

}
