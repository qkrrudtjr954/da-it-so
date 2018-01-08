package dao;

import java.util.List;

import dto.AbilityBbs;
import dto.Person;

public interface AbilityDaoImpl {
	public List<AbilityBbs> list(AbilityBbs Adto);
	public List<AbilityBbs> allAbilityList();
	public boolean addAbility(AbilityBbs abilityDto, Person personDto);
}

