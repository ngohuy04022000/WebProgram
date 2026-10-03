package conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.user;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet("/registrationcheck")
public class DBregistration extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public DBregistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("registration");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Đọc tham số dạng UTF-8 để giữ đúng tiếng Việt.
		request.setCharacterEncoding("UTF-8");
		String hoten = trim(request.getParameter("name"));
		String diachi = trim(request.getParameter("address"));
		String email = trim(request.getParameter("email"));
		String taikhoan = trim(request.getParameter("taikhoan"));
		String matkhau = request.getParameter("matkhau");
		String matkhau1 = request.getParameter("matkhau1");
		int quyen = 1;

		if (hoten.isEmpty() || diachi.isEmpty() || email.isEmpty() || taikhoan.isEmpty()
				|| matkhau == null || matkhau.isEmpty()) {
			response.sendRedirect("registration?error=empty");
			return;
		}
		if (matkhau1 != null && !matkhau.equals(matkhau1)) {
			response.sendRedirect("registration?error=password");
			return;
		}

		Connection conn = MyUtils.getStoredConnection(request);
		try {
			if (DBUtils.existsTaiKhoan(conn, taikhoan)) {
				response.sendRedirect("registration?error=exists");
				return;
			}
			int manguoidung = DBUtils.nextMaNguoiDung(conn);
			user u = new user(manguoidung, hoten, diachi, email, taikhoan, matkhau, quyen);
			DBUtils.insertUser(conn, u);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("registration?error=db");
			return;
		}
		response.sendRedirect("login");
	}

	private static String trim(String s) {
		return s == null ? "" : s.trim();
	}
}
