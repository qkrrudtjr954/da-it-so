package service;

import java.util.List;

import dto.ItemBbs;

public interface ItemBbsServiceImpl {
	public List<ItemBbs> getAllItemBbs();
	public List<ItemBbs> allItemList();
	public List<ItemBbs> list(ItemBbs Idto);
	public List<ItemBbs> getItemBbsByUserId(String user_id);
	public boolean DeleteItemBbsByAdmin(ItemBbs item);
	public boolean CompleteItemBbsByAdmin(ItemBbs item);
	public boolean ContinueItemBbsByAdmin(ItemBbs item);
}
