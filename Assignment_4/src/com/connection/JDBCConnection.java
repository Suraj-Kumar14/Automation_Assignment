package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	Connection c=null;
	JDBCConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/DB",
					"root",
					"dnfjhe1786@0"
					);
			if(c!=null) {
				System.out.println("Connection Successful");
			}
			else {
				System.out.println("Unable to connect");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver not found");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("Unable to connect");
			e.printStackTrace();
		}
		finally {
			try {
				if(c!=null) {
					c.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new JDBCConnection();
	}

}