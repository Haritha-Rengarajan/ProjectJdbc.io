package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	private static Scanner scan;

	public static void testAddCartItem() throws CartEmptyException {
		scan = new Scanner(System.in);
		System.out.println("Enter the USER ID value to add: \n");
		long userId = scan.nextLong();
		System.out.println("Enter the MENU ITEM ID value to add: \n");
		long menuItemId = scan.nextLong();
		new CartDaoSqlImpl().addCartItem(userId, menuItemId);
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		scan = new Scanner(System.in);
		System.out.println("Enter the USER ID: ");
		long userId = scan.nextLong();
		Cart cart = new CartDaoSqlImpl().getAllCartItems(userId);
		List<MenuItem> menu_item = cart.getMenuItemList();
		DecimalFormat df = new DecimalFormat("##,###.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%5s%25s%15s%20s%15s%15s%15s", "ID", "NAME", "PRICE", "DATE OF LAUNCH", "ACTIVE",
				"CATEGORY", "FREE DELIVERY");

		for (MenuItem menu_Item : menu_item) {
			String freedelivery = menu_Item.getFreeDelivery() ? "Yes" : "No";
			String active = menu_Item.getActive() ? "Yes" : "No";
			System.out.format("\n%5s%25s%15s%20s%15s%15s%15s", menu_Item.getId(), menu_Item.getName(),
					"Rs." + df.format(menu_Item.getPrice()), sdf.format(menu_Item.getDateOfLaunch()), active,
					menu_Item.getCategory(), freedelivery);
		}
		System.out.println("\n\n   Total: " + cart.getTotal());
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		scan = new Scanner(System.in);
		System.out.println("Enter the USER ID value to remove: \n");
		long userId = scan.nextLong();
		System.out.println("Enter the MENU ITEM ID value to remove: \n");
		long menuItemId = scan.nextLong();
		new CartDaoSqlImpl().removeCartItem(userId, menuItemId);
		;
	}

	public static void main(String[] args) throws CartEmptyException {

		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();

	}
}
