<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cookie Page</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
	</head>
	<body>
		<%
			String myName = "";
		
			// get the cookies from the browser request
			Cookie[] theCookies = request.getCookies();
		
			// find our favorite language cookie
			if(theCookies != null){
				for(Cookie tempCookie : theCookies){
					if("myApp.Cookie".equals(tempCookie.getName())){
						myName = tempCookie.getValue();
						break;
					}
				}
			}
		%>
		<h3>My Name: <%= myName %></h3>
		<c:forEach var="currentCookie" items="${theCookies}">
			Cookie name as map entry key:${currentCookie.key}
			<br/>
			Cookie object as map entry value:${currentCookie.value}
			<br/>
				Name Property of Cookie Object:${currentCookie.value.name}
			<br/>
				Value Property of Cookie Object:${currentCookie.value.value}
			<br/>
		</c:forEach>
	</body>
</html>