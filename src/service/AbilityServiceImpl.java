package service;

import java.util.List;

import dto.AbilityBbs;

public interface AbilityServiceImpl {
	public List<AbilityBbs> allAbilityList();
	public List<AbilityBbs> list(AbilityBbs Adto);
	public List<AbilityBbs> searchList(String searchWord);
}
