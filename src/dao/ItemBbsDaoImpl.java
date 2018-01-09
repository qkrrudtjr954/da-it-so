package dao;

import java.util.List;

import dto.ItemBbs;
import dto.Person;


public interface ItemBbsDaoImpl {
	public boolean addItem(ItemBbs itemDto);
	public List<ItemBbs> allItemList();
	public List<ItemBbs> getAllItemBbs();
	public List<ItemBbs> searchList(String searchWord);
	public List<ItemBbs> getItemBbsByUserId(String user_id);
	public boolean DeleteItemBbsByAdmin(ItemBbs item);
	public boolean CompleteItemBbsByAdmin(ItemBbs item);
	public boolean ContinueItemBbsByAdmin(ItemBbs item) ;

}
