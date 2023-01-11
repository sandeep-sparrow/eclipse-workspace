<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Add the reference to spring form tag library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration form</title>
<link type="image/png" sizes="16x16" rel="icon" 
	href="${pageContext.request.contextPath}/resources/images/spring-form.png">
	<style>
		.error {color: red}
		body{
			background-color: lightBlue;
			font-family: verdana;
		}
	</style>
</head>
<body>

<br><br>
	
<i>Fill out the Form. Asterik (*) means required</i>

<br><br>

	<form:form action="processForm" modelAttribute="customer">
	
		First Name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name (*) : <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		
		<br><br>
		
		Free passes: <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/>
		
		<br><br>
		
		Postal Code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		
		<br><br>
		
	    Course Code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		
		<br><br>
		
		<input type="submit" value="Register"/>
		
	</form:form>
	
	<br><br>
	
	<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png"/>	
	
</body>
</html>