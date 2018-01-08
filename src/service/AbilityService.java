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
	
	public List<AbilityBbs> getAllAbilityList() {
		return abilityDao.getAllAbilityList();
	}

    public boolean addAbility(AbilityBbs abilityDto) {
        return abilityDao.addAbility(abilityDto) ? true : false;
    }

}
