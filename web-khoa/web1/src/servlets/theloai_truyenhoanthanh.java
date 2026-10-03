package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="theloai_truyenhoanthanh",urlPatterns = { "/theloai_truyenhoanthanh" })
public class theloai_truyenhoanthanh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public theloai_truyenhoanthanh() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TheLoaiHelper.show(request, response, "truyenhoanthanh");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
