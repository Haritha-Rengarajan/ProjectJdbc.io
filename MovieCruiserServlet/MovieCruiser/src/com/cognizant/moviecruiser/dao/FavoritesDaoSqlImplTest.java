package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieList;

public class FavoritesDaoSqlImplTest {
	private static Scanner scan;

	public static void testAddFavorite() throws FavoritesEmptyException {
		scan = new Scanner(System.in);
		System.out.println("Enter the USER ID value to add: \n");
		long userId = scan.nextLong();
		System.out.println("Enter the MOVIE ID value to add: \n");
		long movieListId = scan.nextLong();
		new FavoritesDaoSqlImpl().addFavorites(userId, movieListId);
	}

	public static void testGetAllFavorites() throws FavoritesEmptyException {
		scan = new Scanner(System.in);
		System.out.println("Enter the USER ID: ");
		long userId = scan.nextLong();
		Favorites fav = new FavoritesDaoSqlImpl().getAllMovieList(userId);
		List<MovieList> movie_list = fav.getMovieList();
		DecimalFormat df = new DecimalFormat("##,###.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%5s%25s%25s%20s%15s%25s%15s", "ID", "TITLE", "GROSS VALUE", "DATE OF LAUNCH", "ACTIVE",
				"GENRE", "HAS TEASER");

		for (MovieList movie_List : movie_list) {
			System.out.format("\n%5s%25s%25s%20s%15s%25s%15s", movie_List.getId(), movie_List.getTitle(),
					"$" + df.format(movie_List.getGross()), sdf.format(movie_List.getDateOfLaunch()),
					movie_List.getActive() ? "Yes" : "No", movie_List.getGenre(),
					movie_List.getHasTeaser() ? "Yes" : "No");
		}
		System.out.println("\n\n   No Of Favorites: " + fav.getTotal());
	}

	public static void testRemoveFavorites() throws FavoritesEmptyException {
		scan = new Scanner(System.in);
		System.out.println("Enter the USER ID value to remove: \n");
		long userId = scan.nextLong();
		System.out.println("Enter the MOVIE ID value to remove: \n");
		long movieListId = scan.nextLong();
		new FavoritesDaoSqlImpl().removeFavorites(userId, movieListId);
		testGetAllFavorites();
	}

	public static void main(String[] args) throws FavoritesEmptyException {

		testAddFavorite();

		testGetAllFavorites();

		testRemoveFavorites();

	}
}
