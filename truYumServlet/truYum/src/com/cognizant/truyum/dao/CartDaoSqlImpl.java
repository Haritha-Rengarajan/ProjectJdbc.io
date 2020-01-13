package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_MENU_ITEM_TO_CART = "insert into cart(ct_us_id, ct_me_id) values(?,?)";
	public static final String GET_ALL_CART_ITEMS = "SELECT menu_item.me_id, menu_item.me_name, menu_item.me_active,menu_item.me_category, menu_item.me_date_of_launch, menu_item.me_price, menu_item.me_free_delivery FROM cart\r\n"
			+ "INNER JOIN menu_item on menu_item.me_id = cart.ct_me_id\r\n"
			+ "INNER JOIN user on user.us_id = cart.ct_us_id\r\n" + "WHERE user.us_id=?";
	public static final String REMOVE_MENU_ITEM_TO_CART = "delete from cart where ct_us_id=? and ct_me_id=? limit 1";
	public static final String GET_TOTAL = "SELECT menu_item.me_id, menu_item.me_name, menu_item.me_active,menu_item.me_category, menu_item.me_date_of_launch, menu_item.me_price, menu_item.me_free_delivery, sum(menu_item.me_price) as me_total FROM cart\r\n"
			+ "INNER JOIN menu_item on menu_item.me_id = cart.ct_me_id\r\n"
			+ "INNER JOIN user on user.us_id = cart.ct_us_id\r\n" + "WHERE user.us_id=?";

	@Override
	public void addCartItem(long userId, long menuItemId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(ADD_MENU_ITEM_TO_CART);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, menuItemId);

			int noOfRows = preparedstatement.executeUpdate();
			System.out.println("Number of Rows Affected -> " + noOfRows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {

		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		PreparedStatement preparedstatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MenuItem menuItem = null;
		Cart cart = new Cart();
		try {
			preparedstatement = connection.prepareStatement(GET_ALL_CART_ITEMS);
			preparedstatement.setLong(1, userId);
			resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getInt("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menuItem);
			}
			if (menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			cart.setMenuItemList(menuItemList);
			preparedstatementTotal = connection.prepareStatement(GET_TOTAL);
			preparedstatementTotal.setLong(1, userId);
			resultSetTotal = preparedstatementTotal.executeQuery();
			double total = 0.0;
			while (resultSetTotal.next()) {
				total = resultSetTotal.getDouble("me_total");
			}

			cart.setTotal(total);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSetTotal != null) {
					resultSetTotal.close();
				}
				if (preparedstatementTotal != null) {
					preparedstatementTotal.close();
				}
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(REMOVE_MENU_ITEM_TO_CART);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, menuItemId);

			int noOfRows = preparedstatement.executeUpdate();
			System.out.println("Number of Rows Affected -> " + noOfRows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}
		}
	}
}
