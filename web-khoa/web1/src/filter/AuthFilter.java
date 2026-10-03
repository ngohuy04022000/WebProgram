package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MyUtils;

/**
 * Bắt buộc đăng nhập trước khi xem các trang truyện.
 * Trang đăng nhập/đăng ký/lỗi và tài nguyên tĩnh (asset) được truy cập tự do.
 */
@WebFilter(filterName="AuthFilter", urlPatterns = { "/*" })
public class AuthFilter implements Filter {
	private static final Set<String> PUBLIC_PATHS = new HashSet<String>(Arrays.asList(
			"", "/", "/login", "/logincheck", "/registration", "/registrationcheck", "/error", "/logout"));

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		if (PUBLIC_PATHS.contains(path) || path.startsWith("/asset/")
				|| MyUtils.getLoginedUser(req.getSession(false)) != null) {
			chain.doFilter(request, response);
			return;
		}
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
