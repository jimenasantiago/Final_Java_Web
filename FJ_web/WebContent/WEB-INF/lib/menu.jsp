<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Menu</title>
	<link href="Style/menu.css" rel="stylesheet">
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<div class="menu">
			<h1>Please, select an option:</h1>
			<div class="options">
				<a href="sellmedicine1">Sell medicine</a>
				<a href="addmedicine">New medicine</a>
				<a href="addpatient">New patient</a>
			</div>
		</div>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>