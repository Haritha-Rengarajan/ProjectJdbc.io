package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	private static Scanner scan;

	public static void display(List<MenuItem> menuItemList) {
		DecimalFormat df = new DecimalFormat("##,###.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%5s%25s%15s%20s%15s%15s%15s", "ID", "NAME", "PRICE", "DATE OF LAUNCH", "ACTIVE",
				"CATEGORY", "FREE DELIVERY");
		for (MenuItem menu_item : menuItemList) {
			System.out.format("\n%5s%25s%15s%20s%15s%15s%15s", menu_item.getId(), menu_item.getName(),
					"Rs." + df.format(menu_item.getPrice()), sdf.format(menu_item.getDateOfLaunch()),
					menu_item.getActive() ? "Yes" : "No", menu_item.getCategory(), menu_item.getFreeDelivery() ? "Yes" : "No");
		}
	}

	public static void testGetMenuItemListAdmin() {
		System.out.println("\nVIEW MENU ITEM LIST");
		List<MenuItem> menuItemListAdmin = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		display(menuItemListAdmin);
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("\n\nVIEW MENU LIST CUSTOMER");
		List<MenuItem> menuItemListCustomer = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		display(menuItemListCustomer);
	}

	public static void testModifyMenuItem() {
		System.out.println("\nUPDATED MENU LIST\n");
		MenuItem menuItem = new MenuItem(1L, "AB", 1256.23f, true, new DateUtil().convertToDate("15/03/2017"),
				"Dessert", true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);
		testGetMenuItemListAdmin();
		System.out.println("\n");
	}

	public static void testGetMenuItem() {
		scan = new Scanner(System.in);
		System.out.println("\nEnter the ID: ");
		long menuItemId = scan.nextLong();
		MenuItem menu_item = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);
		DecimalFormat df = new DecimalFormat("##,###.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%5s%25s%15s%20s%15s%15s%15s", "ID", "NAME", "PRICE", "DATE OF LAUNCH", "ACTIVE",
				"CATEGORY", "FREE DELIVERY");
		System.out.format("\n%5s%25s%15s%20s%15s%15s%15s", menu_item.getId(), menu_item.getName(),
				"Rs." + df.format(menu_item.getPrice()), sdf.format(menu_item.getDateOfLaunch()), menu_item.getActive() ? "Yes" : "No",
				menu_item.getCategory(), menu_item.getFreeDelivery() ? "Yes" : "No");

	}

	public static void main(String[] args) {
		ConnectionHandler.getConnection();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}

}