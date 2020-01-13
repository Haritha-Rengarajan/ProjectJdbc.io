package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieList;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_FAVORITES = "insert into favorites(fav_us_id, fav_mov_id) values(?,?)";
	public static final String GET_ALL_FAVORITES = "SELECT mov_id, mov_title, mov_has_teaser, mov_gross, mov_active,mov_date_of_launch, mov_genre  FROM favorites\r\n"
			+ "INNER JOIN movie_list on movie_list.mov_id = favorites.fav_mov_id\r\n"
			+ "INNER JOIN user on user.us_id = favorites.fav_us_id\r\n" + "WHERE user.us_id=?";
	public static final String REMOVE_FAVORITES = "delete from favorites where fav_us_id=? and fav_mov_id=? limit 1";
	public static final String GET_TOTAL = "SELECT user.us_id, count(favorites.fav_id) as mov_no_of_fav FROM favorites\r\n"
			+ "INNER JOIN movie_list on movie_list.mov_id = favorites.fav_mov_id\r\n"
			+ "INNER JOIN user on user.us_id = favorites.fav_us_id\r\n" + "WHERE user.us_id=?";

	@Override
	public void addFavorites(long userId, long movieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(ADD_FAVORITES);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, movieListId);

			int noOfRows = preparedstatement.executeUpdate();
			System.out.println("Number of Rows Affected -> " + noOfRows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Favorites getAllMovieList(long userId) throws FavoritesEmptyException {
		ArrayList<MovieList> movieList = new ArrayList<MovieList>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		PreparedStatement preparedstatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MovieList movie_list = null;
		Favorites fav = new Favorites();
		try {
			preparedstatement = connection.prepareStatement(GET_ALL_FAVORITES);
			preparedstatement.setLong(1, userId);
			resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {
				movie_list = new MovieList();
				movie_list.setId(resultSet.getInt("mov_id"));
				movie_list.setTitle(resultSet.getString("mov_title"));
				movie_list.setHasTeaser(resultSet.getString("mov_has_teaser").equals("Yes"));
				movie_list.setGross(resultSet.getLong("mov_gross"));
				movie_list.setActive(resultSet.getString("mov_active").equals("Yes"));
				movie_list.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movie_list.setGenre(resultSet.getString("mov_genre"));

				movieList.add(movie_list);
			}
			if (movieList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			fav.setMovieList(movieList);
			preparedstatementTotal = connection.prepareStatement(GET_TOTAL);
			preparedstatementTotal.setLong(1, userId);
			resultSetTotal = preparedstatementTotal.executeQuery();
			long total = 0l;
			while (resultSetTotal.next()) {
				total = resultSetTotal.getLong("mov_no_of_fav");
				fav.setTotalgross(total);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSetTotal != null) {
					resultSetTotal.close();
				}
				if (preparedstatementTotal != null) {
					preparedstatementTotal.close();
				}
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return fav;
	}

	@Override
	public void removeFavorites(long userId, long movieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(REMOVE_FAVORITES);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, movieListId);

			int noOfRows = preparedstatement.executeUpdate();
			System.out.println("Number of Rows Affected -> " + noOfRows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}

		}

	}
}
