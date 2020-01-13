package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoSqlImpl implements MovieListDao {
	public static final String VIEW_MOVIE_LIST_ADMIN = "select * from movie_list";
	public static final String VIEW_MOVIE_LIST_CUSTOMER = "select * from movie_list where  mov_date_of_launch > CURDATE() and mov_active = 'Yes'";
	public static final String EDIT_MOVIE_LIST = "update movie_list set mov_title=?, mov_gross=?, mov_active=?, mov_date_of_launch=?, mov_genre=?, mov_has_teaser=? where mov_id=?";
	public static final String GET_MOVIE_LIST = "select * from movie_list where mov_id = ?";

	@Override
	public List<MovieList> getMovieListAdmin() {

		ArrayList<MovieList> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			preparedstatement = connection.prepareStatement(VIEW_MOVIE_LIST_ADMIN);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MovieList movie_list = new MovieList();
				movie_list.setId(resultset.getInt("mov_id"));
				movie_list.setTitle(resultset.getString("mov_title"));
				movie_list.setGross(resultset.getLong("mov_gross"));
				movie_list.setActive(resultset.getString("mov_active").equals("Yes"));
				movie_list.setDateOfLaunch(resultset.getDate("mov_date_of_launch"));
				movie_list.setGenre(resultset.getString("mov_genre"));
				movie_list.setHasTeaser(resultset.getString("mov_has_teaser").equals("Yes"));
				movieList.add(movie_list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
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
		return movieList;
	}

	@Override
	public List<MovieList> getMovieListCustomer() {

		ArrayList<MovieList> movieListCustomer = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			preparedstatement = connection.prepareStatement(VIEW_MOVIE_LIST_CUSTOMER);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MovieList movie_list = new MovieList();
				movie_list.setId(resultset.getInt("mov_id"));
				movie_list.setTitle(resultset.getString("mov_title"));
				movie_list.setGross(resultset.getLong("mov_gross"));
				movie_list.setActive(resultset.getString("mov_active").equals("Yes"));
				movie_list.setDateOfLaunch(resultset.getDate("mov_date_of_launch"));
				movie_list.setGenre(resultset.getString("mov_genre"));
				movie_list.setHasTeaser(resultset.getString("mov_has_teaser").equals("Yes"));
				movieListCustomer.add(movie_list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
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
		return movieListCustomer;
	}

	@Override
	public void modifyMovieList(MovieList movieList) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(EDIT_MOVIE_LIST);
			preparedstatement.setString(1, movieList.getTitle());
			preparedstatement.setFloat(2, movieList.getGross());
			preparedstatement.setString(3, movieList.getActive() ? "Yes" : "No");
			new DateUtil();
			preparedstatement.setDate(4, DateUtil.convertToSqlDate(movieList.getDateOfLaunch()));
			preparedstatement.setString(5, movieList.getGenre());
			preparedstatement.setString(6, movieList.getHasTeaser() ? "Yes" : "No");
			preparedstatement.setLong(7, movieList.getId());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
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

	}

	@Override
	public MovieList getMovieList(Long movieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		MovieList movie_list = null;

		try {

			preparedstatement = connection.prepareStatement(GET_MOVIE_LIST);
			preparedstatement.setLong(1, movieListId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				movie_list = new MovieList();
				movie_list.setId(resultset.getInt("mov_id"));
				movie_list.setTitle(resultset.getString("mov_title"));
				movie_list.setGross(resultset.getLong("mov_gross"));
				movie_list.setActive(resultset.getString("mov_active").equals("Yes"));
				movie_list.setDateOfLaunch(resultset.getDate("mov_date_of_launch"));
				movie_list.setGenre(resultset.getString("mov_genre"));
				movie_list.setHasTeaser(resultset.getString("mov_has_teaser").equals("Yes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
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
		return movie_list;

	}

}
