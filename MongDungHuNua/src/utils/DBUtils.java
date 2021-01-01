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
}
