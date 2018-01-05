package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import db.OracleConnection;
import dto.AbilityBbs;

public class AbilityDao implements AbilityDaoImpl{

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
	
}
