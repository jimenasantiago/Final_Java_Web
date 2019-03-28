<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="Style/login.css" rel="stylesheet">
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="login" method="post">
			<h1>Please login</h1>
			<label>
				User:
				<input name="user" required autofocus>
			</label>
			<label>
				Password:
				<input name="password" type="password" required>
			</label>     
			<button type="submit" class="form-submit">Login</button>
			<span class="errorMessage"><%=errorMessage %></span>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>