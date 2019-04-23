package gui;

import application.Database;
import application.Team;

import java.sql.*;

import java.util.*;
import java.util.List;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Teams {

	private JFrame frame;
	
	/**
	 * Get Team information from DB
	 */
	public List<Team> getAllTeams() throws Exception
	{
		List<Team> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try
		{
			myStmt = Database.getConnection().createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM Teams");
			
			while (myRs.next())
			{
				Team tempTeam = convertRowToTeam(myRs);
				list.add(tempTeam);
			}
			
			return list;
		}
		finally
		{
			close(myStmt, myRs);
		}
	}
	
	public List<Team> searchTeams(String teamName) throws Exception
	{
		List<Team> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try
		{
			teamName += "%";
			myStmt = Database.getConnection().prepareStatement("SELECT * FROM Teams WHERE teamName LIKE ?");
			
			myStmt.setString(1, teamName);
			
			myRs = myStmt.executeQuery();
			
			while(myRs.next())
			{
				Team tempTeam = convertRowToTeam(myRs);
				list.add(tempTeam);
			}
			
			return list;
		}
		finally
		{
			close(myStmt, myRs);
		}
	}
	
	private Team convertRowToTeam(ResultSet myRs) throws SQLException
	{
		String name = myRs.getString("teamName");
		int division = myRs.getInt("division");
		int standing = myRs.getInt("standing");
		int wins = myRs.getInt("wins");
		int losses = myRs.getInt("losses");
		int ties = myRs.getInt("ties");
		int points = myRs.getInt("points");
		
		Team tempTeam = new Team(name, division, standing, wins, losses, ties, points);
		
		return tempTeam;
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException
	{
		if (myRs != null) 
		{
			myRs.close();
		}

		if (myStmt != null) 
		{
			
		}
		
		if (myConn != null) 
		{
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException
	{
		close(null, myStmt, myRs);		
	}

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Teams window = new Teams();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//Print data from DB to console to test program
		Teams test = new Teams();
		List<Team> testList = new ArrayList<>();
		testList = test.getAllTeams();
		for(Team i:testList)
		{
			System.out.println("Teams: " + i.getName());
			System.out.println("Division: " + i.getDivision());
			System.out.println("Standing: " + i.getStanding());
			System.out.println("Wins: " + i.getWins());
			System.out.println("Losses: " + i.getLosses());
			System.out.println("Ties: " + i.getTies());
			System.out.println("Points: " + i.getPoints());
		}
	}

	/**
	 * Create the application.
	 */
	public Teams() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTeams = new JLabel("Teams");
		lblTeams.setBounds(190, 6, 61, 16);
		frame.getContentPane().add(lblTeams);
	}
}
