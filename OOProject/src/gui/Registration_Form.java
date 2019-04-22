package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Registration_Form {

	private JFrame Registration;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_Form window = new Registration_Form();
					window.Registration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		Registration = new JFrame();
		Registration.setTitle("Registration Form");
		Registration.setBounds(208, 100, 848, 468);
		Registration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Registration.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Login.main(null);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 35, 14);
		Registration.getContentPane().add(lblNewLabel_1);
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setBackground(new Color(255, 215, 0));
		lblbackground.setOpaque(true);
		lblbackground.setBounds(0, 0, 274, 429);
		Registration.getContentPane().add(lblbackground);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(45, 161, 173, 169);
		Registration.getContentPane().add(lblNewLabel_2);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(319, 79, 282, 28);
		Registration.getContentPane().add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(319, 132, 282, 28);
		Registration.getContentPane().add(txtLastname);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(319, 185, 282, 28);
		Registration.getContentPane().add(txtEmail);
		
		JLabel lblNewLabel_3 = new JLabel("Firstname");
		lblNewLabel_3.setBounds(319, 62, 91, 14);
		Registration.getContentPane().add(lblNewLabel_3);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setBounds(319, 118, 91, 14);
		Registration.getContentPane().add(lblLastname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(319, 171, 91, 14);
		Registration.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(319, 249, 91, 14);
		Registration.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(319, 304, 132, 14);
		Registration.getContentPane().add(lblConfirmPassword);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(721, 378, 89, 23);
		Registration.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				txtFirstname.setText(null);
				txtLastname.setText(null);
				txtEmail.setText(null);
				txtPassword.setText(null);
				txtConfirmPassword.setText(null);
			}
		});
		
		btnReset.setBounds(321, 378, 89, 23);
		Registration.getContentPane().add(btnReset);
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		lblRegistrationForm.setBounds(490, 30, 186, 28);
		Registration.getContentPane().add(lblRegistrationForm);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(319, 265, 282, 28);
		Registration.getContentPane().add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(319, 319, 282, 28);
		Registration.getContentPane().add(txtConfirmPassword);
	}
}