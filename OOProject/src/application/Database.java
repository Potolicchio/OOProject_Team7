package application;

import java.sql.*;

public class Database {
	
	public static Connection getConnection()
	{
		Connection myConn = null;
		
		try 
		{	
			//No longer needed in newer versions of the J Connector
			//Class.forName("com.mysql.cj.jdbc.Driver");
				
			// 1. Get a connection to the database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooproject", "root", "Poto@SQL2019!");
		}
		catch (Exception exc)	
		{
			exc.printStackTrace();	
		}
		
		return myConn;
	}

}

//2. Create a statement			
//Statement myStmt = myConn.createStatement();
			
// 3. Execute SQL query		
//ResultSet myRs = myStmt.executeQuery("select * from People");
				
			
// 4. Process the result set
//while (myRs.next())		
//{			
	//System.out.println(myRs.getString("lastName") + ", " + myRs.getString("firstName"));			
//}
