package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.List;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class Teams {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teams window = new Teams();
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
	public Teams() {
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
		
		JLabel lblTeams = new JLabel("Teams");
		lblTeams.setBounds(190, 6, 61, 16);
		frame.getContentPane().add(lblTeams);
	}
}
