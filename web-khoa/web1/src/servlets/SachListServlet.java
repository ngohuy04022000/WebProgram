package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.sach;
import utils.DBUtils;
import utils.MyUtils;
/**
 * Trang chủ: danh sách tất cả sách.
 * Người dùng đăng nhập được lấy từ session (${loginedUser} trong JSP).
 */
@WebServlet(name="sachListView",urlPatterns = { "/sachListView" })
public class SachListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SachListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
        List<sach> list;
        try {
            list = DBUtils.listSach(conn);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        request.setAttribute("sachList", list);
        RequestDispatcher dispatcher = request.getServletContext()
        		 .getRequestDispatcher("/WEB-INF/views/home.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
