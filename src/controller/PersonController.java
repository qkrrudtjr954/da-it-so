package controller;

import service.PersonService;
import view.Login;

public class PersonController {
	PersonService personService = new PersonService();
	
	public void Login() {
		new Login();
	}

	public void checkUser(String id, char[] pwd) {
		boolean result = personService.checkUser(id, pwd);
	}
}
