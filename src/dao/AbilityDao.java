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
import dto.Person;

public class AbilityDao implements AbilityDaoImpl {

//	 DBConnection DBConnector = new MySqlConnection();
	DBConnection DBConnector = new OracleConnection();

	public List<AbilityBbs> allAbilityList() {


		String sql = "SELECT * FROM ABILITY_BBS ORDER BY CREATED_AT";

		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<AbilityBbs> AbilityList = new ArrayList<>();

		System.out.println(">>>	AbilityBbsDao .allAbilityList() sql : " + sql);

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // query
			System.out.println("1-6 ssuc");


			while(rs.next()) {

				System.out.println("2-6 suc");
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
			rs = pstmt.executeQuery(sql); // query

			while (rs.next()) {
				AbilityBbs abilityDto = new AbilityBbs();

				abilityDto.setSeq(rs.getInt("SEQ"));
				abilityDto.setCategory_id(rs.getInt("CATEGORY_ID"));
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
			count = pstmt.executeUpdate(); // query 

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

		List<AbilityBbs> searchlist = new ArrayList<AbilityBbs>();
		Connection conn = DBConnector.makeConnection();
		ResultSet rs = null;
		PreparedStatement psmt = null;

		String sql = " SELECT * FROM ABILITY_BBS "
				+ " WHERE TITLE LIKE '%" + searchWord +"%'"
				+ " OR CONTENT LIKE '%" + searchWord + "%'"
				+ " OR ABILITY LIKE '%" + searchWord + "%'";

		System.out.println(">>> AbilityDao.searchList()sql: " + sql);
		//select * from item_bbs where title like %something% or content like %something% or ability like %something%;


		System.out.println("conn success");

		try {
			psmt = conn.prepareStatement(sql);
			System.out.println("psmt success");

			rs = psmt.executeQuery(sql);
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
				int state = rs.getInt("STATE");
				String created_at = rs.getString("CREATED_AT");

				AbilityBbs dto = new AbilityBbs(seq, category_id, user_id, title, imgurl1, imgurl2, imgurl3, imgurl4, ability, content, state, created_at);
				System.out.println("dto: " + dto);
				searchlist.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		searchlist.stream().forEach(System.out::println);

		return searchlist;
	}

	@Override
	public boolean DeleteAbilityBbsByAdmin(AbilityBbs ability) {
		String sql = " update item_bbs set state = 3 where seq="+ability.getSeq();

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
	public boolean CompleteAbilityBbsByAdmin(AbilityBbs ability) {
		// TODO Auto-generated method stub
		String sql = " update item_bbs set state = 1 where seq="+ability.getSeq();

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
	public boolean ContinueAbilityBbsByAdmin(AbilityBbs ability) {
		// TODO Auto-generated method stub
		String sql = " update item_bbs set state = 0 where seq="+ability.getSeq();

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
