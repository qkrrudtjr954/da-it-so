package main;

import delegator.Delegator;
import dto.Person;

public class mainClass {
	public static void main(String[] args) {
		
		Delegator delegator = Delegator.getInstance();
		
		Person admin = new Person();
		admin.setCreated_at("2017-1-1");
		admin.setId("admin");
		admin.setNick("admin");
		admin.setPhone("0000000");
		char[] pwd = {'a', 'd', 'm', 'i', 'n'};
		admin.setPwd(pwd);
		admin.setSeq(1);
		
		delegator.setCurrent_user(admin);
		delegator.adminController.AdminMain();
	}
}
