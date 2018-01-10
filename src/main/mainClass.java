package main;

import db.DBConnection;
import db.MySqlConnection;
import db.OracleConnection;
import delegator.Delegator;

public class mainClass {
	public static void main(String[] args) {
		
//		DBConnection dbtest = new OracleConnection();
		DBConnection dbtest = new MySqlConnection();
		dbtest.initConnect();
		dbtest.makeConnection();
		
		Delegator delegator = Delegator.getInstance();
		delegator.mainController.Main();
	}
}
