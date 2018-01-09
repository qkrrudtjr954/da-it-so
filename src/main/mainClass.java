package main;

import db.DBConnection;
import db.MySqlConnection;
import db.OracleConnection;
import delegator.Delegator;
import dto.Category;
import dto.Person;

public class mainClass {
	public static void main(String[] args) {

		DBConnection DBConnector = new OracleConnection();

		DBConnector.makeConnection();
		DBConnector.initConnect();

		Delegator delegator = Delegator.getInstance();
		delegator.mainController.Main();

	}
}
