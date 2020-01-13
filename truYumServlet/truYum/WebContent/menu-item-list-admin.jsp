<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script src="js/script.js"></script>
<link rel="stylesheet" href="styles/style.css">
<title>Menu-Item-List-Admin</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="images\truyum-logo-light.png">
		<a href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="content">
		<h1>Menu Items</h1>
		<table>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Active</th>
				<th>Date Of Launch</th>
				<th>Category</th>
				<th>Free Delivery</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name}</td>
					<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
							type="currency" value="${menuItem.price}" /></td>
					<td><c:choose>
							<c:when test="${menuItem.active eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${menuItem.dateOfLaunch}" /></td>
					<td>${menuItem.category}</td>
					<td><c:choose>
							<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a class="fcolor"
						href="ShowEditMenuItem?menuItemId=${menuItem.id}">Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<div class="footer">
		<h4>Copyright © 2019</h4>
	</div>
</body>
</html>