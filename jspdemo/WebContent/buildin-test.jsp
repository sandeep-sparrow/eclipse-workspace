<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Build in Test</title>
	</head>
	<body>
		<h3>JSP Build-In Test</h3>
		
		Request user agent: <%= request.getHeader("User-Agent") %>
		
		<br><br/>
		
		Request Language: <%= request.getLocale() %>
		
	</body>
</html>