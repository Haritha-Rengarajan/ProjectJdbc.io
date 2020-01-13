package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		// 1. Instantiate CartDaoCollectionImpl and assign it to CartDao reference
		// variable
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke cartDao.addCartItem() method
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(1, 5L);

		cartDao.addCartItem(2, 1L);
		cartDao.addCartItem(2, 3L);

		System.out.println("User Added Cart List for CheckOut");
		Cart cart = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem);
		}

	}

	public static void testRemoveCartItem() throws CartEmptyException {
		// 1. Instantiate CartDaoCollectionImpl and assign it CartDao reference variable
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke cartDao.removeCartItem() method
		System.out.println("Item List for Customer after Remove");
		try {
			cartDao.removeCartItem(1, 2l);
			// cartDao.removeCartItem(1, 5L);
			cartDao.removeCartItem(1, 3l);

			Cart cart = cartDao.getAllCartItems(1);

			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		Cart cart=new Cart();
		System.out.println("Total Price : "+cart.getTotal());
	}

	public static void main(String[] args) throws CartEmptyException {

		testAddCartItem();
		testRemoveCartItem();
		testGetAllCartItems();
	}

}
