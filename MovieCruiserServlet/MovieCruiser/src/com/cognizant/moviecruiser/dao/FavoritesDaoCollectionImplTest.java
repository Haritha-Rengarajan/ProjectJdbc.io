package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

import com.cognizant.moviecruiser.model.MovieList;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoritesMovie() throws FavoritesEmptyException {

		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();

		favoritesDao.addFavorites(1, 2L);
		favoritesDao.addFavorites(1, 5L);

		favoritesDao.addFavorites(2, 1L);
		favoritesDao.addFavorites(2, 3L);

		System.out.println("User Added Favorites List for CheckOut");
		Favorites favorites = favoritesDao.getAllMovieList(1);
		for (MovieList movieList : favorites.getMovieList()) {
			System.out.println(movieList);
		}
		System.out.println("No. Of Fav: " + favorites.getMovieList().size());
	}

	public static void testRemoveFavoritesList() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("Movies List for Customer after Remove");
		try {
			favoritesDao.removeFavorites(1, 2L);
			// favoritesDao.removeFavorites(1, 5L);
			favoritesDao.removeFavorites(1, 3L);
			// 3. Invoke favoritesDao.getAllFavoritesItems() with userId as 1 & 2
			Favorites favorites = favoritesDao.getAllMovieList(1);

			for (MovieList movieList : favorites.getMovieList()) {
				System.out.println(movieList);
			}
			System.out.println("No. Of Fav: " + favorites.getMovieList().size());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllMovieList() throws FavoritesEmptyException {
		Favorites favorite = new Favorites();
		System.out.println("Total  : " + favorite.getTotal());
	}

	public static void main(String[] args) throws FavoritesEmptyException {

		testAddFavoritesMovie();
		testRemoveFavoritesList();
		testGetAllMovieList();
	}

}
