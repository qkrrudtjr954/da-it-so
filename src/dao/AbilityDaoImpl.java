package dao;

import java.util.List;

import dto.AbilityBbs;

public interface AbilityDaoImpl {
	public List<AbilityBbs> allAbilityList();
	public List<AbilityBbs> searchList(String searchWord);
	public List<AbilityBbs> getAllAbilityList();
	public boolean addAbility(AbilityBbs abilityDto);
	public boolean DeleteAbilityBbsByAdmin(AbilityBbs ability);
	public boolean CompleteAbilityBbsByAdmin(AbilityBbs ability);
	public boolean ContinueAbilityBbsByAdmin(AbilityBbs ability);
}
