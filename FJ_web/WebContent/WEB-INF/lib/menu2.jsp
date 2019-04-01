<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	HttpSession mysession = (HttpSession) request.getSession();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Menu 2</title>
	<link href="Style/menu.css" rel="stylesheet">
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<div class="menu">
			<h1>Please, select an option:</h1>
			<div class="options">
				<a href="sellmedicine1">Sell medicine</a>
				
				<a href="addpatient">New patient</a>
			</div>
		</div>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>