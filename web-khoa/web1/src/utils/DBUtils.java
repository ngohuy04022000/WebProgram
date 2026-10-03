package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.sach;
import beans.user;

public class DBUtils {
	public static List<sach> listSach(Connection conn) throws SQLException {
        String sql = "Select * from CuonSach";
        try (PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            return readSach(rs);
        }
    }
	// Lấy danh sách sách theo thể loại (truyenmoi, truyenhoanthanh, truyenuathich).
	public static List<sach> listSachByTheLoai(Connection conn, String theloai) throws SQLException {
        String sql = "Select * from CuonSach where TheLoai = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, theloai);
            try (ResultSet rs = pstm.executeQuery()) {
                return readSach(rs);
            }
        }
    }
	private static List<sach> readSach(ResultSet rs) throws SQLException {
        List<sach> list = new ArrayList<sach>();
        while (rs.next()) {
            sach s = new sach();
            s.setmasach(rs.getInt("MaSach"));
            s.setlinkbia(rs.getString("LinkBia"));
            s.settensach(rs.getString("TenSach"));
            s.setchitiet(rs.getString("ChiTiet"));
            s.settheloai(rs.getString("TheLoai"));
            list.add(s);
        }
        return list;
    }
	// Tìm người dùng theo tài khoản + mật khẩu, trả về null nếu sai.
	public static user findUser(Connection conn, String taikhoan, String matkhau) throws SQLException {
        String sql = "Select * from NguoiDung where TaiKhoan = ? and MatKhau = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setNString(1, taikhoan);
            pstm.setNString(2, matkhau);
            try (ResultSet rs = pstm.executeQuery()) {
                return rs.next() ? readUser(rs) : null;
            }
        }
    }
	public static boolean existsTaiKhoan(Connection conn, String taikhoan) throws SQLException {
        String sql = "Select 1 from NguoiDung where TaiKhoan = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setNString(1, taikhoan);
            try (ResultSet rs = pstm.executeQuery()) {
                return rs.next();
            }
        }
    }
	public static int nextMaNguoiDung(Connection conn) throws SQLException {
        String sql = "Select ISNULL(MAX(MaNguoiDung), 0) + 1 from NguoiDung";
        try (PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }
    }
	private static user readUser(ResultSet rs) throws SQLException {
        user s = new user();
        s.setManguoidung(rs.getInt("MaNguoiDung"));
        s.setHoten(rs.getNString("HoTen"));
        s.setDiachi(rs.getNString("DiaChi"));
        s.setEmail(rs.getNString("Email"));
        s.setTaikhoan(rs.getNString("TaiKhoan"));
        s.setMatkhau(rs.getNString("MatKhau"));
        s.setMaquyen(rs.getInt("MaQuyen"));
        return s;
    }
	public static void insertUser(Connection conn, user u) throws SQLException {
        String sql = "Insert into NguoiDung (MaNguoiDung, HoTen, DiaChi, Email, TaiKhoan, MatKhau, MaQuyen) values(?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, u.getManguoidung());
            pstm.setNString(2, u.getHoten());
            pstm.setNString(3, u.getDiachi());
            pstm.setNString(4, u.getEmail());
            pstm.setNString(5, u.getTaikhoan());
            pstm.setNString(6, u.getMatkhau());
            pstm.setInt(7, u.getMaquyen());
            pstm.executeUpdate();
        }
	}
}
