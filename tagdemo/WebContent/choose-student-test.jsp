<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.luv2code.jsp.tagdemo.Student" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%
	// create a sample data
	List<Student> data = new ArrayList<>();

	data.add(new Student("John","Doe",false));
	data.add(new Student("Mary","public",true));
	data.add(new Student("Maxwell","Sharp",true));
	
	// set this value as attribute 
	pageContext.setAttribute("myStudents", data);
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student If test</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
        <%
	    	String myName = "Sandeep";
	    	
	    	// create cookie
	    	Cookie theCookie = new Cookie("myApp.Cookie", myName);
	    	
	    	// life span
	    	theCookie.setMaxAge(60*60*24*365);
	    	
	    	// send cookie to browser
	    	response.addCookie(theCookie);
        %>
	</head>
<body>
	<table border="1">
	
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gold Customer</th>
		</tr>
		
		<c:forEach var="tempStudent" items="${myStudents}">
		
			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td>
					<c:choose>
						<c:when test="${tempStudent.goldCustomer}">
							Special Discount
						</c:when>
						<c:otherwise>
							No Soup for you!
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			
		</c:forEach>
		
	</table>
	<hr>
	<a href="see-cookie.jsp">Click to View Cookie Information</a>

</body>
</html>