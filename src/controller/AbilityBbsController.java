package controller;

import dto.AbilityBbs;
import dto.Person;
import service.AbilityService;
import service.AbilityServiceImpl;
import view.DetailPageView;
import view.Main;

public class AbilityBbsController {
   AbilityServiceImpl abilityService = new AbilityService();
   
   public void main() {
	   new Main();
   }
   
   public void AbilityDetail(AbilityBbs dto) {
	   new DetailPageView(dto);
   }

   
}
