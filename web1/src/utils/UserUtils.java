package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.user;

public class UserUtils {
	public static List<user> listUser(Connection conn) throws SQLException {
        String sql = "Select * from NguoiDung";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<user> list = new ArrayList<user>();
        while (rs.next()) {
            int manguoidung = rs.getInt("MaNguoiDung");
            String hoten = rs.getString("HoTen");
            String diachi = rs.getString("DiaChi");
            String email = rs.getString("Email");
            String taikhoan = rs.getString("TaiKhoan");
            String matkhau = rs.getString("MatKhau");
            int maquyen = rs.getInt("MaQuyen");
            user u = new user();
            u.setManguoidung(manguoidung);
            u.setHoten(hoten);
            u.setDiachi(diachi);
            u.setEmail(email);
            u.setTaikhoan(taikhoan);
            u.setMatkhau(matkhau);
            u.setMaquyen(maquyen);
            list.add(u);
        }
        return list;
	}
	
	public static user findUser(Connection conn, int idIn) throws SQLException {
        String sql = "Select * from NguoiDung a where a.MaNguoiDung=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idIn);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int manguoidung = rs.getInt("MaNguoiDung");
            String hoten = rs.getString("HoTen");
            String diachi = rs.getString("DiaChi");
            String email = rs.getString("Email");
            String taikhoan = rs.getString("TaiKhoan");
            String matkhau = rs.getString("MatKhau");
            int maquyen = rs.getInt("MaQuyen");
            user u = new user(manguoidung,hoten,diachi,email,taikhoan,matkhau,maquyen);
            return u;
        }
        return null;
	}
	
	public static void updateUser(Connection conn, user u) throws SQLException {
        String sql = "Update Nguoidung set HoTen=?,DiaChi=?,Email=?,TaiKhoan=?,MatKhau=?,MaQuyen=? where MaNguoiDung=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, u.getHoten());
        pstm.setString(2, u.getDiachi());
        pstm.setString(3, u.getEmail());
        pstm.setString(4, u.getTaikhoan());
        pstm.setString(5, u.getMatkhau());
        pstm.setInt(6, u.getMaquyen());
        pstm.setInt(7, u.getManguoidung());
        pstm.executeUpdate();
	}
	
	public static void deleteUser(Connection conn, int idIn) throws SQLException {
        String sql = "Delete from NguoiDung where MaNguoiDung=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idIn);
       
        pstm.executeUpdate();
	}
	
	public static void insertUser(Connection conn, user u) throws SQLException {
        String sql = "Insert into Nguoidung values(?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, u.getManguoidung());
        pstm.setString(2, u.getHoten());
        pstm.setString(3, u.getDiachi());
        pstm.setString(4, u.getEmail());
        pstm.setString(5, u.getTaikhoan());
        pstm.setString(6, u.getMatkhau());
        pstm.setInt(7, u.getMaquyen());
        pstm.executeUpdate();
	}
}
