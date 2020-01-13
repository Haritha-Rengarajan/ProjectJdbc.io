<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<title>Edit-Menu-Item</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="images\truyum-logo-light.png">
		<a href="ShowMenuItemListAdmin">Menu</a>
	</div>

	<h1>Edit Menu Item</h1>
	<div class="body-content-colour">
		<form action="EditMenuItem" onsubmit="return validateMenuItemform()"
			name="menuItemform" method="post">

			<div class="form-field-spacing">
				<label for="name">Name</label><br> <input type="text"
					class="text-box text-box-title" name="name"
					value="${menuItem.name}">
			</div>
			<br>
			<div class="form-field-spacing">
				<label for="price">Price(Rs.)</label><br> <input type="text"
					class="text-box" name="price" id="price" value="${menuItem.price}">
			</div>

			<div class="form-field-spacing">
				<label for="active">Active </label><br>
				<c:if test="${menuItem.active}">
					<input type="radio" class="radio" name="active" value="yes" checked>Yes
                <input type="radio" class="radio" name="active"
						value="no">No 
                </c:if>
				<c:if test="${!menuItem.active}">
					<input type="radio" class="radio" name="active" value="yes" checked>Yes
                <input type="radio" class="radio" name="active"
						value="no" checked>No
                </c:if>
			</div>

			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date Of Launch</label><br> <input
					type="text" class="text-box" name="dateOfLaunch"
					value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${menuItem.dateOfLaunch}" />">
			</div>

			<div class="form-field-spacing">
				<label for="freeDelivery">Free Delivery</label>
				<c:if test="${menuItem.freeDelivery}">
					<input type="checkbox" class="checkbox" name="freeDelivery" checked>
				</c:if>
				<c:if test="${!menuItem.freeDelivery}">
					<input type="checkbox" class="checkbox" name="freeDelivery">
				</c:if>
			</div>

			<div class="form-field-spacing">
				<label for="category">Category</label> <select name="category"
					class="dropdown">
					<option value="${menuItem.category}">${menuItem.category}</option>
					<option value="starters">Starters</option>
					<option value="main course">Main Course</option>
					<option value="dessert">Dessert</option>
					<option value="drinks">Drinks</option>
				</select>
			</div>
			<div>
				<input type="hidden" name="id" value="${menuItem.id}">
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