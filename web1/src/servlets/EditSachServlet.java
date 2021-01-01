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

import beans.sach;
import utils.MyUtils;
import utils.DBUtils;

/**
 * Servlet implementation class EditSachServlet
 */
@WebServlet("/EditSachServlet")
public class EditSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		String masachStr = (String) request.getParameter("masach");
		int masach = 0;
		try {
			masach = Integer.parseInt(masachStr);
		} catch (Exception e) {
			
		}
		sach s = null;
		String errorString = null;
		try {
			s = DBUtils.findSach(conn, masach);
		} catch(SQLException e) {
			e.printStackTrace();
            errorString = e.getMessage();
		}
		
		if(errorString!=null && s==null) {
			response.sendRedirect(request.getServletPath() + "/sachList");
			return;
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("sach", s);
		
		RequestDispatcher dispatcher = request.getServletContext()
//              .getRequestDispatcher("/WEB-INF/views/sachList.jsp");
      		 .getRequestDispatcher("/WEB-INF/views/home.jsp");
      dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		
		String masachStr = (String) request.getParameter("masach");
		String linkbia = (String) request.getParameter("linkbia");
		String tensach = (String) request.getParameter("tensach");
        String chitiet = (String) request.getParameter("chitiet");
        
        int masach = 0;
		try {
			masach = Integer.parseInt(masachStr);
		} catch (Exception e) {
			
		}
		sach s = new sach(masach,linkbia,tensach,chitiet);
		String errorString = null;
		try {
			DBUtils.updateSach(conn, s);
		} catch(SQLException e) {
			e.printStackTrace();
            errorString = e.getMessage();
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("sach", s);
		
		if(errorString!=null) {
			RequestDispatcher dispatcher = request.getServletContext()
//	              .getRequestDispatcher("/WEB-INF/views/Editsach.jsp");
	      		 .getRequestDispatcher("/WEB-INF/views/home.jsp");
	      dispatcher.forward(request, response);
		} 
		else {
			response.sendRedirect(request.getServletPath() + "/sachList");
		}
	}

}
