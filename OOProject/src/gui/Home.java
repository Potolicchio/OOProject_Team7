package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Home {

	private JFrame frame;
	private JLabel lblWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String string) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home(string);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setBounds(210, 6, 61, 16);
		frame.getContentPane().add(lblHome);
		
		
		JButton btnGames = new JButton("Games");
		btnGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGames.setBounds(174, 34, 117, 29);
		frame.getContentPane().add(btnGames);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.setBounds(174, 75, 117, 29);
		frame.getContentPane().add(btnSchedule);
		
		JButton btnTeams = new JButton("Teams");
		btnTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Teams.main(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnTeams.setBounds(174, 116, 117, 29);
		frame.getContentPane().add(btnTeams);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.setBounds(174, 157, 117, 29);
		frame.getContentPane().add(btnAccount);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to logout", "Login System",
					 JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnLogOut.setBounds(174, 199, 117, 29);
		frame.getContentPane().add(btnLogOut);
		
		lblWelcome = new JLabel("");
		lblWelcome.setBounds(10, 7, 125, 14);
		lblWelcome.setText("Welcome! " + user);
		frame.getContentPane().add(lblWelcome);
		
	}
}
