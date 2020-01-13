package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoCollectionImplTest {

	public static void testGetMovieListAdmin() {
		System.out.println("Movie List for Admin");
		List<MovieList> movieListid = new MovieListDaoCollectionImpl().getMovieListAdmin();
		for (MovieList movieList : movieListid) {
			System.out.println(movieList);
		}
	}

	public static void testGetMovieListCustomer() {
		System.out.println("Movie List for Customer");
		MovieListDao movieListDao = new MovieListDaoCollectionImpl();
		List<MovieList> movieidList = movieListDao.getMovieListCustomer();
		for (MovieList movieList : movieidList) {
			System.out.println(movieList);
		}
	}

	public static void testModifyMovieList() {
		MovieList movie = new MovieList(5L, "BatMan", 2750760348l, true, new DateUtil().convertToDate("02/11/2022"),
				"Superhero", true);
		MovieListDao movieListDao = new MovieListDaoCollectionImpl();
		movieListDao.modifyMovieList(movie);
		System.out.println("*** Modified Movie List ***");
		testGetMovieListAdmin();
		MovieList modified_item = movieListDao.getMovieList(movie.getId());
		System.out.println("Modified Movie List Detail\n" + modified_item);
	}

	public static void main(String[] args) {

		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovieList();

	}

}
