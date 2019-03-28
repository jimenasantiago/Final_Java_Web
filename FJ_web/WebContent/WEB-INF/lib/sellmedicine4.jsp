<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.Presentation" %>
<%@page import="java.util.ArrayList" %>
<%
	ArrayList<Presentation> lista = new ArrayList<Presentation>();
	lista = (ArrayList<Presentation>) request.getAttribute("pres");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 4</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="sellmedicine4" method="post">
			<h1>Sell Medicine by prescription only</h1>
			<h2>Please select Medicine Presentation:</h2>
			<label>
				Presentation:
				<select name="idPresentation" required autofocus>
					<% for (Presentation pre : lista) { %>
						<option value="<%=pre.getIdPresentation()%>">
							<%=pre.getDescription()%>
						</option>
					<% } %>
				</select>
			</label>
			<label>
				Reg. Number Professional:
				<input name="regNumberP" required>
			</label>
			<button type="submit" class="form-submit">Select</button>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>
