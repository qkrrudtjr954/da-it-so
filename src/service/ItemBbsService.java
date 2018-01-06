package service;

import dao.ItemBbsDao;
import dto.ItemBbs;

public class ItemBbsService implements ItemBbsServiceImpl{
	ItemBbsDao itemDao = new ItemBbsDao();
		
	public ItemBbs allItemList() {
		return itemDao.allItemList();
	}

}
