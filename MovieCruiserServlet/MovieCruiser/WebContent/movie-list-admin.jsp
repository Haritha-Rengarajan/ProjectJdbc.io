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
            <title>Movie-List-Admin</title>
    </head>
    <body>
        <div class="topnav">
            <div class="home">Movie Cruiser</div>
            <img src="images\movie.png">
            <a href="ShowMovieListAdmin">Movies</a>
        </div>
        <div class="content"><h1>Movies</h1>
            <table>
                    <tr>
                    <th>Title</th>
                    <th>Box Office</th>
                    <th>Active</th>
                    <th>Date Of Launch</th>
                    <th>Genre</th>
                    <th>Has Teaser</th>
                    <th>Action</th>
                    </tr>
                    
			<c:forEach items="${movieList}" var="movieList">
				<tr>
					<td>${movieList.title}</td>
					<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
							type="currency" value="${movieList.gross}" /></td>
					<td><c:choose>
							<c:when test="${movieList.active eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${movieList.dateOfLaunch}" /></td>
					<td>${movieList.genre}</td>
					<td><c:choose>
							<c:when test="${movieList.hasTeaser eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a class="fcolor"
						href="ShowEditMovie?movieListId=${movieList.id}">Edit</a></td>
				</tr>
			</c:forEach>
                    
            </table>
            </div>
            <div class="footer">
                <h4>Copyright © 2019</h4>
            </div>
        </body>
        </html>