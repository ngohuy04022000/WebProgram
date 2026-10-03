package utils;

import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.HttpSession;

import beans.user;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	// Tên attribute lưu người dùng đã đăng nhập trong session (JSP dùng ${loginedUser}).
	public static final String ATT_NAME_LOGINED_USER = "loginedUser";

    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
    // Lưu trạng thái đăng nhập theo từng session, không dùng biến static
    // (biến static dùng chung cho mọi người truy cập).
    public static void storeLoginedUser(HttpSession session, user loginedUser) {
        session.setAttribute(ATT_NAME_LOGINED_USER, loginedUser);
    }
    public static user getLoginedUser(HttpSession session) {
        if (session == null) {
            return null;
        }
        return (user) session.getAttribute(ATT_NAME_LOGINED_USER);
    }
}
