package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {
	private List<MovieList> movieList;
	long total;

	public Favorites() {
		super();
	}

	public List<MovieList> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MovieList> movieList) {
		this.movieList = movieList;
	}

	public void setTotalgross(long total) {
		this.total = total;
	}

	public long getTotal() {
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + (int) (total ^ (total >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (total != other.total)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", total=" + total + "]";
	}

}
