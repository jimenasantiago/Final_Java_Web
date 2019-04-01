<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
	String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Price Medicine 1</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="updatepricemedicine1" method="post">
			<h1>Please enter Percentage Drug Price Increase:</h1>
			<h2>Ex. 15%, enter 0.15</h2>
			<label>
				Health Plan ID:
				<input name="percentMedicine" required autofocus>
			</label>
			
			<button type="submit" class="form-submit">Update</button>
			<span class="errorMessage"><%=errorMessage %></span>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>
