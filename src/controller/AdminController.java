package controller;

import java.util.List;

import admin.AdminAbilityDetail;
import admin.AdminAbilityList;
import admin.AdminItemDetail;
import admin.AdminItemList;
import admin.AdminMain;
import admin.AdminUserList;
import dto.AbilityBbs;
import dto.ItemBbs;
import dto.Person;
import service.AbilityService;
import service.AbilityServiceImpl;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ChatService;
import service.ChatServiceImpl;
import service.ItemBbsService;
import service.ItemBbsServiceImpl;
import service.PersonService;
import service.PersonServiceImpl;
import service.RoomService;
import service.RoomServiceImpl;

public class AdminController {
	AbilityServiceImpl abilityService = new AbilityService();
	CategoryServiceImpl categoryService = new CategoryService();
	ChatServiceImpl chatService = new ChatService();
	ItemBbsServiceImpl itemBbsService = new ItemBbsService();
	PersonServiceImpl personService = new PersonService();
	RoomServiceImpl roomService = new RoomService();
	
	public void AdminMain() {
		new AdminMain();
	}
	
	public void AdminItemDetail(ItemBbs itemBbs) {
		Person person = personService.getPersonById(itemBbs.getUser_id());
		new AdminItemDetail(itemBbs, person);
	}
	
	public void ItemList() {
		List<ItemBbs> itemList = itemBbsService.getAllItemBbs();
		new AdminItemList(itemList);
	}
	
	public void AbilityList() {
		List<AbilityBbs> abilityList = abilityService.getAllAbilityList();
		new AdminAbilityList(abilityList);
	}
	
	public void AdminAbilityDetail(AbilityBbs abilityBbs) {
		Person person = personService.getPersonById(abilityBbs.getUser_id());
		new AdminAbilityDetail(abilityBbs, person);
	}
	
	public void UserList() {
		List<Person> userList = personService.getAllPerson();
		new AdminUserList(userList);
	}
	
	public void AdminUserDetail(Person person) {
		List<ItemBbs> itemList = itemBbsService.getItemBbsByUserId(person.getId());
//		List<AbilityBbs> abilityList = abilityService.getAbilityBbsByUserId(person.getId());
	}
}
