package com.cognizant.truyum.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CartDao cartDao = new CartDaoSqlImpl();
		long menuItemId = Long.parseLong(request.getParameter("menuItemId"));
		long userId = 1l;

		cartDao.addCartItem(userId, menuItemId);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		request.setAttribute("menuItemList", menuItemList);
		request.setAttribute("addCartStatus", true);
		/* HttpSession addCartStatus = request.getSession(true); */
		request.getRequestDispatcher("menu-item-list-customer.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
