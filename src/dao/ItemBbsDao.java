package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import db.OracleConnection;
import delegator.Delegator;
import dto.ItemBbs;
import dto.Person;

public class ItemBbsDao implements ItemBbsDaoImpl{

	//DBConnection DBConnector = new MySqlConnection();
	DBConnection DBConnector = new OracleConnection();
	
	public List<ItemBbs> allItemList() {
		
		String sql = "SELECT * FROM ITEM_BBS";
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		List<ItemBbs> itemList = new ArrayList<>();

		System.out.println(">>>	ItemBbsDao .allItemList() sql : " + sql);
		

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); // query 를 실행하라 그리고 그 값을 rs에 저장해라.

			while (rs.next()) {
				ItemBbs itemdto = new ItemBbs();
				
				itemdto.setCategory_id(Integer.parseInt(rs.getString("CATEGORY_ID")));
				itemdto.setTitle(rs.getString("TITLE"));
				itemdto.setImgurl1(rs.getString("IMGURL1"));
				itemdto.setImgurl2(rs.getString("IMGURL2"));
				itemdto.setImgurl3(rs.getString("IMGURL3"));
				itemdto.setImgurl4(rs.getString("IMGURL4"));
				itemdto.setPrice(rs.getInt("PRICE"));
				itemdto.setKeyword(rs.getString("KEYWORD"));
				itemdto.setContent(rs.getString("CONTENT"));
				itemdto.setCreated_at(rs.getString("CREATED_AT"));
				itemdto.setUser_id(rs.getString("USER_ID"));
				
				itemList.add(itemdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, conn, rs);
		}
		
		return itemList;
	}
	
	public boolean addItem(ItemBbs itemDto, Person personDto) {
		Delegator delegator = Delegator.getInstance();
		
		
		String sql;
		
		if (DBConnector.getClass().getName().equals("db.MySqlConnection")) {
			sql = " insert into item_bbs(category_id, user_id, title, imgurl1, imgurl2, imgurl3, imgurl4, keyword, content, state, created_at) " 
					+ " values( "+itemDto.getCategory_id()+", '"+delegator.getCurrent_user().getId()+"', '"+itemDto.getTitle()+"', '"
					+ itemDto.getImgurl1() +"', '"+itemDto.getImgurl2()+"', '"+itemDto.getImgurl3()+"', '"+itemDto.getImgurl4()+"', '"+itemDto.getKeyword()+"', '"+itemDto.getContent()+"', 1, now());";
		} else {
			sql ="INSERT INTO ITEM_BBS(SEQ, CATEGORY_ID, TITLE, IMGURL1, IMGURL2, IMGURL3, IMGURL4, PRICE, KEYWORD, CONTENT, STATE, CREATED_AT, USER_ID)"
					+" VALUES(IBBS_SEQ.NEXTVAL, '"+itemDto.getCategory_id()+"','"+itemDto.getTitle()+"','"+itemDto.getImgurl1()+"','"+itemDto.getImgurl2()+"','"+itemDto.getImgurl3()+"','"+itemDto.getImgurl4()+"','"+itemDto.getPrice()+"','"+itemDto.getKeyword()+"','"+itemDto.getContent()+"', 1, SYSDATE, '"+personDto.getId()+"')";

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
