package random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import random.DBConnectionFactory;

public class NumberDAO {

	public void insertDice(ArrayList<Dice> dicelist) {
		DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
		Connection conn = myFactory.getConnection();
		PreparedStatement pstmt = null;
		String query = "";
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			query = "insert into random_number(dice1, dice2, dice3, timestamp) values(?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dicelist.get(0).getNum());
			pstmt.setInt(2, dicelist.get(1).getNum());
			pstmt.setInt(3, dicelist.get(2).getNum());
			pstmt.setString(4, sdf.format(dt));
			int result = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
