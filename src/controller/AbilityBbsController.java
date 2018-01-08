package controller;

import java.util.List;

import dto.AbilityBbs;
import service.AbilityService;
import service.AbilityServiceImpl;

public class AbilityBbsController {
	
	AbilityServiceImpl Aserv = new AbilityService();
	
	public List<AbilityBbs> list(AbilityBbs Adto){
		return Aserv.list(Adto);
	}
   
}
