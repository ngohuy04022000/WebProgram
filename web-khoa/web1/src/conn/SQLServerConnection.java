package conn;

import java.sql.*;
public class SQLServerConnection {
	public static Connection initializeDatabase()
	        throws SQLException, ClassNotFoundException
	    {
	        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	        // Có thể đổi cấu hình qua biến môi trường, mặc định giữ như cũ.
	        String dbURL = env("DB_URL", "jdbc:sqlserver://localhost:1433");
	        // Database name to access
	        String dbName = env("DB_NAME", "WebThuVien");
	        String dbUsername = env("DB_USER", "sa");
	        String dbPassword = env("DB_PASSWORD", "123456");
	        String connectionURL = dbURL + ";databaseName=" + dbName;
	        Class.forName(dbDriver);
	        // Ném lỗi ra ngoài thay vì trả về null để tránh NullPointerException khó hiểu.
	        return DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
	    }
	private static String env(String name, String defaultValue) {
		String value = System.getenv(name);
		return (value == null || value.isEmpty()) ? defaultValue : value;
	}
}
