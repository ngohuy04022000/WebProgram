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
        String sql = "Select id, name,  address from student";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<sach> list = new ArrayList<sach>();
        while (rs.next()) {
            int masach = rs.getInt("masach");
            String linkbia = rs.getString("linkbia");
            String tensach = rs.getString("tensach");
            String chitiet = rs.getString("chitiet");
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
