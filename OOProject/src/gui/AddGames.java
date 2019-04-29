package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import application.Database;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddGames {

	private JFrame frmAddGames;
	private JTextField txtWinner;
	private JTextField txtAwayTeam;
	private JTextField txtHomeTeam;
	private JTextField txtTime;
	private JTextField txtDate;
	private JTextField txtHomeGoals;
	private JTextField txtAwayGoals;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGames window = new AddGames();
					window.frmAddGames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddGames() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddGames = new JFrame();
		frmAddGames.setTitle("Add Games");
		frmAddGames.setBounds(100, 100, 450, 300);
		frmAddGames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddGames.getContentPane().setLayout(null);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setBounds(10, 11, 46, 14);
		frmAddGames.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(10, 36, 46, 14);
		frmAddGames.getContentPane().add(lblTime);
		
		JLabel lblStadium = new JLabel("Stadium: ");
		lblStadium.setBounds(10, 61, 46, 14);
		frmAddGames.getContentPane().add(lblStadium);
		
		JLabel lblHomeTeam = new JLabel("Home Team:");
		lblHomeTeam.setBounds(10, 86, 73, 14);
		frmAddGames.getContentPane().add(lblHomeTeam);
		
		JLabel lblHmGoals = new JLabel("Goals:");
		lblHmGoals.setBounds(241, 86, 46, 14);
		frmAddGames.getContentPane().add(lblHmGoals);
		
		JLabel lblAwayTeam = new JLabel("Away Team: ");
		lblAwayTeam.setBounds(10, 111, 63, 14);
		frmAddGames.getContentPane().add(lblAwayTeam);
		
		JLabel lblGoals = new JLabel("Goals: ");
		lblGoals.setBounds(241, 111, 46, 14);
		frmAddGames.getContentPane().add(lblGoals);
		
		JLabel lblWinner = new JLabel("Winner: ");
		lblWinner.setBounds(10, 167, 46, 14);
		frmAddGames.getContentPane().add(lblWinner);
		
		txtWinner = new JTextField();
		txtWinner.setBounds(90, 164, 168, 20);
		frmAddGames.getContentPane().add(txtWinner);
		txtWinner.setColumns(10);
		
		txtAwayTeam = new JTextField();
		txtAwayTeam.setBounds(90, 108, 129, 20);
		frmAddGames.getContentPane().add(txtAwayTeam);
		txtAwayTeam.setColumns(10);
		
		txtHomeTeam = new JTextField();
		txtHomeTeam.setColumns(10);
		txtHomeTeam.setBounds(90, 83, 129, 20);
		frmAddGames.getContentPane().add(txtHomeTeam);
		
		JTextField txtStadium = new JTextField();
		txtStadium.setColumns(10);
		txtStadium.setBounds(90, 58, 129, 20);
		frmAddGames.getContentPane().add(txtStadium);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(90, 33, 129, 20);
		frmAddGames.getContentPane().add(txtTime);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(90, 11, 129, 20);
		frmAddGames.getContentPane().add(txtDate);
		
		txtHomeGoals = new JTextField();
		txtHomeGoals.setColumns(10);
		txtHomeGoals.setBounds(283, 83, 129, 20);
		frmAddGames.getContentPane().add(txtHomeGoals);
		
		txtAwayGoals = new JTextField();
		txtAwayGoals.setColumns(10);
		txtAwayGoals.setBounds(283, 111, 129, 20);
		frmAddGames.getContentPane().add(txtAwayGoals);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmAddGames.dispose();
				try {
					Games.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnCancel.setBounds(130, 227, 89, 23);
		frmAddGames.getContentPane().add(btnCancel);
		
		JButton btnAddGame = new JButton("Add Game");
		btnAddGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(txtDate.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Date", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtTime.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Time", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtStadium.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Staduim", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtHomeTeam.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Home Team", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtAwayTeam.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Away Team", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtHomeGoals.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Home goals", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtAwayGoals.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Away goals", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtWinner.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Winner", "Error", JOptionPane.ERROR_MESSAGE);
				
				if (!txtDate.getText().isEmpty() && !txtTime.getText().isEmpty() && !txtStadium.getText().isEmpty() 
						&& !txtHomeTeam.getText().isEmpty() && !txtAwayTeam.getText().isEmpty() && !txtHomeGoals.getText().isEmpty()
						&& !txtAwayGoals.getText().isEmpty() && !txtWinner.getText().isEmpty())
				{
					PreparedStatement myStmt = null;
					
					try {
							Connection	myConn = Database.getConnection();
							String query  = "INSERT into Games(date, time, field, homeTeam, homeGoals, awayTeam, awayGoals, winner ) "
									      + "values (?, ?, ?, ?, ?, ?, ?, ?);";
							
							myStmt = myConn.prepareStatement(query);
							myStmt.setString(1, txtDate.getText());
							myStmt.setString(2, txtTime.getText());
							myStmt.setString(3, txtStadium.getText());
							myStmt.setString(4, txtHomeTeam.getText());
							myStmt.setInt(5, Integer.parseInt(txtHomeGoals.getText()));
							myStmt.setString(6, txtAwayTeam.getText());
							myStmt.setInt(7, Integer.parseInt(txtAwayGoals.getText()));
							myStmt.setString(8, txtWinner.getText());
							
							int myRs = myStmt.executeUpdate();
							
							if (myRs == 1)
							{
								JOptionPane.showMessageDialog(null, "New Game Added.");
								txtDate.setText(null);
								txtTime.setText(null);
								txtStadium.setText(null);
								txtHomeTeam.setText(null);
								txtHomeGoals.setText(null);
								txtAwayTeam.setText(null);
								txtAwayGoals.setText(null);
								txtWinner.setText(null);
								myConn.close();
							}
										
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnAddGame.setBounds(259, 227, 89, 23);
		frmAddGames.getContentPane().add(btnAddGame);
		
	}

}
