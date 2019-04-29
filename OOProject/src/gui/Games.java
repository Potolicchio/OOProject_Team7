package gui;

import application.Database;
import application.Game;
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

public class Games {

	private JFrame frmGames;
	private JTextField gameTextField;
	private JTable table;
	
	/**
	 * Get Team information from DB
	 */
	public List<Game> getAllGames() throws Exception
	{
		List<Game> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try
		{
			myStmt = Database.getConnection().createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM Games");
			
			while (myRs.next())
			{
				Game tempGame = convertRowToGame(myRs);
				list.add(tempGame);
			}
			
			return list;
		}
		finally
		{
			close(myStmt, myRs);
		}
	}
	
	public List<Game> searchGames(String teamName) throws Exception
	{
		List<Game> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try
		{
			//Append names with % so we can use SQL "like" command
			teamName += "%";
			myStmt = Database.getConnection().prepareStatement("SELECT * FROM Games WHERE homeTeam LIKE ? OR awayTeam LIKE ?");
			
			//set value of ? accordingly			
			myStmt.setString(1, teamName);
			myStmt.setString(2, teamName);
			
			myRs = myStmt.executeQuery();
			
			while(myRs.next())
			{
				Game tempGame = convertRowToGame(myRs);
				list.add(tempGame);
			}
			
			return list;
		}
		finally
		{
			close(myStmt, myRs);
		}
	}
	
	private Game convertRowToGame(ResultSet myRs) throws SQLException
	{	
		String date = myRs.getString("date");
		String time = myRs.getString("time");
		String field = myRs.getString("field");
		String homeTeam = myRs.getString("homeTeam");
		int homeGoals = myRs.getInt("homeGoals");
		String awayTeam = myRs.getString("awayTeam");
		int awayGoals = myRs.getInt("awayGoals");
		String winner = myRs.getString("winner");
		
		Game tempGame = new Game(date, time, field, homeTeam, homeGoals, awayTeam, awayGoals, winner);
		
		return tempGame;
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
					Games window = new Games();
					window.frmGames.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//Print data from DB to console to test program		
		Games test = new Games();
				
		List<Game> testList = new ArrayList<>();
		testList = test.getAllGames();
		for(Game i:testList)
		{
			System.out.println("Date: " + i.getDate());	
			System.out.println("Time: " + i.getTime());
			System.out.println("Field: " + i.getField());
			System.out.println("Home Team: " + i.getHomeTeam());
			System.out.println("Home Goals: " + i.getHomeGoals());
			System.out.println("Away Team: " + i.getAwayTeam());
			System.out.println("Away Goals: " + i.getAwayGoals());
			System.out.println("Winner: " + i.getWinner());
		}
				
		List<Game> testList1 = new ArrayList<>();
		testList1 = test.searchGames("juv");
		for(Game i:testList1)
		{
			System.out.println("Date: " + i.getDate());	
			System.out.println("Time: " + i.getTime());
			System.out.println("Field: " + i.getField());
			System.out.println("Home Team: " + i.getHomeTeam());
			System.out.println("Home Goals: " + i.getHomeGoals());
			System.out.println("Away Team: " + i.getAwayTeam());
			System.out.println("Away Goals: " + i.getAwayGoals());
			System.out.println("Winner: " + i.getWinner());
		}
	}

	/**
	 * Create the application.
	 */
	public Games() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGames = new JFrame();
		frmGames.setTitle("Games");
		frmGames.setBounds(100, 100, 450, 300);
		frmGames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGames.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmGames.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblEnter = new JLabel("Enter Team Name:");
		panel.add(lblEnter);
		
		gameTextField = new JTextField();
		panel.add(gameTextField);
		gameTextField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					// Get the user input (Team name) from the text field
					String teamName = gameTextField.getText();
					
					List<Game> games = null;
					
					if (teamName != null && teamName.trim().length() > 0)
					{
						games = searchGames(teamName);
					}
					else
					{
						// If Team name is empty, get all Teams
						games = getAllGames();
					}
					
					// Prints to console to test functionality
					/*
					for (Team temp:teams)
					{
						System.out.println(temp.getName());
					}
					*/
					
					// Create the table model
					GameTableModel model = new GameTableModel(games);
					
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
		
		JButton btnAddGame = new JButton("Add Game");
		btnAddGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGames.setVisible(false);
				AddGames.main(null);
			}
		});
		panel.add(btnAddGame);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmGames.dispose();
					Home.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnHome);
		
		JScrollPane scrollPane = new JScrollPane();
		frmGames.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
