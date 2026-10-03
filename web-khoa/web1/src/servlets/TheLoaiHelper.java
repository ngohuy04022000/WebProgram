package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtils;
import utils.MyUtils;

/**
 * Dùng chung cho các trang thể loại: lấy sách theo thể loại rồi hiển thị sachListView.jsp.
 */
class TheLoaiHelper {
	private TheLoaiHelper() {
	}

	static void show(HttpServletRequest request, HttpServletResponse response, String theloai)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		try {
			request.setAttribute("sachList", DBUtils.listSachByTheLoai(conn, theloai));
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/sachListView.jsp")
				.forward(request, response);
	}
}
