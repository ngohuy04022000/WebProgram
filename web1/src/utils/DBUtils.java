package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.sach;

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
            sach s = new sach();
            s.setmasach(masach);
            s.setlinkbia(linkbia);
            s.settensach(tensach);
            s.setchitiet(chitiet);
            list.add(s);
        }
        return list;
    }
	
	public static sach findSach(Connection conn, int idIn) throws SQLException {
        String sql = "Select * from CuonSach a where a.MaSach=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idIn);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int masach = rs.getInt("MaSach");
            String linkbia = rs.getString("LinkBia");
            String tensach = rs.getString("TenSach");
            String chitiet = rs.getString("ChiTiet");
            sach s = new sach(masach,linkbia,tensach,chitiet);
            return s;
        }
        return null;
	}
	
	public static void updateSach(Connection conn, sach s) throws SQLException {
        String sql = "Update CuonSach set LinkBia=?,Email=?,TenSach=?,ChiTiet=? where MaNguoiDung=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, s.getlinkbia());
        pstm.setString(2, s.gettensach());
        pstm.setString(3, s.getchitiet());
        pstm.setInt(4, s.getmasach());
        pstm.executeUpdate();
	}
	
	public static void deleteSach(Connection conn, int idIn) throws SQLException {
        String sql = "Delete from CuonSach where MaSach=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idIn);
       
        pstm.executeUpdate();
	}
	
	public static void insertSach(Connection conn, sach s) throws SQLException {
        String sql = "Insert into CuonSach values (?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, s.getmasach());
        pstm.setString(2, s.getlinkbia());
        pstm.setString(3, s.gettensach());
        pstm.setString(4, s.getchitiet());
        pstm.executeUpdate();
	}
}
