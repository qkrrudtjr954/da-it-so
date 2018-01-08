package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import db.MySqlConnection;
import db.OracleConnection;
import delegator.Delegator;
import dto.ItemBbs;
import dto.Person;

public class ItemBbsDao implements ItemBbsDaoImpl{

//	DBConnection DBConnector = new OracleConnection();
	DBConnection DBConnector = new MySqlConnection();

	@Override
	public List<ItemBbs> list(ItemBbs Idto) {

		java.sql.Statement stmt = null;
		ResultSet rs = null;

		List<ItemBbs> list = new ArrayList<ItemBbs>();

		String sql = " SELECT "
				+ " SEQ, CATEGORY_ID, USER_ID, TITLE,"
				+ " IMGURL1, IMGURL2, IMGURL3, IMGURL4, MAINIMGURL"
				+ " CONTENT, PRICE, KEYWORD, CREATED_AT, STATE"
				+ " FROM ITEM_BBS";

		System.out.println("sql: " + sql);

		java.sql.Connection conn = DBConnector.makeConnection();
		System.out.println("conn success");

		try {
			stmt = conn.createStatement();
			System.out.println("stmt success");

			rs = stmt.executeQuery(sql);
			System.out.println("rs success");

			while (rs.next()) {
				ItemBbs dto = new ItemBbs();

				int seq = rs.getInt("SEQ");
				int category_id = rs.getInt("CATEGORY_ID");
				String user_id = rs.getString("USER_ID");
				String title = rs.getString("TITLE");
				String imgurl1 = rs.getString("IMGURL1");
				String imgurl2 = rs.getString("IMGURL2");
				String imgurl3 = rs.getString("IMGURL3");
				String imgurl4 = rs.getString("IMGURL4");
				String content = rs.getString("CONTENT");
				int price = rs.getInt("PRICE");
				String keyword = rs.getString("KEYWORD");
				String created_at = rs.getString("CREATED_AT");
				int state = rs.getInt("STATE");

				dto.setCategory_id(category_id);
				dto.setContent(content);
				dto.setCreated_at(created_at);
				dto.setImgurl1(imgurl1);
				dto.setImgurl2(imgurl2);
				dto.setImgurl3(imgurl3);
				dto.setImgurl4(imgurl4);
				dto.setKeyword(keyword);
				dto.setPrice(price);
				dto.setSeq(seq);
				dto.setUser_id(user_id);
				dto.setState(state);
				dto.setTitle(title);

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
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

	@Override
	public List<ItemBbs> getItemBbsByUserId(String user_id) {
		String sql = " SELECT * FROM ITEM_BBS WHERE USER_ID='"+user_id+"'";

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

	@Override
	public boolean DeleteItemBbsByAdmin(ItemBbs item) {
		// TODO Auto-generated method stub
		// state가 3이면 관리자에 의한 삭제. 
		String sql = " update item_bbs set state = 3 where seq="+item.getSeq();
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement ptmt = null;
		
		int count = -1;
		
		try {
			
			ptmt = conn.prepareStatement(sql);
			count = ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (count > 0) ? true : false;
	}

	@Override
	public boolean CompleteItemBbsByAdmin(ItemBbs item) {
		// TODO Auto-generated method stub
		// state가 3이면 관리자에 의한 삭제. 
		String sql = " update item_bbs set state = 1 where seq="+item.getSeq();
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement ptmt = null;
		
		int count = -1;
		
		try {
			
			ptmt = conn.prepareStatement(sql);
			count = ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (count > 0) ? true : false;
	}

	@Override
	public boolean ContinueItemBbsByAdmin(ItemBbs item) {
		// TODO Auto-generated method stub
		// state가 3이면 관리자에 의한 삭제. 
		String sql = " update item_bbs set state = 0 where seq="+item.getSeq();
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement ptmt = null;
		
		int count = -1;
		
		try {
			
			ptmt = conn.prepareStatement(sql);
			count = ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (count > 0) ? true : false;
	}
}
