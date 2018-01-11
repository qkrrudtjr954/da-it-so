package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dto.AbilityBbs;
import dto.Category;
import dto.ItemBbs;
import dto.Person;
import service.AbilityService;
import service.AbilityServiceImpl;
import service.CategoryService;
import view.AbilityDetail;
import view.AbilityMain;
import view.AbilityWrite;
import view.ImageDetail;
import view.ItemDetail;
import view.Main;

public class AbilityBbsController {
	AbilityServiceImpl abilityService = new AbilityService();
	CategoryService categoryService = new CategoryService();

	public void main() {
		new Main();
	}

	public void allAbilityList() {
		List<AbilityBbs> abilityDto = abilityService.allAbilityList();
		List<Category> categoryList = categoryService.getAllCategories(1);
		if (abilityDto.isEmpty()) {
			abilityDto = new ArrayList<>();

		}
		new AbilityMain(abilityDto, categoryList);
	}

	public void AbilityWrite() {
		List<Category> categoryList = categoryService.getAllCategories(1);
		new AbilityWrite(categoryList);
	}

	public void SelectAbilityCategories(int category_id) {
		List<AbilityBbs> abilityList = abilityService.SelectAbilityCategories(category_id);
		List<Category> categoryList = categoryService.getAllCategories(1);
		new AbilityMain(abilityList, categoryList);
	}

	public void AbilityDetail(AbilityBbs abilityDto) {
		List<Category> categoryList = categoryService.getAllCategories(1);
		Category abilityCategory = categoryService.getCategory(abilityDto.getCategory_id());
		new AbilityDetail(abilityDto, categoryList, abilityCategory);
	}

	public void searchList(String searchWord) {
		List<AbilityBbs> searchList = abilityService.searchList(searchWord);
		List<Category> categoryList = categoryService.getAllCategories(1);
		if (searchList.size() == 0) {
			JOptionPane.showMessageDialog(null, "검색 결과가 없습니다. ");
			searchList = abilityService.allAbilityList();
			new AbilityMain(searchList, categoryList);
		} else {
			new AbilityMain(searchList, categoryList);
		}
	}

	public boolean setCompleteAbilityBbs(AbilityBbs abilityDto) {
		// TODO Auto-generated method stub
		return abilityService.CompleteAbilityBbs(abilityDto);
	}
	
	public boolean setDeleteAbilityBbs(AbilityBbs abilityDto) {
		// TODO Auto-generated method stub
		return abilityService.DeleteAbilityBbs(abilityDto);
	}
	
	public void ImageView(String img) {
		new ImageDetail(img);
	}

	public void insert(AbilityBbs abilityDto) {
		// TODO Auto-generated method stub
		List<Category> categoryList = categoryService.getAllCategories(1);
		Category itemCategory = categoryService.getCategory(abilityDto.getCategory_id());
		boolean result = abilityService.addAbility(abilityDto);
		AbilityBbs returnAbility = null;
		
		if(result) {
			returnAbility = abilityService.getItemBbsByTitleAndContent(abilityDto);
			new AbilityDetail(returnAbility, categoryList, itemCategory);
		} else {
			JOptionPane.showMessageDialog(null, "게시중 문제가 발생했습니다.");
		}
		
	}
}
