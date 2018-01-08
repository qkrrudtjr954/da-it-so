package service;

import java.util.List;

import dao.ItemBbsDao;
import dto.ItemBbs;

public class ItemBbsService implements ItemBbsServiceImpl{

	ItemBbsDao Idao = new ItemBbsDao();
	
	@Override
	public List<ItemBbs>list(ItemBbs Idto) {
		return Idao.list(Idto);
	}

}
