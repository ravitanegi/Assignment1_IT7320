package chatapp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import com.socket.Message;

public class SocketClient implements Runnable{
	public int port;
	public String serverAddr;
	public Socket socket;
	public ChatFrame ui;
	public ObjectInputStream In;
	public ObjectOutputStream Out;
//	public History hist;

	public SocketClient(ChatFrame frame) throws IOException {
		ui = frame;
		this.serverAddr = ui.serverAddr;
		this.port = ui.port;
		socket = new Socket(InetAddress.getByName(serverAddr), port);

		Out = new ObjectOutputStream(socket.getOutputStream());
		Out.flush();
		In = new ObjectInputStream(socket.getInputStream());

//		hist = ui.hist;
	}

	@Override
	public void run() {
		boolean keepRunning = true;
		while (keepRunning) {
			try {
				Message msg = (Message) In.readObject();
				System.out.println("Incoming : " + msg.toString());

				if (msg.type.equals("message")) {
					if (msg.recipient.equals(ui.username)) {
						ui.textArea.append("[" + msg.sender + " > Me] : " + msg.content + "\n");
					} else {
						ui.textArea.append("[" + msg.sender + " > " + msg.recipient + "] : " + msg.content + "\n");
					}

					if (!msg.content.equals(".bye") && !msg.sender.equals(ui.username)) {
						String msgTime = (new Date()).toString();

						//try {
							//hist.addMessage(msg, msgTime);
							//DefaultTableModel table = (DefaultTableModel) ui.historyFrame.jTable1.getModel();
							//table.addRow(new Object[] { msg.sender, msg.content, "Me", msgTime });
						//} catch (Exception ex) {
						//}
					}
				} else if (msg.type.equals("login")) {
					if (msg.content.equals("TRUE")) {
						ui.btnConnect_1.setEnabled(false);
						ui.btnSignup.setEnabled(false);
						ui.btnSend.setEnabled(true);
						//ui.jButton5.setEnabled(true);
						ui.textArea.append("[SERVER > Me] : Login Successful\n");
						ui.textField_2.setEnabled(false);
						ui.textField_3.setEnabled(false);
					} else {
						ui.textArea.append("[SERVER > Me] : Login Failed\n");
					}
				} else if (msg.type.equals("test")) {
					ui.btnConnect.setEnabled(false);
					ui.btnConnect_1.setEnabled(true);
					ui.btnSignup.setEnabled(true);
					ui.textField_2.setEnabled(true);
					ui.textField_3.setEnabled(true);
					ui.textField.setEditable(false);
					ui.textField_1.setEditable(false);
				} else if (msg.type.equals("newuser")) {
					if (!msg.content.equals(ui.username)) {
						boolean exists = false;
						for (int i = 0; i < ui.model.getSize(); i++) {
							if (ui.model.getElementAt(i).equals(msg.content)) {
								exists = true;
								break;
							}
						}
						if (!exists) {
							ui.model.addElement(msg.content);
						}
					}
				} else if (msg.type.equals("signup")) {
					if (msg.content.equals("TRUE")) {
						ui.btnConnect_1.setEnabled(false);
						ui.btnSignup.setEnabled(false);
						ui.btnSend.setEnabled(true);
						
						ui.textArea.append("[SERVER > Me] : Singup Successful\n");
					} else {
						ui.textArea.append("[SERVER > Me] : Signup Failed\n");
					}
				} else if (msg.type.equals("signout")) {
					if (msg.content.equals(ui.username)) {
						ui.textArea.append("[" + msg.sender + " > Me] : Bye\n");
						ui.btnConnect.setEnabled(true);
						ui.btnSend.setEnabled(false);
						ui.textField.setEditable(true);
						ui.textField_1.setEditable(true);

						for (int i = 1; i < ui.model.size(); i++) {
							ui.model.removeElementAt(i);
						}

						ui.clientThread.stop();
					} else {
						ui.model.removeElement(msg.content);
						ui.textArea.append("[" + msg.sender + " > All] : " + msg.content + " has signed out\n");
					}
				} else if (msg.type.equals("upload_req")) {
				} else if (msg.type.equals("upload_res")) {
				} else {
					ui.textArea.append("[SERVER > Me] : Unknown message type\n");
				}
			} catch (Exception ex) {
				keepRunning = false;
				ui.textArea.append("[Application > Me] : Connection Failure\n");
				ui.btnConnect.setEnabled(true);
				ui.textField.setEditable(true);
				ui.textField_1.setEditable(true);
				ui.btnSend.setEnabled(false);
				

				for (int i = 1; i < ui.model.size(); i++) {
					ui.model.removeElementAt(i);
				}

				ui.clientThread.stop();

				System.out.println("Exception SocketClient run()");
				ex.printStackTrace();
			}
		}
	}

	public void send(Message msg) {
		try {
			Out.writeObject(msg);
			Out.flush();
			System.out.println("Outgoing : " + msg.toString());

			if (msg.type.equals("message") && !msg.content.equals(".bye")) {
				String msgTime = (new Date()).toString();
				//try {
					//hist.addMessage(msg, msgTime);
					//DefaultTableModel table = (DefaultTableModel) ui.historyFrame.jTable1.getModel();
					//table.addRow(new Object[] { "Me", msg.content, msg.recipient, msgTime });
				//} catch (Exception ex) {
				//}
			}
		} catch (IOException ex) {
			System.out.println("Exception SocketClient send()");
		}
	}

	public void closeThread(Thread t) {
		t = null;
	}
}
