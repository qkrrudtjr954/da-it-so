package dao;

import db.DBConnection;
import db.MySqlConnection;

public class PersonDao implements PersonDaoImpl{

	DBConnection DBConnector = new MySqlConnection();
//	DBConnection DBConnector = new OracleConnection();

	public boolean checkUser(String id, char[] pwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
