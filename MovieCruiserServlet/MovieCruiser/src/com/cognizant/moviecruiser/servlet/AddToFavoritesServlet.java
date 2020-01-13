package com.cognizant.moviecruiser.servlet;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class AddToFavoritesServlet
 */
@WebServlet("/AddToFavorites")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavoritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavoritesDao favoriteDao = new FavoritesDaoSqlImpl();
		long movieListId = Long.parseLong(request.getParameter("movieListId"));
		long userId = 1l;

		favoriteDao.addFavorites(userId, movieListId);
		;
		MovieListDao movieListDao = new MovieListDaoSqlImpl();
		List<MovieList> movieList = movieListDao.getMovieListCustomer();
		request.setAttribute("movieList", movieList);
		request.setAttribute("addFavoriteStatus", true);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
