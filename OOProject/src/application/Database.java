package application;

import java.sql.*;

public class Database {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		try 
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 1. Get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooproject", "root", "Poto@SQL2019!");
			
			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from People");
			
			// 4. Process the result set
			while (myRs.next())
			{
				System.out.println(myRs.getString("lastName") + ", " + myRs.getString("firstName"));
			}
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}

	}

}
