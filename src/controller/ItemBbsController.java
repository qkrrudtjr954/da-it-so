package controller;

import dto.ItemBbs;
import service.ItemBbsService;
import service.ItemBbsServiceImpl;
import view.ItemWrite;
import view.Main;
import view.itemDetail;

public class ItemBbsController {
	   ItemBbsServiceImpl itemService = new ItemBbsService();
	   
	   public void main() {
		   new Main();
	   }
	   
	   public void itemWrite() {
		   new ItemWrite();
	   }
	   
	   public void itemDetail(ItemBbs dto) {
		   new itemDetail(dto);
	   }
}
