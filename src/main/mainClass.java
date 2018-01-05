package main;

import java.util.Date;

import dto.Person;
import view.AbilityWrite;

public class mainClass {
	public static void main(String[] args) {
		
		char[] a = {'a','b'};
		Person personDto = new Person();
		personDto.setId("idtest");
		personDto.setPwd(a);
		personDto.setPhone("010-1111");
		personDto.setNick("nicku");

		new AbilityWrite(personDto);
	}
}
