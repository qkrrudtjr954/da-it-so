package dao;

import java.util.List;

import dto.AbilityBbs;

public interface AbilityDaoImpl {
	public List<AbilityBbs> allAbilityList();
	public boolean AbilityListAdd(AbilityBbs abilityDto);
	public boolean addAbility(AbilityBbs abilityDto, Person personDto);
	public List<AbilityBbs> searchList(String searchWord);
	public List<AbilityBbs> getAllAbilityList();
	public boolean addAbility(AbilityBbs abilityDto);

}
