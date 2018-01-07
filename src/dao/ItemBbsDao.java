package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import db.MySqlConnection;
import dto.ItemBbs;

public class ItemBbsDao implements ItemBbsDaoImpl{
	DBConnection DBConnector = new MySqlConnection();
	
	
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
				
				item.setCategory_id(rs.getInt("category_id"));
				item.setContent(rs.getString("content"));
				item.setCreated_at(rs.getString("created_at"));
				item.setImgurl1(rs.getString("imgurl1"));
				item.setImgurl2(rs.getString("imgurl2"));
				item.setImgurl3(rs.getString("imgurl3"));
				item.setImgurl4(rs.getString("imgurl4"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
