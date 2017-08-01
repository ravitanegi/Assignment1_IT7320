package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

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
		
		txtUsername = new JTextField();
		txtUsername.setBounds(145, 54, 131, 20);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(145, 100, 131, 20);
		frmLogin.getContentPane().add(txtPassword);
		
		JButton btnSignin = new JButton("Signin");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result=0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");

					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("Select 1 from userinfo where Username = '" + txtUsername.getText() + "' And Password = '"+ txtPassword.getText() +"' ");
					while(rs.next()) {
						result++;
					}
						
				} catch (Exception e) {
					e.printStackTrace();
				} 
				if (result>0)
				{
				
					Chat_Box navigate = new Chat_Box();
					navigate.setVisible(true);
					frmLogin.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect Credentials");
				}
			
			}
		});
		btnSignin.setBounds(65, 149, 89, 23);
		frmLogin.getContentPane().add(btnSignin);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sign_up_page navigate = new Sign_up_page();
				navigate.setVisible(true);
				frmLogin.dispose();
			}
		});
		btnSignup.setBounds(176, 149, 89, 23);
		frmLogin.getContentPane().add(btnSignup);
	}
}
