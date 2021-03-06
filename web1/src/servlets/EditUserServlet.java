package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MyUtils;
import utils.UserUtils;
import beans.user;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		String manguoidungStr = (String) request.getParameter("manguoidung");
		int manguoidung = 0;
		try {
			manguoidung = Integer.parseInt(manguoidungStr);
		} catch (Exception e) {
			
		}
		user u = null;
		String errorString = null;
		try {
			u = UserUtils.findUser(conn, manguoidung);
		} catch(SQLException e) {
			e.printStackTrace();
            errorString = e.getMessage();
		}
		
		if(errorString!=null && u==null) {
			response.sendRedirect(request.getServletPath() + "/userList");
			return;
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("user", u);
		
		RequestDispatcher dispatcher = request.getServletContext()
//              .getRequestDispatcher("/WEB-INF/views/userList.jsp");
      		 .getRequestDispatcher("/WEB-INF/views/home.jsp");
      dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		
		String manguoidungStr = (String) request.getParameter("manguoidung");
		String hoten = (String) request.getParameter("hoten");
		String diachi = (String) request.getParameter("diachi");
        String email = (String) request.getParameter("email");
        String taikhoan = (String) request.getParameter("taikhoan");
        String matkhau = (String) request.getParameter("matkhau");
        String maquyenStr = (String) request.getParameter("maquyen");
        
        int manguoidung = 0;
		try {
			manguoidung = Integer.parseInt(manguoidungStr);
		} catch (Exception e) {
			
		}
		user u = new user(manguoidung,hoten,diachi,email,taikhoan,matkhau,Integer.parseInt(maquyenStr));
		String errorString = null;
		try {
			UserUtils.updateUser(conn, u);
		} catch(SQLException e) {
			e.printStackTrace();
            errorString = e.getMessage();
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("user", u);
		
		if(errorString!=null) {
			RequestDispatcher dispatcher = request.getServletContext()
//	              .getRequestDispatcher("/WEB-INF/views/Edituser.jsp");
	      		 .getRequestDispatcher("/WEB-INF/views/home.jsp");
	      dispatcher.forward(request, response);
		} 
		else {
			response.sendRedirect(request.getServletPath() + "/userList");
		}
	}

}
