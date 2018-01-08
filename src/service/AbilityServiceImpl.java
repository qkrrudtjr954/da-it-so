package service;

import java.util.List;

import dto.AbilityBbs;

public interface AbilityServiceImpl {
	public List<AbilityBbs> allAbilityList();
	public boolean addAbility(AbilityBbs abilityDto);
}
