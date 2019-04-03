<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.*" %>
<%@page import="java.util.ArrayList" %>
<%
    HttpSession mysession = (HttpSession) request.getSession();
    
    ArrayList<Item> items = (ArrayList<Item>)mysession.getAttribute("items2");
	
    ArrayList<Medicine> medicines = new ArrayList<Medicine>();
	medicines = (ArrayList<Medicine>)mysession.getAttribute("medicines2");
	
	ArrayList<Presentation> pres2 = new ArrayList<Presentation>();
	pres2 = (ArrayList<Presentation>)mysession.getAttribute("pres2");

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>See Medicine Stock Min step 2</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="seemedicinestockmin2" method="post">
			<h1>Medicines should be replaced soon:</h1>
			<ul>
				
				<% for (int i=0;i<items.size();i++) { %>
				
					<li> ID Item: <%=items.get(i).getidItem()%> - <%=medicines.get(i).getname()%>  : <%=medicines.get(i).getdescription()%> - Cant: <%=items.get(i).getcantStock()%> </li>
				<% } %>
				
				
			</ul>
		</form>
		</div>
		
	<%@include file="../parts/footer.html" %>
</body>
</html>