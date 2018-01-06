package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import db.OracleConnection;
import dto.Person;

public class PersonDao implements PersonDaoImpl {

	//DBConnection DBConnector = new MySqlConnection();
	  DBConnection DBConnector = new OracleConnection();

	/* 
	 * 2018-01-04 init by Parker.
	 * select person object from data base using id, pwd
	 */
	public Person getPerson(String id, char[] pwd) {
		
		String pwds = new String(pwd);

		String sql = " select * from person where id='" + id + "' and PASSWORD='" + pwds
				+ "'";
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		Person person = null;

		System.out.println(">>>	PersonDao .getPerson() sql : " + sql);

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); // query 를 실행하라 그리고 그 값을 rs에 저장해라.

			if (rs.next()) {
				person = new Person();
				person.setId(rs.getString("id"));
				person.setCreated_at(rs.getString("create_at"));
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

	public boolean insert(Person person) {
		// TODO Auto-generated method stub
		String pwds = new String(person.getPwd());

		String sql;
		
		if (DBConnector.getClass().getName().equals("db.MySqlConnection")) {
			sql = " insert into person(id, pwd, phone, nick, create_at) "
					+ " values('"+person.getId()+"', '"+pwds+"', '"+person.getPhone()+"', '"+person.getNick()+"', now()) ";
		} else {
			sql = "INSERT INTO PERSON(SEQ, ID, PWD, PHONE, NICK, CREATE_AT)"
					+"VALUES (SEQ.NEXTVAL,'"+person.getId()+"','"+pwds+"','"+person.getPhone()+"','"+person.getNick()+"',SYSDATE);";
		}
		

		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		int count = -1;

		System.out.println(">>>	PersonDao .insert() sql : " + sql);

		try {
			pstmt = conn.prepareStatement(sql);
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, conn, rs);
		}
		return count > 0 ? true : false;
	}
	
	public boolean checkId(String id) {
		String sql = " select * from person where id='" + id + "'";
		
		
		boolean result = true;
		
		Connection conn = DBConnector.makeConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		Person person = null;

		System.out.println(">>>	PersonDao .checkId() sql : " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); // query 를 실행하라 그리고 그 값을 rs에 저장해라.
			
			if(rs.next()) {
				result = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, conn, rs);
		}
		return result;
	}

}
