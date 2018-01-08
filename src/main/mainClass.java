package main;

import db.DBConnection;
import db.MySqlConnection;
import db.OracleConnection;
import delegator.Delegator;
import dto.Category;
import dto.Person;
import view.ListVIew;
import view.mainView;

public class mainClass {
	public static void main(String[] args) {
		Delegator delegator = Delegator.getInstance();
		
		Person admin = new Person();
		admin.setCreated_at("0000-00-00 00:00:00.0");
		admin.setId("admin");
		admin.setNick("admin");
		admin.setPhone("00000000000");
		
		char[] pwd = { 'a', 'd', 'm', 'i', 'n' };
		admin.setPwd(pwd);
		admin.setSeq(1);
		delegator.setCurrent_user(admin);
		delegator.adminController.AdminMain();
//		delegator.mainController.Main();
	}
}
