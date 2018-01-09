package service;

import java.util.List;

import dao.AbilityDao;
import dao.AbilityDaoImpl;
import dto.AbilityBbs;

public class AbilityService implements AbilityServiceImpl {
	AbilityDaoImpl abilityDao = new AbilityDao();

	public List<AbilityBbs> allAbilityList() {
		return abilityDao.allAbilityList();
	}

	public List<AbilityBbs> getAllAbilityList() {
		return abilityDao.getAllAbilityList();
	}
	@Override
	public List<AbilityBbs> searchList(String searchWord) {
		// TODO Auto-generated method stub
		return abilityDao.searchList(searchWord);
	}
	public boolean addAbility(AbilityBbs abilityDto) {
		return abilityDao.addAbility(abilityDto) ? true : false;
	}

	@Override
	public boolean DeleteAbilityBbsByAdmin(AbilityBbs ability) {
		// TODO Auto-generated method stub
		return abilityDao.DeleteAbilityBbsByAdmin(ability);
	}

	@Override
	public boolean CompleteAbilityBbsByAdmin(AbilityBbs ability) {
		// TODO Auto-generated method stub
		return abilityDao.CompleteAbilityBbsByAdmin(ability);
	}

	@Override
	public boolean ContinueAbilityBbsByAdmin(AbilityBbs ability) {
		// TODO Auto-generated method stub
		return abilityDao.ContinueAbilityBbsByAdmin(ability);
	}
}
