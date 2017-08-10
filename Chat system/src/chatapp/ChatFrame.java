package chatapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.socket.Message;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;


public class ChatFrame extends JFrame {

	private JPanel contentPane;
	protected JTextField textField;
	protected JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	private JTextField textField_4;
	protected JTextArea textArea;
	public SocketClient client;
    public int port;
    public DefaultListModel model;
    protected String serverAddr, username, password;
    protected Thread clientThread;
    protected JButton btnConnect ;
    protected JLabel lblPassword ;
    protected JLabel lblUsername ;
    protected JButton btnConnect_1;
    protected JButton btnSignup ;
    protected JList list ;
    protected JLabel lblMessage;
    protected JButton btnSend ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame();
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
	public ChatFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JLabel lblPort = new JLabel("Port");
		JLabel lblAddress = new JLabel("Address");
		textField = new JTextField();
		textField.setText("127.0.0.1");
		textField.setColumns(10);
		textField_1 = new JTextField();	
		textField_1.setText("13000");
		

		 btnConnect = new JButton("Connect");
		 lblPassword = new JLabel("Password");
		 lblUsername = new JLabel("Username");
		 btnConnect_1 = new JButton("Signin");
		 btnSignup = new JButton("Signup");
		 btnSignup.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String uname = textField_2.getText();
		 		String passwd = textField_3.getText();
		 		if(!uname.isEmpty() && !passwd.isEmpty()){
		            client.send(new Message("signup", uname, passwd, "SERVER"));
		        }
		 	}
		 });
		 list = new JList();
		 list.setModel((model = new DefaultListModel()));	
		 lblMessage = new JLabel("Message");
		 btnSend = new JButton("Send");
		 btnSend.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		String msg = textField_4.getText();
		        String target = list.getSelectedValue().toString();
		        
		        if(!msg.isEmpty() && !target.isEmpty()){
		            textField_4.setText("");
		            client.send(new Message("message", username, msg, target));
		            
		        }
		 	}
		 });
		
		
		textField_1.setColumns(10);
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverAddr = textField.getText(); port = Integer.parseInt(textField_1.getText());
		        
		        if(!serverAddr.isEmpty() && !textField_1.getText().isEmpty()){
		            try{
		                client = new SocketClient(ChatFrame.this);
		                clientThread = new Thread(client);
		                clientThread.start();
		                client.send(new Message("test", "testUser", "testContent", "SERVER"));
		            }
		            catch(Exception ex){
		                textArea.append("[Application > Me] : Server not found\n");
		            }
		        }
			}
		});
		
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		
		btnConnect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = textField_2.getText();
				String passwd = textField_3.getText();
				if(!uname.isEmpty() && !passwd.isEmpty())
					
				{
					client.send(new Message("login", uname, passwd, "SERVER"));
				}
			}
		});
		
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		
		
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		username = textField_2.getText();
		password = textField_3.getText();
		
		model.addElement("All");
		list.setSelectedIndex(0);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAddress)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsername)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPort)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnConnect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnConnect_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnSignup))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMessage)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4))
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSend))))
					.addContainerGap(183, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(lblPort)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConnect)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConnect_1)
						.addComponent(btnSignup))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMessage)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSend))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
