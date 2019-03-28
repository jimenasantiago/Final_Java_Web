<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.HealthPlan" %>
<%@page import="java.util.ArrayList" %>
<%
	ArrayList<HealthPlan> lista = new ArrayList<HealthPlan>();
	lista = (ArrayList<HealthPlan>) request.getAttribute("hplans");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add patient</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="addpatient" method="post">
			<h1>Please register new patient</h1>
			<label>
				Surname:
				<input name="surname" required autofocus>
			</label>
			<label>
				Names:
				<input name="name" required>
			</label>
			<label>
				Birth Date:
				<input name="birthdate" required>
			</label>
			<label>
				Health Plan:
				<select name="healthPlanId" required>
					<% for (HealthPlan hp : lista) { %>
						<option value="<%=hp.getidHealthPlan()%>">
							<%=hp.getnameHP()%>
						</option>
					<% } %>
				</select>
			</label>
			<label>
				Affiliate Number Health Plan:
				<input name="affiliateNHP" required>
			</label>
			<button type="submit" class="form-submit">Register</button>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>
