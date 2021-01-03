package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.sach;
import utils.DBUtils;
import utils.MyUtils;

/**
 * Servlet implementation class DeleteSachServlet
 */
@WebServlet("/DeleteSachServlet")
public class DeleteSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSachServlet() {
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

		String errorString = null;
		try {
			DBUtils.deleteSach(conn, masach);
		} catch(SQLException e) {
			e.printStackTrace();
            errorString = e.getMessage();
		}
		response.sendRedirect(request.getServletPath() + "/sachList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
