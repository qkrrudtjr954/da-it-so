package dao;

import java.util.List;

import dto.ItemBbs;


public interface ItemBbsDaoImpl {
	public List<ItemBbs> getAllItemBbs();
	public List<ItemBbs> list(ItemBbs Idto);
	public List<ItemBbs> getItemBbsByUserId(String user_id);
}
