package controller;

import java.util.List;

import dto.ItemBbs;
import service.ItemBbsService;
import service.ItemBbsServiceImpl;

public class ItemBbsController {

	ItemBbsServiceImpl Iserv = new ItemBbsService();
	
	public List<ItemBbs> list(ItemBbs Idto){
		return Iserv.list(Idto);
	}
}
