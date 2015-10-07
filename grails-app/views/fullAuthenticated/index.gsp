<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
</head>
<body>
	<div class="blog-post">

		<h1>Welcome to Grails<security:ifLoggedIn>, <security:name/>!</security:ifLoggedIn></h1>

		<h2 class="blog-post-title">This page is protected by an explicit login</h2>
		<p>You only able to visit this page, if you have logged in via the login page.</p>		
		<p>The remember me checkbox is an unsufficiant authentication in this case.</p>		
	</div>

</body>
</html>
