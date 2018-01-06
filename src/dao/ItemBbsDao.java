package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import db.OracleConnection;
import dto.ItemBbs;
import dto.Person;

public class ItemBbsDao implements ItemBbsDaoImpl{

	//DBConnection DBConnector = new MySqlConnection();
	  DBConnection DBConnector = new OracleConnection();
	
	public ItemBbs allItemList() {
		
		String sql = "SELECT * FROM ITEM_BBS";
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		ItemBbs itemdto = null;

		System.out.println(">>>	ItemBbsDao .allItemList() sql : " + sql);

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); // query 를 실행하라 그리고 그 값을 rs에 저장해라.

			if (rs.next()) {
				itemdto = new ItemBbs();
				itemdto.setCategory_id(Integer.parseInt(rs.getString("CATEGORY_ID")));
				itemdto.setTitle(rs.getString("TITLE"));
				itemdto.setImgurl1(rs.getString("IMGURL1"));
				itemdto.setImgurl2(rs.getString("IMGURL2"));
				itemdto.setImgurl3(rs.getString("IMGURL3"));
				itemdto.setImgurl4(rs.getString("IMGURL4"));
				itemdto.setPrice(Integer.parseInt(rs.getString("PRICE")));
				itemdto.setKeyword(rs.getString("KEYWORD"));
				itemdto.setContent(rs.getString("CONTENT"));
				itemdto.setCreated_at(rs.getString("CREATED_AT"));
				itemdto.setUser_id(rs.getString("USER_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, conn, rs);
		}
		return itemdto;
	}
	
	public boolean addItem(ItemBbs itemDto, Person personDto) {
		
		String sql;
		
		if (DBConnector.getClass().getName().equals("db.MySqlConnection")) {
			sql ="";
		} else {
			sql ="INSERT INTO ITEM_BBS(SEQ, CATEGORY_ID, TITLE, IMGURL1, IMGURL2, IMGURL3, IMGURL4, PRICE, KEYWORD, CONTENT, CREATED_AT, USER_ID)"
					+" VALUES(IBBS_SEQ.NEXTVAL, '"+itemDto.getCategory_id()+"','"+itemDto.getTitle()+"','"+itemDto.getImgurl1()+"','"+itemDto.getImgurl2()+"','"+itemDto.getImgurl3()+"','"+itemDto.getImgurl4()+"','"+itemDto.getPrice()+"','"+itemDto.getKeyword()+"','"+itemDto.getContent()+"',SYSDATE, '"+personDto.getId()+"')";

		}

		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		int count = -1;

		System.out.println(">>>	ItemBbsDao .addItem() sql : " + sql);

		try {
			pstmt = conn.prepareStatement(sql);
			count = pstmt.executeUpdate(); // query 를 실행하라 그리고 그 값을 rs에 저장해라.

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, conn, rs);
		}
		
		return count > 0 ? true : false;
	}
	
}
