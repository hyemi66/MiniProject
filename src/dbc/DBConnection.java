package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() throws Exception {
		
		Connection con;
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String id = "c##java", pwd = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(url, id, pwd);
		return con;
		
	}
}
