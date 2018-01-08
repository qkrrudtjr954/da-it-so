package service;

import java.util.List;

import dao.AbilityDao;
import dto.AbilityBbs;

public class AbilityService implements AbilityServiceImpl {

	AbilityDao Adao = new AbilityDao();
	
	@Override
	public List<AbilityBbs> list(AbilityBbs Adto) {
		// TODO Auto-generated method stub
		return Adao.list(Adto);
	}

}
