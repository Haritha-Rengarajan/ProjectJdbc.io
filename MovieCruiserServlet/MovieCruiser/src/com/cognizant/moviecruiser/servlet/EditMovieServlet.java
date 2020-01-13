package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieList;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		long gross = Long.parseLong(request.getParameter("gross"));
		boolean active = request.getParameter("active").equals("yes");
		Date dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
		String genre = request.getParameter("genre");
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		MovieList movieList = new MovieList(id, title, gross, active, dateOfLaunch, genre, hasTeaser);
		MovieListDao movieListDao = new MovieListDaoSqlImpl();
		movieListDao.modifyMovieList(movieList);
		request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);
		doGet(request, response);
	}

}
