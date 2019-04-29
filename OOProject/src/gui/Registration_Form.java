package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;

import application.Database;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import java.sql.*;
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
		
		JLabel close = new JLabel("X");
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Registration.dispose();
			}
		});
		close.setFont(new Font("Tahoma", Font.BOLD, 14));
		close.setBackground(Color.WHITE);
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setBounds(0, 0, 35, 14);
		Registration.getContentPane().add(close);
		

		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		lblRegistrationForm.setBounds(490, 30, 186, 28);
		Registration.getContentPane().add(lblRegistrationForm);
		
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
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(319, 265, 282, 28);
		Registration.getContentPane().add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(319, 319, 282, 28);
		Registration.getContentPane().add(txtConfirmPassword);
		
		/**
		 * Radio button selection
		 */
		JRadioButton rb_User = new JRadioButton("User");
		rb_User.setBounds(646, 188, 109, 23);
	    rb_User.setActionCommand("User");
		Registration.getContentPane().add(rb_User);
		
		JRadioButton rb_Player = new JRadioButton("Player");
		rb_Player.setBounds(646, 208, 109, 23);
	    rb_User.setActionCommand("Player");
		Registration.getContentPane().add(rb_Player);
		
		JRadioButton rb_Coach = new JRadioButton("Coach");
		rb_Coach.setBounds(646, 230, 109, 23);
	    rb_User.setActionCommand("Coach");
		Registration.getContentPane().add(rb_Coach);
		
		JRadioButton rb_Referree = new JRadioButton("Referree");
		rb_Referree.setBounds(646, 250, 109, 23);
	    rb_User.setActionCommand("Referree");
		Registration.getContentPane().add(rb_Referree);
		
		 //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(rb_User);
	    group.add(rb_Player);
	    group.add(rb_Coach);
	    group.add(rb_Referree);
		
	    JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(319, 224, 47, 14);
		Registration.getContentPane().add(lblGender);
		
		JRadioButton rb_Male = new JRadioButton("Male");
		rb_Male.setBounds(369, 220, 53, 23);
		rb_User.setActionCommand("M");
		Registration.getContentPane().add(rb_Male);
		
		JRadioButton rb_Female = new JRadioButton("Female");
		rb_Female.setBounds(424, 220, 65, 23);
		rb_User.setActionCommand("F");
		Registration.getContentPane().add(rb_Female);
	
		 ButtonGroup genderGroup = new ButtonGroup();
		 genderGroup.add(rb_Male);
		 genderGroup.add(rb_Female);
		 
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String fname = txtFirstname.getText();
				String lname = txtLastname.getText();
				String email = txtEmail.getText();
				String pword = txtPassword.getText();
				String type = "" , gender = "";
				PreparedStatement myStmt = null;
				int myRs = 0;
				
				if (fname.equals(""))
					JOptionPane.showMessageDialog(null, "Add a firstname", "Error", JOptionPane.ERROR_MESSAGE);
				
				else if  (lname.equals(""))
					JOptionPane.showMessageDialog(null, "Add a lastname", "Error", JOptionPane.ERROR_MESSAGE);
				
				else if (email.equals("") || !email.contains("@") && !email.contains(".com"))
					JOptionPane.showMessageDialog(null, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
				
				else if (pword.equals(""))
					JOptionPane.showMessageDialog(null, "Add apassword", "Error", JOptionPane.ERROR_MESSAGE);
				
				else if (!pword.equals(String.valueOf(txtConfirmPassword.getPassword())))
						JOptionPane.showMessageDialog(null, "Password does not match", "Error", JOptionPane.ERROR_MESSAGE);
					
				if (group.getSelection() == null)
					JOptionPane.showMessageDialog(null, "Please select a type.", "Error", JOptionPane.ERROR_MESSAGE);
				else 
					type = group.getSelection().getActionCommand();
				
				if (genderGroup.getSelection() == null)
					JOptionPane.showMessageDialog(null, "Please select a gender.", "Error", JOptionPane.ERROR_MESSAGE);	
				else 
					gender = genderGroup.getSelection().getActionCommand();
				
				
				try {
						Connection	myConn = Database.getConnection();
						String query  = "insert into Login (email, password) values ( ?, ?);";

						myStmt = myConn.prepareStatement(query);
						myStmt.setString(1, email);
						myStmt.setString(2, pword);
						myRs = myStmt.executeUpdate();
						System.out.println("End of part 1");
						
						// Get UserID that has just been created
						query = "select MAX(userID) AS ID FROM Login";
						myStmt = myConn.prepareStatement(query);
						ResultSet rs = myStmt.executeQuery();
						
						// People's Table.
						if (myRs == 1) 
						{
							query = "insert into people (userID, firstName, lastName, gender, age, phoneNumber, type) values (?, ?, ?, ?, ?, ?, ?)";
							myStmt = myConn.prepareStatement(query);
							rs.next();
							myStmt.setInt(1, rs.getInt("ID"));
							myStmt.setString(2, fname);
							myStmt.setString(3, lname);
							myStmt.setString(4, "M");
							myStmt.setInt(5, 25);
							myStmt.setString(6, "54646141");
							myStmt.setString(7, type);
							myRs += myStmt.executeUpdate();
						}
						
						if (myRs == 2)
						{
							JOptionPane.showMessageDialog(null, "New Account Added.");
							Registration.dispose();
							Login.main(null);
							myConn.close();
						}
						
					myConn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
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
		
		JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccountType.setBounds(646, 171, 91, 14);
		Registration.getContentPane().add(lblAccountType);
		
	    
	}
}