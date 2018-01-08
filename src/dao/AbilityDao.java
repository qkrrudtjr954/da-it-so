package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import db.DBClose;
import db.DBConnection;
import db.MySqlConnection;
import dto.AbilityBbs;

public class AbilityDao implements AbilityDaoImpl{

	@Override
	public List<AbilityBbs> list(AbilityBbs Adto) {
		
		DBConnection db = new MySqlConnection();
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		
		List<AbilityBbs> list = new ArrayList<AbilityBbs>();
		String sql = "SELECT "+ 
				" SEQ, CATEGORY_ID, USER_ID, TITLE, "+ 
				" IMGURL1, IMGURL2, IMGURL3, IMGURL4, MAINIMGURL" + 
				" ABILITY, CONTENT, CREATED_AT, STATE" + 
				" FROM ABILITY_BBS";
		System.out.println("sql: " + sql);
		
		java.sql.Connection conn = db.makeConnection();
		System.out.println("conn success");
		
		try {
			stmt = conn.createStatement();
			System.out.println("stmt success");

			rs = stmt.executeQuery(sql);
			System.out.println("rs success");
			
			while(rs.next()) {
				int seq = rs.getInt("SEQ");
				int category_id = rs.getInt("CATEGORY_ID");
				String user_id = rs.getString("USER_ID");
				String title = rs.getString("TITLE");
				String imgurl1 = rs.getString("IMGURL1");
				String imgurl2 = rs.getString("IMGURL2");
				String imgurl3 = rs.getString("IMGURL3");
				String imgurl4 = rs.getString("IMGURL4");
				String mainimgurl = rs.getString("MAINIMGURL");
				String ability = rs.getString("ABILITY");
				String content = rs.getString("CONTENT");
				String created_at = rs.getString("CREATED_AT");
				int state = rs.getInt("STATE");
				
				AbilityBbs dto = new AbilityBbs(category_id, user_id, title, imgurl1, imgurl2, imgurl3, imgurl4, ability, content, created_at, state);
				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(stmt, conn, rs);
		}
		return null;
	}
	
	public List<AbilityBbs> search(AbilityBbs Adto){
		
		String sql = " SELECT * FROM ABILITY_BBS "
				+ " WHERE TITLE = '" + Adto.getTitle() +"'" ;
		
		return null;
		
	}
	
}
