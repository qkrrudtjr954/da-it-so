package controller;

import java.util.ArrayList;
import java.util.List;

import dto.AbilityBbs;
import dto.Category;
import dto.Person;
import service.AbilityService;
import service.AbilityServiceImpl;
import service.CategoryService;
import view.AbilityDetail;
import view.AbilityMain;
import view.AbilityWrite;
import view.Main;

public class AbilityBbsController {
   AbilityServiceImpl abilityService = new AbilityService();
   CategoryService categoryService = new CategoryService();

   public void main() {
	   new Main();
   }

   public void allAbilityList() {
	   List<AbilityBbs> abilityDto = abilityService.allAbilityList();
	   if(abilityDto.isEmpty()) {
		   abilityDto = new ArrayList<>();
	   }
	   new AbilityMain(abilityDto);
   }

   public void AbilityWrite(Person personDto) {
	   //getAllCategories == 0 Ability
	   //getAllCategories == 1 item
	   List<Category> categoryList = categoryService.getAllCategories(0);
	   new AbilityWrite(categoryList);
   }

   public void AbilityDetail(AbilityBbs abilityDto) {
	   new AbilityDetail(abilityDto);
   }

   public List<AbilityBbs> searchList(String searchWord){
	   return abilityService.searchList(searchWord);
   }
}
