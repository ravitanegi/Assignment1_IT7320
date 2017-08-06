package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Sign_up_page extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField username;
	private JTextField dob;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up_page frame = new Sign_up_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sign_up_page() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 21, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(22, 46, 46, 14);
		contentPane.add(lblDob);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(22, 71, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setBounds(22, 95, 46, 14);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 120, 46, 14);
		contentPane.add(lblPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(54, 180, 89, 23);
		contentPane.add(btnSubmit);
		
		password = new JPasswordField();
		password.setBounds(137, 117, 144, 20);
		contentPane.add(password);
		
		username = new JTextField();
		username.setBounds(137, 92, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(137, 43, 86, 20);
		contentPane.add(dob);
		dob.setColumns(10);
		
		name = new JTextField();
		name.setBounds(137, 18, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JComboBox gender = new JComboBox();
		gender.addItem("Male");
		gender.addItem("Female");
		gender.setSelectedItem(null);
		gender.setToolTipText("");
		gender.setBounds(137, 68, 75, 20);
		contentPane.add(gender);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dbconnection dbcon = new Dbconnection();
				dbcon.writeToDb(name.getText(),username.getText(),dob.getText(),gender.getSelectedItem() + "",password.getText());
			}
		});
	}
}
