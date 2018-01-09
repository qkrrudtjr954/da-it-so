package dao;

import java.util.List;

import dto.ItemBbs;
import dto.Person;


public interface ItemBbsDaoImpl {
	public boolean addItem(ItemBbs itemDto, Person personDto);
	public List<ItemBbs> allItemList();
	public List<ItemBbs> getAllItemBbs();
	public List<ItemBbs> list(ItemBbs Idto);
	public List<ItemBbs> getItemBbsByUserId(String user_id);
	public boolean DeleteItemBbsByAdmin(ItemBbs item);
	public boolean CompleteItemBbsByAdmin(ItemBbs item);
	public boolean ContinueItemBbsByAdmin(ItemBbs item) ;
}
