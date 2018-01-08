package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.Statement;

import db.DBClose;
import db.DBConnection;
import db.MySqlConnection;
import db.OracleConnection;
import dto.ItemBbs;

public class ItemBbsDao implements ItemBbsDaoImpl{

	@Override
	public List<ItemBbs> list(ItemBbs Idto) {
		DBConnection db = new MySqlConnection();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		
		List<ItemBbs> list = new ArrayList<ItemBbs>();
		//db에 연결해서 쿼리문 날리는 부분
		String sql = " SELECT "
				+ " SEQ, CATEGORY_ID, USER_ID, TITLE,"
				+ " IMGURL1, IMGURL2, IMGURL3, IMGURL4, MAINIMGURL"
				+ " CONTENT, PRICE, KEYWORD, CREATED_AT, STATE"
				+ " FROM ITEM_BBS";
	
		System.out.println("sql: " + sql);
		
		java.sql.Connection conn = db.makeConnection();
		System.out.println("conn success");
		
		try {
			stmt = conn.createStatement();
			System.out.println("stmt success");
			
			rs = stmt.executeQuery(sql);
			System.out.println("rs success");
			
			while (rs.next()) {
				int seq = rs.getInt("SEQ");
				int category_id = rs.getInt("CATEGORY_ID");
				String user_id = rs.getString("USER_ID");
				String title = rs.getString("TITLE");
				String imgurl1 = rs.getString("IMGURL1");
				String imgurl2 = rs.getString("IMGURL2");
				String imgurl3 = rs.getString("IMGURL3");
				String imgurl4 = rs.getString("IMGURL4");
				String mainimgurl = rs.getString("MAINIMGURL");
				String content = rs.getString("CONTENT");
				int price = rs.getInt("PRICE");
				String keyword = rs.getString("KEYWORD");
				String created_at = rs.getString("CREATED_AT");
				int state = rs.getInt("STATE");

				ItemBbs dto = new ItemBbs(seq, category_id, user_id, title, imgurl1, imgurl2, imgurl3, imgurl4, mainimgurl, price, keyword, content, created_at, state);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(stmt, conn, rs);
		}
		return list;
	}

	
}
