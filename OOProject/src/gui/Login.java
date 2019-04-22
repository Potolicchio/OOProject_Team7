package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.SystemColor;

public class Login 
{

	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setForeground(new Color(0, 0, 204));
		frmLogin.getContentPane().setBackground(SystemColor.windowBorder);
		frmLogin.setBackground(Color.GRAY);
		frmLogin.setForeground(Color.GRAY);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(200, 200, 448, 295);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		/**
		 * Create the labeling
		 */
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.ITALIC, 14));
		lblEmail.setBounds(24, 99, 75, 17);
		frmLogin.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.ITALIC, 14));
		lblPassword.setBounds(24, 154, 75, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("Enter Username here");
		txtUsername.setBounds(147, 98, 207, 20);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Enter Password");
		txtPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtPassword.setBounds(147, 146, 207, 20);
		frmLogin.getContentPane().add(txtPassword);
		
		/**
		 * Creating the buttons + their functionality
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String password = String.valueOf(txtPassword.getPassword());
				String username = txtUsername.getText();
				
				if (password.contains("king") && username.contains("One")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					frmLogin.setVisible(false);
					Home.main(null);
				}
				else
				{ 
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin.setBounds(49, 227, 89, 23);
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(183, 227, 89, 23);
		frmLogin.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				frmLogin = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLogin, "Confirm if you want to exit", "Login System",
					 JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		
		btnExit.setBounds(308, 227, 89, 23);
		frmLogin.getContentPane().add(btnExit);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 22));
		lblLogin.setBounds(183, 22, 75, 28);
		frmLogin.getContentPane().add(lblLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(10, 204, 422, 2);
		frmLogin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.desktop);
		separator_1.setBounds(10, 79, 412, 8);
		frmLogin.getContentPane().add(separator_1);
		
		JLabel lblNew_user = new JLabel("New User?, Register");
		lblNew_user.setFont(UIManager.getFont("ToolTip.font"));
		lblNew_user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNew_user.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Registration_Form.main(null);
			}
		});
		
		
		lblNew_user.setBounds(297, 179, 135, 14);
		frmLogin.getContentPane().add(lblNew_user);
	}
}
