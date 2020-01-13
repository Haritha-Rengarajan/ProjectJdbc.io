package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class ShowEditMovieServlet
 */
@WebServlet("/ShowEditMovie")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MovieListDao movieListDao = new MovieListDaoSqlImpl();
		long movieListId = Long.parseLong(request.getParameter("movieListId"));
		MovieList movieList = movieListDao.getMovieList(movieListId);
		request.setAttribute("movieList", movieList);
		request.getRequestDispatcher("edit-movie.jsp").forward(request, response);
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
