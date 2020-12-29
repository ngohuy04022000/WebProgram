package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBLogin {
	public boolean loginCheck(String username, String password) {
		String query = "Select TaiKhoan, MatKhau from NguoiDung";
		boolean login = false;
		String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433";
		// Database name access
		String dbName = "WebThuVien";
		String connectionURL = dbURL + ";databaseName=" + dbName;
		Connection conn = null;
		try {
			Class.forName(dbDriver);
			conn = (Connection) DriverManager.getConnection(connectionURL);
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next()) {
				String DBusername = rs.getString("TaiKhoan");
				String DBpassword = rs.getString("MatKhau");
				if (DBusername.equals(username) && DBpassword.equals(password)) {
					System.out.println("Connect successfully");
					login = true;
				}
			}			
		}
		catch(Exception ex) {
			System.out.println("Connect failure");
			ex.printStackTrace();
		}
		return login;
	}
}
