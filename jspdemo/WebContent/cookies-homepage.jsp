<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Homepage</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
	</head>
	<body>
		<h3>Training Portal</h3>
		<!-- read the favoriate programming language cookie -->
		<% 
			// the default... if there are not cookies
			String favLang = "Java";
			
			// get the cookies from the browser request
			Cookie[] theCookies = request.getCookies();
			
			// find our favorite language cookie
			if(theCookies != null){
				for(Cookie tempCookie : theCookies){
					if("myApp.favoriteLanguage".equals(tempCookie.getName())){
						favLang = URLDecoder.decode(tempCookie.getValue(),"UTF-8");
						break;
					}
				}
			}
		%>
		
		<!-- Show a personalized page -->
		<h4>New Books for <%= favLang %></h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>
			<li>blah blah blah</li>
		</ul>
		
		<h4>Latest news Report for <%= favLang %></h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>
			<li>blah blah blah</li>
		</ul>
		
		<h4>Hot Jobs for <%= favLang %></h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>
			<li>blah blah blah</li>
		</ul>
		
		<hr>
		<a href="cookies-personalize-form.html">Personalize this Page!</a>
	</body>
</html>