package controller;

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
}
