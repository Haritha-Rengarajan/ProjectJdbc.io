package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;

public interface MovieListDao {

	public List<MovieList> getMovieListAdmin();

	public List<MovieList> getMovieListCustomer();

	public void modifyMovieList(MovieList movieList);

	public MovieList getMovieList(Long movieListId);
}
