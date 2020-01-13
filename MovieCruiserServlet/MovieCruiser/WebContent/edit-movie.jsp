<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<title>Edit-Movie</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="images\movie.png">
		<a href="ShowMovieListAdmin">Movies</a>
	</div>

	<div>
		<h1>Edit Movie</h1>
	</div>
	<div class="body-content-colour">
		<form action="EditMovie" onsubmit="return validateMovieform()"
			name="editmovie" method="post">

			<div class="form-field-spacing">
				<label for="title">Title</label><br> <input type="text"
					class="text-box text-box-title" name="title"
					value="${movieList.title}">
			</div>
			<div>
				<div class="form-field-spacing">
					<label for="gross">Gross ($)</label><br> <input type="text"
						class="text-box" name="gross" value="${movieList.gross}">
				</div>

				<div class="form-field-spacing">
					<label for="active">Active </label><br>
					<c:if test="${menuItem.active}">
						<input type="radio" class="radio" name="active" value="yes"
							checked>Yes
                <input type="radio" class="radio" name="active"
							value="no">No 
                </c:if>
					<c:if test="${!menuItem.active}">
						<input type="radio" class="radio" name="active" value="yes"
							checked>Yes
                <input type="radio" class="radio" name="active"
							value="no" checked>No
                </c:if>
				</div>

				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date Of Launch</label><br> <input
						type="text" class="text-box" name="dateOfLaunch"
						value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${movieList.dateOfLaunch}"/>">
				</div>

				<div class="form-field-spacing">
					<label for="genre">Genre</label><br> <select name="genre"
						class="dropdown">
						<option value="${movieList.genre}">${movieList.genre}</option>
						<option value="sciencefiction">Science Fiction</option>
						<option value="superhero">Superhero</option>
						<option value="romance">Romance</option>
						<option value="comedy">Comedy</option>
						<option value="adventure">Adventure</option>
						<option value="thriller">Thriller</option>
					</select>
				</div>
				<br> <br>
				<div class="form-field-spacing">
					<label for="hasTeaser">Has Teaser</label>
					<c:if test="${movieList.hasTeaser}">
						<input type="checkbox" class="checkbox" name="hasTeaser" checked>
					</c:if>
					<c:if test="${!movieList.hasTeaser}">
						<input type="checkbox" class="checkbox" name="hasTeaser">
					</c:if>
				</div>
			</div>
			<br>
			<div>
				<input type="hidden" name="id" value="${movieList.id}">
			</div>
			<div class="form-field-spacing">
				<input type="submit" class="button success-button" value="Save">
			</div>

		</form>
		<div class="footer">
			<h4>Copyright © 2019</h4>
		</div>
	</div>
</body>
</html>