package service;

import java.util.List;

import dao.ItemBbsDao;
import dao.ItemBbsDaoImpl;
import dto.ItemBbs;
import dto.Person;

public class ItemBbsService implements ItemBbsServiceImpl{
	ItemBbsDaoImpl itemDao = new ItemBbsDao();

	public List<ItemBbs> allItemList() {
		return itemDao.allItemList();
	}

	public boolean addItem(ItemBbs itemDto) {
		return itemDao.addItem(itemDto) ? true : false;
	}

	public List<ItemBbs> getAllItemBbs(){
		return itemDao.getAllItemBbs();
	}
	
	@Override
	public List<ItemBbs>list(ItemBbs Idto) {
		return itemDao.list(Idto);
	}

	@Override
	public List<ItemBbs> getItemBbsByUserId(String user_id) {
		// TODO Auto-generated method stub
		return itemDao.getItemBbsByUserId(user_id);
	}
	
	public boolean DeleteItemBbsByAdmin(ItemBbs item) {
		return itemDao.DeleteItemBbsByAdmin(item);
	}
	
	public boolean CompleteItemBbsByAdmin(ItemBbs item) {
		return itemDao.CompleteItemBbsByAdmin(item);
	}
	public boolean ContinueItemBbsByAdmin(ItemBbs item) {
		return itemDao.ContinueItemBbsByAdmin(item);
	}

}
