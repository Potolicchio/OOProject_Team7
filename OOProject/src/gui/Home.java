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
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;


public class Home {

	private JFrame Home;
	private JLabel lblWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String username)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
						Home window = new Home(username);
						window.Home.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home(String user) 
	{
			initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(String user)
	{	
		Home = new JFrame();
		Home.setType(Type.UTILITY);
		Home.setTitle("Home");
		Home.setFont(new Font("Agency FB", Font.PLAIN, 16));
		Home.getContentPane().setBackground(Color.GRAY);
		Home.setBounds(100, 100, 450, 300);
		Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Home.getContentPane().setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 17));
		lblHome.setBounds(199, 61, 76, 23);
		Home.getContentPane().add(lblHome);
		
		
		JButton btnGames = new JButton("Games");
		btnGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGames.setBounds(168, 117, 117, 29);
		Home.getContentPane().add(btnGames);
		
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
		btnTeams.setBounds(168, 166, 117, 29);
		Home.getContentPane().add(btnTeams);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(Home, "Confirm if you want to logout", "Login System",
					 JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnLogOut.setBounds(340, 12, 93, 29);
		Home.getContentPane().add(btnLogOut);
		
		lblWelcome = new JLabel("");
		lblWelcome.setBounds(10, 18, 117, 14);
		
		lblWelcome.setText("Welcome " + user + "!");
		Home.getContentPane().add(lblWelcome);
		
	}
}
