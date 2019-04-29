package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import application.Database;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddTeam 
{

	private JFrame frmCreateTeam;
	private JTextField txtTeamName;
	private JTextField txtDivision;
	private JTextField txtStanding;
	private JTextField txtWins;
	private JTextField txtLosses;
	private JTextField txtTies;
	private JTextField txtPoints;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeam window = new AddTeam();
					window.frmCreateTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmCreateTeam = new JFrame();
		frmCreateTeam.getContentPane().setBackground(Color.GRAY);
		frmCreateTeam.setTitle("Create Team");
		frmCreateTeam.setBounds(100, 100, 450, 300);
		frmCreateTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateTeam.getContentPane().setLayout(null);
		
		JLabel lblTeamName = new JLabel("Team Name:");
		lblTeamName.setBounds(10, 11, 79, 14);
		frmCreateTeam.getContentPane().add(lblTeamName);
		
		JLabel lblDivision = new JLabel("Division:");
		lblDivision.setBounds(10, 50, 46, 14);
		frmCreateTeam.getContentPane().add(lblDivision);
		
		JLabel lblStandings = new JLabel("Standings:");
		lblStandings.setBounds(10, 103, 62, 14);
		frmCreateTeam.getContentPane().add(lblStandings);
		
		JLabel lblWins = new JLabel("Wins:");
		lblWins.setBounds(10, 151, 46, 14);
		frmCreateTeam.getContentPane().add(lblWins);
		
		JLabel lblLosses = new JLabel("Ties:");
		lblLosses.setBounds(255, 151, 36, 14);
		frmCreateTeam.getContentPane().add(lblLosses);
		
		JLabel lblLosses_1 = new JLabel("Losses:");
		lblLosses_1.setBounds(120, 151, 46, 14);
		frmCreateTeam.getContentPane().add(lblLosses_1);
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setBounds(10, 206, 46, 14);
		frmCreateTeam.getContentPane().add(lblPoints);

		txtTeamName = new JTextField();
		txtTeamName.setBounds(98, 8, 175, 20);
		frmCreateTeam.getContentPane().add(txtTeamName);
		txtTeamName.setColumns(10);
		
		txtDivision = new JTextField();
		txtDivision.setBounds(98, 47, 175, 20);
		frmCreateTeam.getContentPane().add(txtDivision);
		txtDivision.setColumns(10);
		
		txtStanding = new JTextField();
		txtStanding.setColumns(10);
		txtStanding.setBounds(98, 100, 175, 20);
		frmCreateTeam.getContentPane().add(txtStanding);
		
		txtWins = new JTextField();
		txtWins.setText("");
		txtWins.setBounds(44, 148, 66, 20);
		frmCreateTeam.getContentPane().add(txtWins);
		txtWins.setColumns(10);
		
		txtLosses = new JTextField();
		txtLosses.setColumns(10);
		txtLosses.setBounds(170, 148, 75, 20);
		frmCreateTeam.getContentPane().add(txtLosses);
		
		txtTies = new JTextField();
		txtTies.setBounds(289, 148, 86, 20);
		frmCreateTeam.getContentPane().add(txtTies);
		txtTies.setColumns(10);
		
		txtPoints = new JTextField();
		txtPoints.setText("");
		txtPoints.setColumns(10);
		txtPoints.setBounds(55, 203, 66, 20);
		frmCreateTeam.getContentPane().add(txtPoints);
		
		
		JButton btnAddTeam = new JButton("Add Team");
		btnAddTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(txtTeamName.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Team name", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtDivision.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Team's division", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtStanding.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter Team standing", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtWins.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter the number of wins", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtLosses.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter the number of losses", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtTies.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter the number to ties", "Error", JOptionPane.ERROR_MESSAGE);
				else if (txtPoints.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter the number of points", "Error", JOptionPane.ERROR_MESSAGE);
				
				if (!txtTeamName.getText().isEmpty() && !txtDivision.getText().isEmpty() && !txtStanding.getText().isEmpty() 
						&& !txtWins.getText().isEmpty() && !txtLosses.getText().isEmpty() && !txtTies.getText().isEmpty()
						&& !txtPoints.getText().isEmpty())
				{
					PreparedStatement myStmt = null;
					
					try {
							Connection	myConn = Database.getConnection();
							String query  = "INSERT into Teams(teamName, division, standing, wins, losses, ties, points ) values (?, ?, ?, ?, ?, ?, ?);";
							myStmt = myConn.prepareStatement(query);
							myStmt.setString(1, txtTeamName.getText());
							myStmt.setInt(2, Integer.parseInt(txtDivision.getText()));
							myStmt.setInt(3, Integer.parseInt(txtStanding.getText()));
							myStmt.setInt(4, Integer.parseInt(txtWins.getText()));
							myStmt.setInt(5, Integer.parseInt(txtLosses.getText()));
							myStmt.setInt(6, Integer.parseInt(txtTies.getText()));
							myStmt.setInt(7, Integer.parseInt(txtPoints.getText()));
							
							int myRs = myStmt.executeUpdate();
							
							if (myRs == 1)
							{
								JOptionPane.showMessageDialog(null, "New Team Added.");
								txtTeamName.setText(null);
								txtDivision.setText(null);
								txtStanding.setText(null);
								txtWins.setText(null);
								txtLosses.setText(null);
								txtTies.setText(null);
								txtPoints.setText(null);
								myConn.close();
							}
										
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnAddTeam.setBounds(233, 227, 102, 23);
		frmCreateTeam.getContentPane().add(btnAddTeam);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmCreateTeam.dispose();
				try {
					Teams.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancel.setBounds(120, 227, 89, 23);
		frmCreateTeam.getContentPane().add(btnCancel);
	}
}
