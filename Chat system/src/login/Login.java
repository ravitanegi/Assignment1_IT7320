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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends Dbconnection{

	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField textField;
		
	private Socket socket;
	private ObjectInputStream In;
    private ObjectOutputStream Out;
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
		lblUsername.setBounds(33, 71, 78, 14);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(33, 103, 79, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setEnabled(false);
		txtUsername.setBounds(145, 69, 131, 20);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setEnabled(false);
		txtPassword.setBounds(145, 100, 131, 20);
		frmLogin.getContentPane().add(txtPassword);
		
		JButton btnSignin = new JButton("Signin");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//add the code here
				int result;
				
				result=dbInfoFetch("Select * From userinfo Where username = '"+ txtUsername.getText() +"' And password = '"+ txtPassword.getText() +"' ");
				
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
		
		JLabel lblNewLabel = new JLabel("IP Address:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(34, 32, 91, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(145, 30, 156, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					socket = new Socket(InetAddress.getByName("192.168.1.11"), 13000);
					Out = new ObjectOutputStream(socket.getOutputStream());
			        Out.flush();
			        In = new ObjectInputStream(socket.getInputStream());
			        Message msg = (Message) In.readObject();
			        System.out.println("Incoming : "+msg.toString());
			        txtUsername.setEnabled(true);
			        txtPassword.setEnabled(true);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnConnect.setBounds(335, 29, 89, 23);
		frmLogin.getContentPane().add(btnConnect);
	}
	
	
}
