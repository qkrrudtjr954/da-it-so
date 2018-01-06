package controller;

import dto.ItemBbs;
import dto.Person;
import service.ItemBbsService;
import service.ItemBbsServiceImpl;
import view.Main;
import view.ItemDetail;
import view.ItemMain;
import view.ItemWrite;

public class ItemBbsController {
	   ItemBbsServiceImpl itemService = new ItemBbsService();
	   
	   public void main() {
		   new Main();
	   }
	   
	   public void allItemList() {
		   ItemBbs itemdto = new ItemBbs();
		   itemdto = itemService.allItemList();
		   new ItemMain(itemdto);
	   }
	   
	   public void itemWrite(Person personDto) {
		   new ItemWrite(personDto);
	   }
	   
	   public void itemDetail(ItemBbs itemDto, Person personDto) {
		   new ItemDetail(itemDto, personDto);
	   }
}
