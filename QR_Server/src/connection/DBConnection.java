package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "huy123";
	private static final String CONN_STRING = "jdbc:mysql://localhost/login";
	public static Connection getConnection(){ 	
		Connection cons = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cons = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Connected!");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return cons;
	}
}

