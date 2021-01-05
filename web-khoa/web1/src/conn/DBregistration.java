package conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/registrationcheck")
public class DBregistration extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBregistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		String hoten = new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String diachi = new String( request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
        String email = new String( request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
        String taikhoan = (String) request.getParameter("taikhoan");
        String matkhau = (String) request.getParameter("matkhau");
		int quyen =1;
		int manguoidung = 1;
		 List<user> list = null;
	        try {
	            list = DBUtils.listlogin(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            String errorString = e.getMessage();
	        }
	        for( user u:list)
	        {
	        	int DBmanguoidung = u.getManguoidung();
	        	if(DBmanguoidung == manguoidung)
	        	{
	        		manguoidung = manguoidung+1;
	        	}
	        	else
	        	{
	        		break;
	        	}
	        }
		user u = new user(manguoidung,hoten,diachi,email,taikhoan,matkhau,quyen);
		String errorString = null;
		try {
			DBUtils.insertUser(conn, u);
		} catch(SQLException e) {
			e.printStackTrace();
            errorString = e.getMessage();
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("user", u);
		
		if(errorString!=null) {
//			RequestDispatcher dispatcher = request.getServletContext()
////	              .getRequestDispatcher("/WEB-INF/views/Edituser.jsp");
//	      		 .getRequestDispatcher("/WEB-INF/views/registration.jsp");
//	      dispatcher.forward(request, response);
			response.sendRedirect("registration");
		}
		else {
//			response.sendRedirect(request.getServletPath() + "/userList");
			response.sendRedirect("login");
		}
	}
}
