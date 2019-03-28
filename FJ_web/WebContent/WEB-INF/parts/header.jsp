<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://unpkg.com/normalize.css@8.0.0/normalize.css" rel="stylesheet">
<link href="Style/style.css" rel="stylesheet">
<link href="parts/header.css" rel="stylesheet">
<div class="header-container">
	<div class="header">
		<a href="/" class="header-link">
			<img class="logo" src="images/logo.svg">
			<span class="header-title"> UTN Pharmacy </span>
		</a>
		<% if (session.getAttribute("userSession") != null) { %>
			<div class="header-logout-container">
				<a href="/logout" class="header-logout-link">Logout</a>
			</div>
		<% } %>
	</div>
</div>