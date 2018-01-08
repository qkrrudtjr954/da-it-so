package service;

import java.util.List;

import dao.ItemBbsDao;
import dto.ItemBbs;
import dto.Person;

public class ItemBbsService implements ItemBbsServiceImpl{
	ItemBbsDao itemDao = new ItemBbsDao();

	public List<ItemBbs> allItemList() {
		return itemDao.allItemList();
	}

	public boolean addItem(ItemBbs itemDto, Person personDto) {
		return itemDao.addItem(itemDto, personDto) ? true : false;
	}

	public List<ItemBbs> getAllItemBbs(){
		return itemBbsDao.getAllItemBbs();
	}
	
	@Override
	public List<ItemBbs>list(ItemBbs Idto) {
		return itemDao.list(Idto);
	}
}
