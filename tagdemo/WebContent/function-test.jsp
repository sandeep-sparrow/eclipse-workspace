<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Function test</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
	</head>
	<body>
		<c:set var="stuff" value="<%= new java.util.Date() %>"/>
		Time on the Server is ${stuff}
		
		<br/><br/>
		
		<c:set var="name" value="sandeep"/>
		Length of the String <b>${name}</b>: ${fn:length(name)}
		
		<br/><br/>
		
		<c:set var="data" value="luv2code"/>
		UpperCase version of the String <b>${data}</b>: ${fn:toUpperCase(data)}
		
		<br/><br/>
		
		Does the String <b>${data}</b> starts with <b>luv</b>?: ${fn:startsWith(data,"luv")}
	</body>
</html>