<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<title>Student Confirmation</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
	</head>
	<body>
		The Student is Confirmed: ${param.firstName} ${param.lastName}
		<br><br/>
		Student's Favorite Programming Language: 
		<ul>
			<%
				String[] langs = request.getParameterValues("favoriteLanguage");
			
				for(String tempLang : langs ){
					out.println("<li>" + tempLang + "</li>");
				}
			%>
		</ul>

		
	</body>
</html>