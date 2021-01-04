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
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<sach> list = new ArrayList<sach>();
        while (rs.next()) {
            int masach = rs.getInt("MaSach");
            String linkbia = rs.getString("LinkBia");
            String tensach = rs.getString("TenSach");
            String chitiet = rs.getString("ChiTiet");
            String theloai = rs.getString("TheLoai");
            sach s = new sach();
            s.setmasach(masach);
            s.setlinkbia(linkbia);
            s.settensach(tensach);
            s.setchitiet(chitiet);
            s.settheloai(theloai);
            list.add(s);
        }
        return list;
    }
	public static List<user> listlogin(Connection conn) throws SQLException {
        String sql = "Select * from NguoiDung";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<user> list = new ArrayList<user>();
        while (rs.next()) {
            int manguoidung = rs.getInt("MaNguoiDung");
            String hoten = rs.getNString("HoTen");
            String diachi = rs.getNString("DiaChi");
            String email = rs.getNString("Email");
            String taikhoan = rs.getNString("TaiKhoan");
            String matkhau = rs.getNString("MatKhau");
            int quyen = rs.getInt("MaQuyen");
            user s = new user();
            s.setManguoidung(manguoidung);
            s.setHoten(hoten);
            s.setDiachi(diachi);
            s.setEmail(email);
            s.setTaikhoan(taikhoan);
            s.setMatkhau(matkhau);
            s.setMaquyen(quyen);
            list.add(s);
        }
        return list;
    }
	public static void insertUser(Connection conn, user u) throws SQLException {
        String sql = "Insert into NguoiDung values(?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
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
