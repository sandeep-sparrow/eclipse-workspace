<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.luv2code.web.jdbc.*"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Student</title>
		<link type="image/png" sizes="16x16" rel="icon" 
	       href="images/jsp.png">
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        <link type="text/css" rel="stylesheet" href="css/add-student-style.css"/>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Luv2Code University</h2>
			</div>
			
			<div id="container">
				<h3>Add Student</h3>
				<form action="StudentControllerServlet" method="GET">
					<input type="hidden" name="command" value="ADD"/>
					
					<table>
						<tbody>
						
							<tr>
								<td><label>First Name:</label></td>
								<td><input type="text" name="firstName"/></td>
							</tr>
							
							<tr>
								<td><label>Last Name:</label></td>
								<td><input type="text" name="lastName"/></td>
							</tr>
								
							<tr>
								<td><label>Email:</label></td>
								<td><input type="text" name="email"/></td>
							</tr>
				
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="Save" class="save"/></td>
							</tr>	
									
						</tbody>					
					</table>
					
				</form>
				
				<div style="clear: both;"></div>
				
				<p>
					<a href="StudentControllerServlet">Back to List</a>
				</p>
				
			</div>
		</div>
	</body>
</html>