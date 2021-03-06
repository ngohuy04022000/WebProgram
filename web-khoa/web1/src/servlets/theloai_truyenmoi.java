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
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(name="theloai_truyenmoi",urlPatterns = { "/theloai_truyenmoi" })
public class theloai_truyenmoi extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public theloai_truyenmoi() {
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
	        List<sach> list_truyensach = new ArrayList<sach>();
	        try {
	            list = DBUtils.listSach(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        for(sach s:list)
	        {
	        	String DBtheloai =s.gettheloai();
	        	if (DBtheloai.equals("truyenmoi"))
	        	{
					System.out.println("Connect theloai successfully");
					list_truyensach.add(s);
				}
	        }
	        String UserName= DBLogin.getName();
	        List<user> List_user1=new ArrayList<user>();
	        List<user> List_user=null;
	        try {
	        	List_user = DBUtils.listlogin(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
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
	        	request.setAttribute("sachList", list_truyensach);
	        	request.setAttribute("user", List_user1);
	        }
	        // Forward sang /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
//	        		 .getRequestDispatcher("/WEB-INF/views/login.jsp");
	        		 .getRequestDispatcher("/WEB-INF/views/sachListView.jsp");
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
