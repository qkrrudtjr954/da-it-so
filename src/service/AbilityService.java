package service;

import java.util.List;

import dao.AbilityDao;
import dto.AbilityBbs;
import dto.Person;

public class AbilityService implements AbilityServiceImpl {
	AbilityDao abilityDao = new AbilityDao();
	
	public List<AbilityBbs> allAbilityList() {
		return abilityDao.allAbilityList();
	}
	
	public boolean addAbility(AbilityBbs abilityDto, Person personDto) {
		return abilityDao.addAbility(abilityDto, personDto) ? true : false;
	}
}
