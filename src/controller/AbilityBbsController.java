package controller;

import dto.AbilityBbs;
import dto.Person;
import service.AbilityService;
import service.AbilityServiceImpl;
import view.AbilityDetail;
import view.Main;

public class AbilityBbsController {
   AbilityServiceImpl abilityService = new AbilityService();
   
   public void main() {
	   new Main();
   }
   
   public void abilityDetail(AbilityBbs dto) {
	   new AbilityDetail(dto);
   }

   
}
