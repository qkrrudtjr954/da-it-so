package service;

import dto.Person;

public interface PersonServiceImpl {
	public Person getPerson(String id, char[] pwd);
	public Person getPersonById(String id);
	public boolean checkPerson(String id, char[] pwd);
	public Person insert(Person person);
	public boolean checkId(String id);

}
