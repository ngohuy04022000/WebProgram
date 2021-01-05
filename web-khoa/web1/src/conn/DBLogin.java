package conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.sach;
import beans.user;
import utils.DBUtils;
import utils.MyUtils;

import javax.servlet.annotation.WebServlet;
@WebServlet("/logincheck")
public class DBLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
//    public boolean login = true;
	public boolean loginCheck(String username, String password) {
    	boolean login = false;
		String query = "Select TaiKhoan, MatKhau from NguoiDung";
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
					System.out.println("Connect login successfully");
					login = true;
				}
			}			
		}
		catch(Exception ex) {
			System.out.println("Connect login failure");
			ex.printStackTrace();
		}
		return login;
	}
//	public boolean check(String username, String password)
//	{
//		boolean login=false;
//		while (rs.next()) {
//			String DBusername = rs.getString("TaiKhoan");
//			String DBpassword = rs.getString("MatKhau");
//			if (DBusername.equals(username) && DBpassword.equals(password)) {
//				System.out.println("Connect login successfully");
//				login = true;
//				}
//			
//		return true;
//	}
	public static String name = "";
	public static boolean login = false;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username1=request.getParameter("taikhoan");
		String password1=request.getParameter("matkhau");
//		request.setAttribute(username,"user");
//		request.setAttribute(password,"pass");
//		request.getAttribute("user");
		Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<user> list = null;
        try {
            list = DBUtils.listlogin(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        for( user u:list)
        {
        	String DBusername = u.getTaikhoan();
        	String DBpassword = u.getMatkhau();
        	if (DBusername.equals(username1) && DBpassword.equals(password1)) {
				System.out.println("Connect login successfully");
				login = true;
				name = username1;
			}
        }
		if(login==true)
		{
			response.sendRedirect("sachListView");
		}
		else
		{
			response.sendRedirect("error");
		}
	}
	public static String getName() {
		return name;
	}
	public static boolean getLogin() {
		return login;
	}
	public static void setLogin(boolean dn )
	{
		login = dn;
	}
}
