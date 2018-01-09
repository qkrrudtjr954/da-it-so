package main;

import delegator.Delegator;

public class mainClass {
	public static void main(String[] args) {
		Delegator delegator = Delegator.getInstance();

		delegator.mainController.Main();
		
		//delegator.adminController.AdminMain();
//		delegator.mainController.Main();
	}
}
