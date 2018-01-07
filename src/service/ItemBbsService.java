package service;

import java.util.List;

import dao.ItemBbsDao;
import dao.ItemBbsDaoImpl;
import dto.ItemBbs;

public class ItemBbsService implements ItemBbsServiceImpl{
	
	ItemBbsDaoImpl itemBbsDao = new ItemBbsDao();
	
	public List<ItemBbs> getAllItemBbs(){
		return itemBbsDao.getAllItemBbs();
	}
}
