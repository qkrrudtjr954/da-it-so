package controller;

import java.util.List;

import dto.Category;
import dto.ItemBbs;
import dto.Person;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ItemBbsService;
import service.ItemBbsServiceImpl;
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
		   new ItemMain(itemdto);
	   }
	   
	   public void itemWrite(Person personDto) {
		   List<Category> categoryList = categoryService.getAllCategories();
		   new ItemWrite(categoryList);
	   }
	   
	   public void itemDetail(ItemBbs itemDto, Person personDto) {
		   new ItemDetail(itemDto, personDto);
	   }
}
