package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public String filePath;
	private String username, password;
	String dbUrl = "jdbc:mysql://localhost:3306/userdetail";
	Connection con = null;
	Statement stmt = null;
	// public Database(String filePath){
	// this.filePath = filePath;
	// }

	public Database(String username, String password) {
		this.username = username;
		this.password = password;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, username, password);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean userExists(String username) {

		String query = "select uname from info where uname='" + username + "';";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkLogin(String username, String password) {
		if (!userExists(username)) {
			return false;
		}

		String query = "select uname from info where uname='" + username + "' and passwd='" + password + "';";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addUser(String username, String password) {
		String query = "insert into info (passwd,uname)values('" + password + "','" + username + "');";
		try {
			stmt.executeUpdate(query);
			//	System.out.println("Adding user failed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public static String getTagValue(String sTag, Element eElement) {
	// NodeList nlList =
	// eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	// Node nValue = (Node) nlList.item(0);
	// return nValue.getNodeValue();
	// }
}
