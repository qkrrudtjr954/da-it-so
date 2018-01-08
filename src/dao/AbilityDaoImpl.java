package dao;

import java.util.List;

import dto.AbilityBbs;

public interface AbilityDaoImpl {
	public List<AbilityBbs> allAbilityList();

	public List<AbilityBbs> getAllAbilityList();
	public boolean addAbility(AbilityBbs abilityDto, Person personDto);

}
