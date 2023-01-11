<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">
<link type="image/png" sizes="16x16" rel="icon" 
	href="${pageContext.request.contextPath}/resources/images/spring-confirm.png">
</head>
<body>
	<p>
	 	The Student is confirmed: ${student.firstName} ${student.lastName}
	 	<br><br>
	 	Country: ${student.country}
	 	<br><br>
	 	Favorite Language: ${student.favoriteLanguage}
	 	<br><br>
	 	Favorite Language: ${student.favoriteDatabase}
	    <br><br>
	 	Course Code: ${student.courseCode}
	 	
	</p>
	 	<br><br>
	 	Operating Systems:
	 	<ul>
	 		<c:forEach var="temp" items="${student.operatingSystems}">
	 		<li>${temp}</li>
	 		</c:forEach>
	 	</ul>
</body>
</html>