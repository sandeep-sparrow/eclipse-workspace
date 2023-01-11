<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">
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
	<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName"/>
	
	<br><br>
	
	Last Name: <form:input path="lastName"/>
	
	<br><br>
	
	Country:
	<form:select path="country">
		<form:options items="${student.countryOptions}"/>
		<!-- 
			<form:option value="Brazil" label="Brazil"/>
			<form:option value="France" label="France"/>
			<form:option value="Hungary" label="Hungary"/>
			<form:option value="India" label="India"/>
		-->
	</form:select>
	
	<br><br>
	
	Favorite Language:
	<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
	
	<br><br>
	
	Favorite Database:
	
	Oracle Sql <form:radiobutton path="favoriteDatabase" value="Sql"/>
	Db2 <form:radiobutton path="favoriteDatabase" value="Db2"/>
	mongoDb <form:radiobutton path="favoriteDatabase" value="mongoDb"/>
	
	<br><br>
	
	Operating Systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>
	MS windows <form:checkbox path="operatingSystems" value="MS windows"/>
	
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