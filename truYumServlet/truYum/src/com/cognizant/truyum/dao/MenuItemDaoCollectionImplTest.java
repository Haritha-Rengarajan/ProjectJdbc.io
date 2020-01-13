package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void testGetMenuItemListAdmin() {
		System.out.println("Item List for Admin");
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("Item List for Customer");
		// 1.Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 2.Invoke menuItemDao.getMenuItemListCustomer() and obtain the menuItemList
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		// 3.Iterate through the menuItemList and display all attributes of each menu
		// item.
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		// 1. Create an instance for Menu Item with id matching with one of the menu
		// Item already added to the menuItemList
		MenuItem item = new MenuItem(5L, "Honey Cake", 52.00f, true, new DateUtil().convertToDate("02/11/2022"),
				"Dessert", true);
		// 2. Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 3. Invoke MenuItemDao.modifyMenuItem(menuItem)
		menuItemDao.modifyMenuItem(item);
		System.out.println("*** Modified Menu Item List ***");
		testGetMenuItemListAdmin();
		MenuItem modified_item = menuItemDao.getMenuItem(item.getId());
		System.out.println("Modified Item Detail\n" + modified_item);
	}

	public static void main(String[] args) {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();

	}

}
