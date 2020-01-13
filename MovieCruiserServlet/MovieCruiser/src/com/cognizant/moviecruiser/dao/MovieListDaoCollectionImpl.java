package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;

import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoCollectionImpl implements MovieListDao {

	private static List<MovieList> movieListid;

	public MovieListDaoCollectionImpl() {
		super();

		if (movieListid == null) {

			movieListid = new ArrayList<MovieList>();

			MovieList movie1 = new MovieList(1L, "Avatar", 2787965087l, true,
					new DateUtil().convertToDate("15/03/2017"), "Science Fiction", true);
			MovieList movie2 = new MovieList(2L, "The Avengers", 1518812988l, true,
					new DateUtil().convertToDate("23/12/2017"), "Superhero", false);
			MovieList movie3 = new MovieList(3L, "Titanic", 2187463944l, true,
					new DateUtil().convertToDate("21/08/2017"), "Romance", false);
			MovieList movie4 = new MovieList(4L, "Jurassic World", 1671713208l, false,
					new DateUtil().convertToDate("02/07/2017"), "Science Fiction", true);
			MovieList movie5 = new MovieList(5L, "Avengers: End Game", 2750760348l, true,
					new DateUtil().convertToDate("02/11/2022"), "Superhero", true);

			movieListid.add(movie1);
			movieListid.add(movie2);
			movieListid.add(movie3);
			movieListid.add(movie4);
			movieListid.add(movie5);
		}
	}

	@Override
	public List<MovieList> getMovieListAdmin() {
		return movieListid;
	}

	@Override
	public List<MovieList> getMovieListCustomer() {
		ArrayList<MovieList> filteredMovieList = new ArrayList<MovieList>();
		for (MovieList movieList : movieListid) {
			if (movieList.getDateOfLaunch().before(new Date())) {
				if (movieList.getActive()) {
					filteredMovieList.add(movieList);
				}
			}
		}
		return filteredMovieList;
	}

	@Override
	public void modifyMovieList(MovieList movieList) {
		for (int i = 0; i < movieListid.size(); i++) {
			if (movieListid.get(i).getId() == movieList.getId()) {
				movieListid.set(i, movieList);
			}
		}
	}

	@Override
	public MovieList getMovieList(Long movieListId) {
		for (MovieList movieList : movieListid) {
			if (movieList.getId() == movieListId) {
				return movieList;
			}
		}
		return null;
	}

}
