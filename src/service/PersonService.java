package service;

import dao.PersonDao;

public class PersonService {
	PersonDao personDao = new PersonDao();
	
	public boolean checkUser(String id, char[] pwd) {
		// TODO Auto-generated method stub
		return personDao.checkUser(id, pwd);
	}

}
