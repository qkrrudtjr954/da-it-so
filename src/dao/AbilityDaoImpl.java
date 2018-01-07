package dao;

import java.util.List;

import dto.AbilityBbs;
import dto.Person;

public interface AbilityDaoImpl {
	public List<AbilityBbs> allAbilityList();
	public boolean AbilityListAdd(AbilityBbs abilityDto);
	public boolean addAbility(AbilityBbs abilityDto, Person personDto);
}
