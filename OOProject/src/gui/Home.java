package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setBounds(210, 6, 61, 16);
		frame.getContentPane().add(lblHome);
		
		JButton btnNewButton = new JButton("Games");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(174, 34, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Schedule");
		btnNewButton_1.setBounds(174, 75, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Teams");
		btnNewButton_2.setBounds(174, 116, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.setBounds(174, 157, 117, 29);
		frame.getContentPane().add(btnAccount);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(174, 199, 117, 29);
		frame.getContentPane().add(btnLogOut);
	}
}
