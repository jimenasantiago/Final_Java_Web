<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.Medicine" %>
<%@page import="java.util.ArrayList" %>
<%
	ArrayList<Medicine> medicines = new ArrayList<Medicine>();
	medicines = (ArrayList<Medicine>) request.getAttribute("medicines");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>See medicines</title>
	<link href="Style/seemedicines.css" rel="stylesheet">
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<div class="medicines-list-wrapper">
			<h1>This is our list of medicines:</h1>
			<ul>
				<% for (Medicine medicine : medicines) { %>
					<li><%=medicine.getname() %> - <%=medicine.getdescription() %></li>
				<% } %>
			</ul>
		</div>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>