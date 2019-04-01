<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.*" %>
<%
	String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<%
	Item item = new Item();
	Professional prof = new Professional();
	Medicine med = new Medicine();
	HttpSession mysession = (HttpSession) request.getSession();
	item = (Item)mysession.getAttribute("itemsel");
	prof = (Professional)mysession.getAttribute("professional");
	med = (Medicine)mysession.getAttribute("medicine");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 5</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="sellmedicine5" method="post">
			<h1>Sell Medicine by prescription only</h1>
			<p>Professional Name: <%=prof.getsurname() %>, <%=prof.getname() %></p>
			<p>Medicine name: <%=med.getname() %></p>
			<p>Stock Medicine: <%=item.getcantStock() %></p>
			<p>Price: <%=item.getprice() %></p>
			<h2>Please choose quantity of items:</h2>
			<label>
				Items number:
				<input name="cantItem" required autofocus>
			</label>
			<button type="submit" class="form-submit">Select</button>
			<span class="errorMessage"><%=errorMessage %></span>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>
