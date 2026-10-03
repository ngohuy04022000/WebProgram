package conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.user;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet("/logincheck")
public class DBLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public DBLogin() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Không nhận tài khoản/mật khẩu qua URL.
		response.sendRedirect("login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("taikhoan");
		String password = request.getParameter("matkhau");
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			response.sendRedirect("error");
			return;
		}
		Connection conn = MyUtils.getStoredConnection(request);
		user u;
		try {
			u = DBUtils.findUser(conn, username, password);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		if (u == null) {
			response.sendRedirect("error");
			return;
		}
		// Tạo session mới sau khi đăng nhập để tránh session fixation.
		HttpSession old = request.getSession(false);
		if (old != null) {
			old.invalidate();
		}
		MyUtils.storeLoginedUser(request.getSession(true), u);
		response.sendRedirect("sachListView");
	}
}
