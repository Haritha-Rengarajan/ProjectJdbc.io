package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.cognizant.moviecruiser.model.MovieList;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoSqlImplTest {
	private static Scanner scan;

	public static void display(List<MovieList> movieList) {
		DecimalFormat df = new DecimalFormat("##,###.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%5s%25s%25s%20s%15s%25s%15s", "ID", "TITLE", "GROSS VALUE", "DATE OF LAUNCH", "ACTIVE",
				"GENRE", "HAS TEASER");
		for (MovieList movie_list : movieList) {
			System.out.format("\n%5s%25s%25s%20s%15s%25s%15s", movie_list.getId(), movie_list.getTitle(),
					"$" + df.format(movie_list.getGross()), sdf.format(movie_list.getDateOfLaunch()),
					movie_list.getActive() ? "Yes" : "No", movie_list.getGenre(), movie_list.getHasTeaser() ? "Yes" : "No");
		}
	}

	public static void testGetMovieListAdmin() {
		System.out.println("\nVIEW MOVIE LIST");
		List<MovieList> movieListAdmin = new MovieListDaoSqlImpl().getMovieListAdmin();
		display(movieListAdmin);
	}

	public static void testGetMovieListCustomer() {
		System.out.println("\n\nVIEW MENU LIST CUSTOMER");
		List<MovieList> movieListCustomer = new MovieListDaoSqlImpl().getMovieListCustomer();
		display(movieListCustomer);
	}

	public static void testModifyMenuItem() {
		System.out.println("\nUPDATED MOVIE LIST\n");
		MovieList movieList = new MovieList(1L, "Spider-Man", 2787960000l, true,
				new DateUtil().convertToDate("15/03/2022"), "Superhero", true);
		new MovieListDaoSqlImpl().modifyMovieList(movieList);
		testGetMovieListAdmin();
		System.out.println("\n");
	}

	public static void testGetMovieList() {
		scan = new Scanner(System.in);
		System.out.println("\nEnter the ID: ");
		long movieListId = scan.nextLong();
		MovieList movie_list = new MovieListDaoSqlImpl().getMovieList(movieListId);
		DecimalFormat df = new DecimalFormat("##,###.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%5s%25s%25s%20s%15s%15s%15s\n", "ID", "TITLE", "GROSS VALUE", "DATE OF LAUNCH", "ACTIVE",
				"GENRE", "HAS TEASER");
		System.out.format("\n%5s%25s%25s%20s%15s%15s%15s", movie_list.getId(), movie_list.getTitle(),
				"$" + df.format(movie_list.getGross()), sdf.format(movie_list.getDateOfLaunch()),
				movie_list.getActive() ? "Yes" : "No", movie_list.getGenre(), movie_list.getHasTeaser() ? "Yes" : "No");

	}

	public static void main(String[] args) {
		
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMenuItem();
		testGetMovieList();
	}
}
