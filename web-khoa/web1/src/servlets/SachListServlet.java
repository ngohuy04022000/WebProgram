package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.sach;
import beans.user;
import conn.DBLogin;
import conn.DBConnection;
import utils.DBUtils;
import utils.MyUtils;
/**
 * Servlet implementation class SinhVienListServlet
 */
@WebServlet(name="sachListView",urlPatterns = { "/sachListView" })
public class SachListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<sach> list = null;
        List<user> List_user=null;
        List<user> List_user1=new ArrayList<user>();
        try {
            list = DBUtils.listSach(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        try {
        	List_user = DBUtils.listlogin(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        String UserName= DBLogin.getName();
        for( user u:List_user)
        {
        	String DBusername = u.getTaikhoan();
        	if (DBusername.equals(UserName)) {
				System.out.println("get user successfully");
				List_user1.add(u);
			}
        }
        if(DBLogin.getLogin()==true)
        {
        	request.setAttribute("sachList", list);
        	request.setAttribute("user", List_user1);
        }
        // Forward sang /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
//        		 .getRequestDispatcher("/WEB-INF/views/login.jsp");
        		 .getRequestDispatcher("/WEB-INF/views/home.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
