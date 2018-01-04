package service;

import dao.PersonDao;
import dto.Person;

public class PersonService implements PersonServiceImpl{
	PersonDao personDao = new PersonDao();

	/*
	 * 2017-01-04 init by Parker.
	 */
	public Person getPerson(String id, char[] pwd) {
		// TODO Auto-generated method stub
		return personDao.getPerson(id, pwd);
	}
	
	/*
	 * 2017-01-04 init by Parker.
	 * if person exist return true
	 */
	public boolean checkPerson(String id, char[] pwd) {
		Person person = personDao.getPerson(id, pwd);
		
		return (person != null) ? true : false;
	}

}
