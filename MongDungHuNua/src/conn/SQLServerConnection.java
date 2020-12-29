package conn;

import java.sql.*;

public class SQLServerConnection {
	public static Connection getConnection() 
            throws ClassNotFoundException, SQLException {
		String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433";
		String dbName = "WebThuVien";
		String dbUsername = "sa";
		String dbPassword = "123456";
		String connectionURL = dbURL + ";databaseName=" + dbName;
		Connection conn = null;
		try {
			Class.forName(dbDriver);
			conn = (Connection) DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
			System.out.println("Connect successfully");
		}
		catch(Exception ex) {
			System.out.println("Connect failure");
			ex.printStackTrace();
		}
		return conn;
	}   
  
}
