package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;



public class Dbconnection {
	public static void main(String[] args)
	{
	}
	
	public static int dbInfoFetch(String Query) {

		String dbUrl= "jdbc:mysql://localhost:3306/database";
		String user ="root";
		String password ="";
	    int result=0;

		try {
			
			Connection con=DriverManager.getConnection(dbUrl, user, password);
	
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			while(rs.next()) {
				System.out.println(rs.getString("Username")+ " " +rs.getString("Password"));
				result++;
			}
			}
				
		 catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void writeToDb(String Name,String Username,String Dob,String Gender,String Password)
	{
	try {
		String dbUrl= "jdbc:mysql://localhost:3306/database";
		String user ="root";
		String password ="";

		Connection con=DriverManager.getConnection(dbUrl, user, password);

		Statement sta=con.createStatement();
		sta.executeUpdate("INSERT INTO USERINFO VALUES('" +Name + "', '" + Dob + "','" +Gender + "', '" + Username + "','" +Password + "')");
		//System.out.println("INSERT INTO USERINFO VALUES(' " +Name + " ', ' " + Username + " ', ' " + Dob + " ',' " +Gender + " ',' " +Password + " ')");
		System.out.println("Inserted into database");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}