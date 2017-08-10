package server;

public class ServerMain {
	protected String username, password;
	public static SocketServer server;
	public Thread serverThread;
	protected int port = 13000;

	public ServerMain() {
		username = "root";
		password = "";
	}

	public void RetryStart(int port) {
		if (server != null) {
			server.stop();
		}
		server = new SocketServer();
	}

	public static void main(String args[]) {
		server = new SocketServer();
	}
}
