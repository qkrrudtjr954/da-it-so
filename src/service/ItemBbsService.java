package service;

import dao.ItemBbsDao;
import dto.ItemBbs;
import dto.Person;

public class ItemBbsService implements ItemBbsServiceImpl{
	ItemBbsDao itemDao = new ItemBbsDao();
		
	public ItemBbs allItemList() {
		return itemDao.allItemList();
	}
	
	public boolean addItem(ItemBbs itemDto, Person personDto) {
		return itemDao.addItem(itemDto, personDto) ? true : false;
	}
}
