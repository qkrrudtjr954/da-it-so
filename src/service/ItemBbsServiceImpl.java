package service;

import java.util.List;

import dto.ItemBbs;

public interface ItemBbsServiceImpl {
	public List<ItemBbs> allItemList();
	public List<ItemBbs> list(ItemBbs Idto);
}
