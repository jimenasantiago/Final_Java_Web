<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
	String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>See Medicine Stock Min step 1</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="seemedicinestockmin1" method="post">
			<h1>See Medicine Min Stock:</h1>
			<h2>Please enter Min Stock:</h2>
			<label>
				Min Stock:
				<input name="stockMin" required autofocus>
			</label>
			
			<button type="submit" class="form-submit">Search</button>
			<span class="errorMessage"><%=errorMessage %></span>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>