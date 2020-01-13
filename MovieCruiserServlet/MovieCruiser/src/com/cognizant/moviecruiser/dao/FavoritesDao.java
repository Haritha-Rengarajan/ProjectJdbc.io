package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavoritesDao {

	public void addFavorites(long userId, long movieListId);

	public Favorites getAllMovieList(long userId) throws FavoritesEmptyException;

	public void removeFavorites(long userId, long movieListId);

}
