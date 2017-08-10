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
import java.awt.SystemColor;

public class Chat_Box extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;

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
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 45, 325, 224);
		contentPane.add(textArea);
		
		JList list = new JList();
		list.setBounds(371, 92, 1, 1);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(356, 45, 128, 229);
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
		
		JButton btnSend_1 = new JButton("SignOut");
		btnSend_1.setBounds(356, 322, 128, 23);
		contentPane.add(btnSend_1);
	}
}
