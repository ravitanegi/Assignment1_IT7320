package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.CYAN);
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(34, 57, 78, 14);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(33, 103, 79, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(145, 54, 131, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 100, 131, 20);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnSignin = new JButton("Signin");
		btnSignin.setBounds(65, 149, 89, 23);
		frmLogin.getContentPane().add(btnSignin);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.setBounds(176, 149, 89, 23);
		frmLogin.getContentPane().add(btnSignup);
	}
}
