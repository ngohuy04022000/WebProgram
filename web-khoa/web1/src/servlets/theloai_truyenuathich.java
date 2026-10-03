package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="theloai_truyenuathich",urlPatterns = { "/theloai_truyenuathich" })
public class theloai_truyenuathich extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public theloai_truyenuathich() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TheLoaiHelper.show(request, response, "truyenuathich");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
