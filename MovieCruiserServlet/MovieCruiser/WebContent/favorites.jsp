<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<title>Favorites</title>
</head>
<body onload="addcolumn()">
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="C:\Users\833488\MovieCruiserServlet\MovieCruiser\WebContent\images\movie.png">
		<a href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="content">
		<h1>Favorites</h1>
	</div>
	<c:if test="${deletefavoritestatus}">
		<div class="notification">Movie removed from Favorites
			successfully</div>
	</c:if>
<div>
	<table id="table_id">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
		</tr>

		<c:forEach items="${favorite.movieList}" var="movieList">
			<tr>
				<td>${movieList.title}</td>
				<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
						type="currency" value="${movieList.gross}" /></td>
				<td>${movieList.genre}</td>
				<td><a class="fcolor"
					href="RemoveFavorites?movieListId=${movieList.id}">Delete</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td class="total">No. of Favorites:</td>
			<td class="total">${favorite.total}</td>
			<td></td>
		</tr>

	</table>

	</div>
	<div class="footer">
		<h4>Copyright © 2019</h4>
	</div>
</body>
</html>



