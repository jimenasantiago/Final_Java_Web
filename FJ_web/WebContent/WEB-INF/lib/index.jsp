<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.User" %>
<%
	User loggedUser = (User) session.getAttribute("userSession");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome to UTN Pharmacy</title>
	<link href="Style/index.css" rel="stylesheet">
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<div class="presentation">
			<h1>Welcome to UTN Pharmacy</h1>
			
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet luctus venenatis lectus magna. Commodo ullamcorper a lacus vestibulum sed arcu non odio euismod. Et malesuada fames ac turpis egestas sed tempus.</p>
		</div>
		<div class="what-we-do-container">
			<div class="what-we-do">
				<% if (loggedUser == null) {%>
					<p>If you are a cashier, please Login</p>
					<a class="what-we-do-link" href="login">Login</a>
				<% } else { %>
					<p>Welcome <%=loggedUser.getName() %></p>
					<a class="what-we-do-link" href="menu">Menu</a>
				<%} %>
			</div>
			<div class="what-we-do">
				<p>Here you can see our list of medicines</p>
				<a class="what-we-do-link" href="seemedicines">See medicines</a>
			</div>
		</div>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>