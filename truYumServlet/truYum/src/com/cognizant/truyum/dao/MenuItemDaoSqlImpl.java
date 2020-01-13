package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public static final String VIEW_MENU_ITEM_LIST_ADMIN = "select * from menu_item";
	public static final String VIEW_MENU_ITEM_LIST_CUSTOMER = "select * from menu_item where  me_date_of_launch > CURDATE() AND me_active = 'Yes'";
	public static final String EDIT_MENU_ITEM = "update menu_item set me_name=?, me_price=?, me_active=?, me_date_of_launch=?, me_category=?, me_free_delivery=? where me_id=?";
	public static final String GET_MENU_ITEM = "select * from menu_item where me_id = ?";

	public List<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			preparedstatement = connection.prepareStatement(VIEW_MENU_ITEM_LIST_ADMIN);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MenuItem menu_item = new MenuItem();
				menu_item.setId(resultset.getInt("me_id"));
				menu_item.setName(resultset.getString("me_name"));
				menu_item.setPrice(resultset.getFloat("me_price"));
				menu_item.setActive(resultset.getString("me_active").equals("Yes"));
				menu_item.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menu_item.setCategory(resultset.getString("me_category"));
				menu_item.setFreeDelivery(resultset.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menu_item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
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
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemListCustomer = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			preparedstatement = connection.prepareStatement(VIEW_MENU_ITEM_LIST_CUSTOMER);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MenuItem menu_item = new MenuItem();
				menu_item.setId(resultset.getInt("me_id"));
				menu_item.setName(resultset.getString("me_name"));
				menu_item.setPrice(resultset.getFloat("me_price"));
				menu_item.setActive(resultset.getString("me_active").equals("Yes"));
				menu_item.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menu_item.setCategory(resultset.getString("me_category"));
				menu_item.setFreeDelivery(resultset.getString("me_free_delivery").equals("Yes"));
				menuItemListCustomer.add(menu_item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
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
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(EDIT_MENU_ITEM);
			preparedstatement.setString(1, menuItem.getName());
			preparedstatement.setFloat(2, menuItem.getPrice());
			preparedstatement.setString(3, menuItem.getActive() ? "Yes" : "No");
			new DateUtil();
			preparedstatement.setDate(4, DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			preparedstatement.setString(5, menuItem.getCategory());
			preparedstatement.setString(6, menuItem.getFreeDelivery() ? "Yes" : "No");
			preparedstatement.setLong(7, menuItem.getId());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
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

	}

	@Override
	public MenuItem getMenuItem(Long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		MenuItem menu_item = null;

		try {

			preparedstatement = connection.prepareStatement(GET_MENU_ITEM);
			preparedstatement.setLong(1, menuItemId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				menu_item = new MenuItem();
				menu_item.setId(resultset.getInt("me_id"));
				menu_item.setName(resultset.getString("me_name"));
				menu_item.setPrice(resultset.getFloat("me_price"));
				menu_item.setActive(resultset.getString("me_active").equals("Yes"));
				menu_item.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menu_item.setCategory(resultset.getString("me_category"));
				menu_item.setFreeDelivery(resultset.getString("me_free_delivery").equals("Yes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
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
		return menu_item;

	}

}
