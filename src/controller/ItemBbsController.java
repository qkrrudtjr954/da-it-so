package controller;

import java.util.ArrayList;
import java.util.List;

import dto.AbilityBbs;
import dto.Category;
import dto.ItemBbs;
import dto.Person;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ItemBbsService;
import service.ItemBbsServiceImpl;
import view.AbilityMain;
import view.ItemDetail;
import view.ItemMain;
import view.ItemWrite;
import view.Main;

public class ItemBbsController {
	   ItemBbsServiceImpl itemService = new ItemBbsService();
	   CategoryServiceImpl categoryService = new CategoryService();
	
	   public void main() {
		   new Main();
	   }
	   
	   public void allItemList() {
		   List<ItemBbs> itemdto = itemService.allItemList();
		   
		   if(itemdto == null) {
			   itemdto = new ArrayList<>();
		   }
		   
		   new ItemMain(itemdto);
	   }
	   
	   public void itemWrite(Person personDto) {
		   //getAllCategories == 0 Ability 
		   //getAllCategories == 1 item 
		   List<Category> categoryList = categoryService.getAllCategories(0);
		   new ItemWrite(categoryList);
	   }
	   
	   public void itemDetail(ItemBbs itemDto) {
		   new ItemDetail(itemDto);
	   }
	   
	   public void SelectItemCategories(int category_id){
		   List<ItemBbs> itemList = itemService.SelectItemCategories(category_id);
		   new ItemMain(itemList);
	   }	
	   
	   
	   public void SelectAbilityCategories(int category_id){
		   List<AbilityBbs> abilityList = itemService.SelectAbilityCategories(category_id);
		   new AbilityMain(abilityList);
	   }

}
