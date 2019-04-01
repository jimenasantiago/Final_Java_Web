<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.Medicine" %>
<%@page import="java.util.ArrayList" %>
<%
	String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<%
	ArrayList<Medicine> lista = new ArrayList<Medicine>();
	lista = (ArrayList<Medicine>) request.getAttribute("medicines");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 2</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="sellmedicine2" method="post">
			<h1>Sell Medicine by prescription only</h1>
			<h2>Please select Generic Drug:</h2>
			<label>
				Generic drug name:
				<input name="gDrugName" required autofocus>
			</label>
			<button type="submit" class="form-submit">Search Medicine</button>
			<span class="errorMessage"><%=errorMessage %></span>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>
