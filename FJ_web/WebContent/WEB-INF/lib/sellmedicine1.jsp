<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
	String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 1</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="sellmedicine1" method="post">
			<h1>Sell Medicine by prescription only</h1>
			<h2>Please enter patient data:</h2>
			<label>
				Health Plan ID:
				<input name="healthPlanId" required autofocus>
			</label>
			<label>
				Affiliate Number:
				<input name="affiliateNumberHP" required>
			</label>
			<button type="submit" class="form-submit">Search</button>
			<span class="errorMessage"><%=errorMessage %></span>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>
