package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chat_Box extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat_Box frame = new Chat_Box();
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
	public Chat_Box() {
		setTitle("ChatApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHostAddress = new JLabel("Host Address :");
		lblHostAddress.setBounds(10, 11, 71, 14);
		contentPane.add(lblHostAddress);
		
		JLabel lblHistoryFile = new JLabel("History File:");
		lblHistoryFile.setBounds(10, 39, 71, 14);
		contentPane.add(lblHistoryFile);
		
		textField = new JTextField();
		textField.setBounds(91, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 36, 241, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHostPort = new JLabel("HostPort:");
		lblHostPort.setBounds(187, 11, 46, 14);
		contentPane.add(lblHostPort);
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 8, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnButton = new JButton("Connect");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnButton.setBounds(335, 7, 149, 23);
		contentPane.add(btnButton);
		
		JButton button = new JButton("...");
		button.setBounds(335, 35, 30, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.setBounds(371, 35, 113, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 64, 325, 205);
		contentPane.add(textArea);
		
		JList list = new JList();
		list.setBounds(371, 92, 1, 1);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(356, 69, 128, 205);
		contentPane.add(list_1);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(20, 289, 46, 14);
		contentPane.add(lblMessage);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 286, 266, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSend = new JButton("Send Message");
		btnSend.setBounds(356, 285, 128, 23);
		contentPane.add(btnSend);
		
		JLabel lblFile = new JLabel("File");
		lblFile.setBounds(20, 326, 46, 14);
		contentPane.add(lblFile);
		
		textField_4 = new JTextField();
		textField_4.setBounds(66, 323, 266, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSend_1 = new JButton("Send");
		btnSend_1.setBounds(356, 322, 89, 23);
		contentPane.add(btnSend_1);
	}
}
