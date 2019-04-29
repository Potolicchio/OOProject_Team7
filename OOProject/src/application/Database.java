package application;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Database {
	
	/**
	 * Method that connects to the local MySQL database.
	 * @return myConn connection to DB
	 */
	public static Connection getConnection()
	{
		Connection myConn = null;
		
		Properties props = new Properties();
		
		try 
		{	
			//Get DB properties
			props.load(new FileInputStream("properties"));
			
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String dburl = props.getProperty("dburl");
			
			//No longer needed in newer versions of the J Connector
			//Class.forName("com.mysql.cj.jdbc.Driver");
				
			// Get a connection to the database
			myConn = DriverManager.getConnection(dburl, user, password);
			
			System.out.println("Connection to DB: " + dburl + " - SUCCESFUL.");
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
