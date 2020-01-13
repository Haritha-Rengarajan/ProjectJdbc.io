<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/script.js"></script>
<link rel="stylesheet" href="styles/style.css">
<title>Movie-List-Customer</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="images\movie.png">
		<a href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="content">
		<h1>Movies</h1>
		<c:if test="${addFavoriteStatus}">
			<div class="notification">Movie added to Favorites
				Successfully.</div>
		</c:if>
		<table>
			<tr>
				<th>Title</th>
				<th>Box Office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${movieList}" var="movieList">
				<tr>
					<td>${movieList.title}</td>
					<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
							type="currency" value="${movieList.gross}" /></td>
					<td>${movieList.genre}</td>
					<td><c:choose>
							<c:when test="${movieList.hasTeaser eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a class="fcolor"
						href="AddToFavorites?movieListId=${movieList.id}">Add to
							Favorite</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<div class="footer">
		<h4>Copyright © 2019</h4>
	</div>
</body>
</html>
