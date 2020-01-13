<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<script src="js/script.js"></script>
<link rel="stylesheet" href="styles/style.css">
</head>
<body onload="addcolumn()">
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="images\truyum-logo-light.png">
		<a href="ShowCart">Cart</a> <a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="content">
		<h1>Cart</h1>
		<c:if test="${deletecartstatus}">
			<div class="notification">Item removed from Cart successfully</div>
		</c:if>

		<table id="table_id">
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
			</tr>

			<c:forEach items="${cart.menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name}</td>
					<td><c:choose>
							<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
							type="currency" value="${menuItem.price}" /></td>
					<td><a class="fcolor"
						href="RemoveCart?menuItemId=${menuItem.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td class="total">Total</td>
				<td class="total"><fmt:setLocale value="en_IN" /> <fmt:formatNumber
						type="currency" value="${cart.total}" /></td>
				<td></td>
			</tr>
		</table>

	</div>
	<div class="footer">
		<h4>Copyright © 2019</h4>
	</div>

</body>
</html>