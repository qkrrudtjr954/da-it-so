package main;

import db.DBConnection;
import db.MySqlConnection;
import dto.Category;
import view.ListVIew;
import view.mainView;

public class mainClass {
	public static void main(String[] args) {
		DBConnection db = new MySqlConnection();

		db.makeConnection();
		db.initConnect();


		new mainView();
	}
}
