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
import dto.AbilityBbs;
import dto.ItemBbs;
import dto.Person;

public class AbilityDao implements AbilityDaoImpl{

	//DBConnection DBConnector = new MySqlConnection();
    DBConnection DBConnector = new OracleConnection();
	
	public List<AbilityBbs> allAbilityList() {
		
		String sql = "SELECT * FROM ABILITY_BBS";
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		List<AbilityBbs> AbilityList = new ArrayList<>();

		System.out.println(">>>	AbilityBbsDao .allItemList() sql : " + sql);
		

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); // query 를 실행하라 그리고 그 값을 rs에 저장해라.

			while (rs.next()) {
				AbilityBbs abilityDto = new AbilityBbs();
				
				abilityDto.setCategory_id(Integer.parseInt(rs.getString("CATEGORY_ID")));
				abilityDto.setTitle(rs.getString("TITLE"));
				abilityDto.setImgurl1(rs.getString("IMGURL1"));
				abilityDto.setImgurl2(rs.getString("IMGURL2"));
				abilityDto.setImgurl3(rs.getString("IMGURL3"));
				abilityDto.setImgurl4(rs.getString("IMGURL4"));
				abilityDto.setAbility(rs.getString("ABILITY"));
				abilityDto.setContent(rs.getString("CONTENT"));
				abilityDto.setCreated_at(rs.getString("CREATED_AT"));
				abilityDto.setUser_id(rs.getString("USER_ID"));
				
				AbilityList.add(abilityDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, conn, rs);
		}
		
		return AbilityList;
	}
	
	
	public boolean AbilityListAdd(AbilityBbs abilityDto) {
		System.out.println(abilityDto.toString());
		
		String sql = "INSERT INTO ABILITY_BBS(SEQ, CATEGORY_ID, TITLE, IMGURL1, IMGURL2, IMGURL3, IMGURL4, ABILITY, CONTENT, CREATE_AT, USER_ID)"
				+" VALUES(ABBS_SEQ.NEXTVAL,1,?,?,?,?,?,?,?,?,SYSDATE,?)";

		DBConnection DBConnector = new OracleConnection();
		Connection conn = DBConnector.makeConnection();
		PreparedStatement stmt =null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, abilityDto.getCategory_id());
			stmt.setString(2, abilityDto.getTitle());
			stmt.setString(3, abilityDto.getImgurl1());
			stmt.setString(4, abilityDto.getImgurl2());
			stmt.setString(5, abilityDto.getImgurl3());
			stmt.setString(6, abilityDto.getImgurl4());
			stmt.setString(7, abilityDto.getAbility());
			stmt.setString(8, abilityDto.getContent());
			stmt.setString(9, abilityDto.getUser_id());
			
			rs = stmt.executeQuery();
			
			return true;
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}		
		return false;
	}
	
	public boolean addAbility(AbilityBbs abilityDto, Person personDto) {
		Delegator delegator = Delegator.getInstance();
				
		String sql;
		
		if (DBConnector.getClass().getName().equals("db.MySqlConnection")) {
			sql = " insert into ability_bbs(category_id, user_id, title, imgurl1, imgurl2, imgurl3, imgurl4, ability, content, state, created_at) " 
					+ " values( "+abilityDto.getCategory_id()+", '"+delegator.getCurrent_user().getId()+"', '"+abilityDto.getTitle()+"', '"
					+ abilityDto.getImgurl1() +"', '"+abilityDto.getImgurl2()+"', '"+abilityDto.getImgurl3()+"', '"+abilityDto.getImgurl4()+"', '"+abilityDto.getAbility()+"', '"+abilityDto.getContent()+"', 1, now());";
		} else {
			sql ="INSERT INTO ABILITY_BBS(SEQ, CATEGORY_ID, TITLE, IMGURL1, IMGURL2, IMGURL3, IMGURL4, ABILITY, CONTENT, CREATE_AT, USER_ID)"
					+" VALUES(IBBS_SEQ.NEXTVAL, '"+abilityDto.getCategory_id()+"','"+abilityDto.getTitle()+"','"+abilityDto.getImgurl1()+"','"+abilityDto.getImgurl2()+"','"+abilityDto.getImgurl3()+"','"+abilityDto.getImgurl4()+"','"+abilityDto.getAbility()+"','"+abilityDto.getContent()+"',SYSDATE, '"+personDto.getId()+"')";

		}

		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		int count = -1;

		System.out.println(">>>	AbilityDao .addAbility() sql : " + sql);

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

	public List<AbilityBbs> list(AbilityBbs Adto) {
		
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		
		List<AbilityBbs> list = new ArrayList<AbilityBbs>();
		String sql = "SELECT "+ 
				" SEQ, CATEGORY_ID, USER_ID, TITLE, "+ 
				" IMGURL1, IMGURL2, IMGURL3, IMGURL4" + 
				" ABILITY, CONTENT, CREATED_AT, STATE" + 
				" FROM ABILITY_BBS";
		System.out.println("sql: " + sql);
		
		java.sql.Connection conn = DBConnector.makeConnection();
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
				String ability = rs.getString("ABILITY");
				String content = rs.getString("CONTENT");
				String created_at = rs.getString("CREATED_AT");
				int state = rs.getInt("STATE");
				
				AbilityBbs dto = new AbilityBbs();
				
				
				dto.setSeq(seq);
				dto.setCategory_id(category_id);
				dto.setUser_id(user_id);
				dto.setTitle(title);
				dto.setImgurl1(imgurl1);
				dto.setImgurl2(imgurl2);
				dto.setImgurl3(imgurl3);
				dto.setImgurl4(imgurl4);
				dto.setAbility(ability);
				dto.setContent(content);
				dto.setCreated_at(created_at);
				dto.setState(state);

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

	@Override
	public List<AbilityBbs> searchList(String searchWord) {
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		List<AbilityBbs> searchlist = new ArrayList<AbilityBbs>();
		
		String sql = " SELECT * FROM ABILITY_BBS "
				+ " WHERE TITLE LIKE %'" + searchWord +"'%"
				+ " OR CONTENT LIKE %'" + searchWord + "'%"
				+ " OR ABILITY LIKE %'" + searchWord + "'%";//제목 컨텐츠 키워드 
		//select * from item_bbs where title like %something% or content like %something% or ability like %something%;
		
		java.sql.Connection conn = DBConnector.makeConnection();
		System.out.println("conn success");
		
		try {
			stmt = conn.createStatement();
			System.out.println("stmt success");

			rs = stmt.executeQuery(sql);
			System.out.println("rs success");
			
			while(rs.next()) {

				String title = rs.getString("TITLE");
				String ability = rs.getString("ABILITY");
				String content = rs.getString("CONTENT");
				
				AbilityBbs dto = new AbilityBbs();
				
				dto.setTitle(title);
				dto.setAbility(ability);
				dto.setContent(content);
				
				searchlist.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(stmt, conn, rs);
		}
		return searchlist;
	}

	
}
