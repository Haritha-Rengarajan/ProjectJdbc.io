package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;

import com.cognizant.moviecruiser.model.MovieList;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
		}
	}

	@Override
	public void addFavorites(long userId, long movieListId) {
		MovieListDao movieListDao = new MovieListDaoCollectionImpl();
		MovieList movieList = movieListDao.getMovieList(movieListId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMovieList().add(movieList);
		} else {
			Favorites favorite = new Favorites();
			ArrayList<MovieList> movieListid = new ArrayList<>();
			movieListid.add(movieList);
			favorite.setMovieList(movieListid);
			userFavorites.put(userId, favorite);
		}

	}

	@Override
	public Favorites getAllMovieList(long userId) throws FavoritesEmptyException {
		Favorites favorite = userFavorites.get(userId);
		long total = 0;
		@SuppressWarnings("unused")
		int totalgross=0;
		if (favorite == null || favorite.getMovieList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		List<MovieList> movieListDao = userFavorites.get(userId).getMovieList();
		for (MovieList movieList : movieListDao) {
			totalgross += movieList.getGross();
			total++;
		}
		favorite.setTotalgross(total);
		System.out.println("Total Gross : " + favorite.getTotal());
		return favorite;
	}

	@Override
	public void removeFavorites(long userId, long movieListId) {
		List<MovieList> movieList = userFavorites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieListId) {
				movieList.remove(i);
				return;
			}
		}
	}

}
