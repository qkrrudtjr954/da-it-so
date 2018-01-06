package controller;

import dto.AbilityBbs;
import dto.Person;
import service.AbilityService;
import service.AbilityServiceImpl;
import view.AbilityDetail;
import view.AbilityMain;
import view.AbilityWrite;
import view.Main;

public class AbilityBbsController {
   AbilityServiceImpl abilityService = new AbilityService();
   
   public void main() {
	   new Main();
   }
   
   public void allAbilityList() {
	   AbilityBbs abilityDto = new AbilityBbs();
	   abilityDto = abilityService.allAbilityList();
	   new AbilityMain(abilityDto);
   }
   
   public void abilityWrite(Person personDto) {
	   new AbilityWrite(personDto);
   }
   
   public void AbilityDetail(AbilityBbs abilityDto, Person personDto) {
	   new AbilityDetail(abilityDto, personDto);
   }

   
}
