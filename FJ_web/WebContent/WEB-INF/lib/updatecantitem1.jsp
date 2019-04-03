<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
	String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
    String infoMessage = request.getAttribute("infoMessage") == null ? "" : (String) request.getAttribute("infoMessage");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Cant Item 1</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="updatecantitem1" method="post">
			<h1>Please enter Id Item and new Item Cant:</h1>
			<h2>Each item has an ID</h2>
			<label>
				 ID Item:
				<input name="idItem" required autofocus>
			</label>
			<label>
				 New Item Cant:
				<input name="newItemCant" required autofocus>
			</label>
			<button type="submit" class="form-submit">Update</button>
			<span class="errorMessage"><%=errorMessage %></span>
			<span class="infoMessage"><%=infoMessage %></span>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>