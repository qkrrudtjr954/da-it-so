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

	@Override
	public List<ItemBbs>list(ItemBbs Idto) {
		return itemDao.list(Idto);
	}

	@Override
	public List<ItemBbs> searchList(String searchWord) {
		return itemDao.searchList(searchWord);
	}
}
