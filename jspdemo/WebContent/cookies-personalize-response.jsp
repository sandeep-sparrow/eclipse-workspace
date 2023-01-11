<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cookies Personalize JSP</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
		<%
			// read form data
			String favLang = request.getParameter("favoriteLanguage");
		
			// encode cookie data...handle case of language with spaces
			favLang = URLEncoder.encode(favLang, "UTF-8");
			
			// create the cookie
			Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);
			
			// set the life span
			theCookie.setMaxAge(60*60*24*365);
			
			// send the cookies to browser
			response.addCookie(theCookie);
		%>	
	</head>
	<body>
		Thanks! we set your favorite language to: ${param.favoriteLanguage}
		<br><br/>
		<a href="cookies-homepage.jsp">Return to Homepage!</a>
	</body>

</html>