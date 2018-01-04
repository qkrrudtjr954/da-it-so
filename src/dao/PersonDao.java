package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import db.MySqlConnection;
import dto.Person;

public class PersonDao implements PersonDaoImpl {

	DBConnection DBConnector = new MySqlConnection();
	// DBConnection DBConnector = new OracleConnection();

	/* 
	 * 2018-01-04 init by Parker.
	 * select person object from data base using id, pwd
	 */
	public Person getPerson(String id, char[] pwd) {
		
		String pwds = new String(pwd);

		String sql = " select * from person where id='" + id + "' and pwd='" + pwds
				+ "'";

		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		Person person = null;

		System.out.println(">>>	PersonDao sql : " + sql);

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); // query 를 실행하라 그리고 그 값을 rs에 저장해라.

			if (rs.next()) {
				person = new Person();
				person.setId(rs.getString("id"));
				person.setCreated_at(rs.getString("created_at"));
				person.setNick(rs.getString("nick"));
				person.setPhone(rs.getString("phone"));
				person.setSeq(rs.getInt("seq"));
				person.setPwd(pwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, conn, rs);
		}
		return person;
	}

}
