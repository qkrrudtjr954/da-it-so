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
import delegator.Delegator;
import dto.AbilityBbs;
import dto.Person;

public class AbilityDao implements AbilityDaoImpl {

	 DBConnection DBConnector = new MySqlConnection();
//	DBConnection DBConnector = new OracleConnection();

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

				abilityDto.setSeq(Integer.parseInt(rs.getString("SEQ")));
				abilityDto.setCategory_id(Integer.parseInt(rs.getString("CATEGORY_ID")));
				abilityDto.setTitle(rs.getString("TITLE"));
				abilityDto.setImgurl1(rs.getString("IMGURL1"));
				abilityDto.setImgurl2(rs.getString("IMGURL2"));
				abilityDto.setImgurl3(rs.getString("IMGURL3"));
				abilityDto.setImgurl4(rs.getString("IMGURL4"));
				abilityDto.setAbility(rs.getString("ABILITY"));
				abilityDto.setContent(rs.getString("CONTENT"));
				abilityDto.setState(Integer.parseInt(rs.getString("STATE")));
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

	public List<AbilityBbs> getAllAbilityList() {

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

	public boolean addAbility(AbilityBbs abilityDto) {
		Delegator delegator = Delegator.getInstance();
		Person personDto = delegator.getCurrent_user();

		String sql;

		if (DBConnector.getClass().getName().equals("db.MySqlConnection")) {
			sql = " insert into ability_bbs(category_id, user_id, title, imgurl1, imgurl2, imgurl3, imgurl4, ability, content, state, created_at) "
					+ " values( " + abilityDto.getCategory_id() + ", '" + delegator.getCurrent_user().getId() + "', '"
					+ abilityDto.getTitle() + "', '" + abilityDto.getImgurl1() + "', '" + abilityDto.getImgurl2()
					+ "', '" + abilityDto.getImgurl3() + "', '" + abilityDto.getImgurl4() + "', '"
					+ abilityDto.getAbility() + "', '" + abilityDto.getContent() + "', 1, now());";
		} else {
			sql ="INSERT INTO ABILITY_BBS(SEQ, CATEGORY_ID, TITLE, IMGURL1, IMGURL2, IMGURL3, IMGURL4, ABILITY, CONTENT, STATE, CREATED_AT, USER_ID)"
					+" VALUES(SEQ_ABILITY_BBS.NEXTVAL,'"+abilityDto.getCategory_id()+"','"+abilityDto.getTitle()+"','"+abilityDto.getImgurl1()+"','"+abilityDto.getImgurl2()+"','"+abilityDto.getImgurl3()+"','"+abilityDto.getImgurl4()+"','"+abilityDto.getAbility()+"','"+abilityDto.getContent()+"', 1, SYSDATE, '"+personDto.getId()+"')";

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
