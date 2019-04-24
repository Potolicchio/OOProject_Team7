package gui;

import application.Database;
import application.Team;

import java.sql.*;

import java.util.*;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Teams {

	private JFrame frmTeams;
	private JTextField teamNameTextField;
	private JTable table;
	
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
			//Append names with % so we can use SQL "like" command
			teamName += "%";
			myStmt = Database.getConnection().prepareStatement("SELECT * FROM Teams WHERE teamName LIKE ?");
			
			//set value of ? accordingly			
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
		String teamName = myRs.getString("teamName");
		int division = myRs.getInt("division");
		int standing = myRs.getInt("standing");
		int wins = myRs.getInt("wins");
		int losses = myRs.getInt("losses");
		int ties = myRs.getInt("ties");
		int points = myRs.getInt("points");
		
		Team tempTeam = new Team(teamName, division, standing, wins, losses, ties, points);
		
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
					window.frmTeams.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//Print data from DB to console to test program
		/*Teams test = new Teams();
		
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
		
		List<Team> testList1 = new ArrayList<>();
		testList1 = test.searchTeams("juv");
		for(Team i:testList1)
		{
			System.out.println("Teams: " + i.getName());
			System.out.println("Division: " + i.getDivision());
			System.out.println("Standing: " + i.getStanding());
			System.out.println("Wins: " + i.getWins());
			System.out.println("Losses: " + i.getLosses());
			System.out.println("Ties: " + i.getTies());
			System.out.println("Points: " + i.getPoints());
		}*/
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
		frmTeams = new JFrame();
		frmTeams.setTitle("Teams");
		frmTeams.setBounds(100, 100, 450, 300);
		frmTeams.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeams.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmTeams.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterTeamName = new JLabel("Enter Team Name:");
		panel.add(lblEnterTeamName);
		
		teamNameTextField = new JTextField();
		panel.add(teamNameTextField);
		teamNameTextField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					// Get the user input (Team name) from the text field
					String teamName = teamNameTextField.getText();
					
					List<Team> teams = null;
					
					if (teamName != null && teamName.trim().length() > 0)
					{
						teams = searchTeams(teamName);
					}
					else
					{
						// If Team name is empty, get all Teams
						teams = getAllTeams();
					}
					
					// Prints to console to test functionality
					/*
					for (Team temp:teams)
					{
						System.out.println(temp.getName());
					}
					*/
					
					// Create the table model
					TeamTableModel model = new TeamTableModel(teams);
					
					//Update the table
					table.setModel(model);
					
				}
				catch (Exception exc)
				{
					JOptionPane.showInputDialog(btnSearch, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		frmTeams.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
