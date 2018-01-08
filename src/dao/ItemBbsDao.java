package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import db.MySqlConnection;
import db.OracleConnection;
import dto.ItemBbs;

public class ItemBbsDao implements ItemBbsDaoImpl{
//	DBConnection DBConnector = new MySqlConnection();
	DBConnection DBConnector = new OracleConnection();
	
	
	public List<ItemBbs> getAllItemBbs() {
		
		String sql = " SELECT * FROM ITEM_BBS ";
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement ptmt = null;
		
		ResultSet rs = null;
		
		List<ItemBbs> list = new ArrayList<>();
		
		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				ItemBbs item = new ItemBbs();
				
				item.setSeq(rs.getInt("seq"));
				item.setCategory_id(rs.getInt("category_id"));
				item.setContent(rs.getString("content"));
				item.setCreated_at(rs.getString("created_at"));
				item.setImgurl1(rs.getString("imgurl1"));
				item.setImgurl2(rs.getString("imgurl2"));
				item.setImgurl3(rs.getString("imgurl3"));
				item.setImgurl4(rs.getString("imgurl4"));
				item.setKeyword(rs.getString("keyword"));
				item.setPrice(rs.getInt("price"));
				item.setState(rs.getInt("state"));
				item.setTitle(rs.getString("title"));
				item.setUser_id(rs.getString("user_id"));
				
				list.add(item);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
