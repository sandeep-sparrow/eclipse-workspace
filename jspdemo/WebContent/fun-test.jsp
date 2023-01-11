<%@ page import="com.luv2code.jsp.GeneralUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Java Class Usage with JSP</title>
	</head>
	
	<body>
	Welcome our new JSP Student to the class: 
		<% GeneralUtility gu = new GeneralUtility(); %>
		<%= gu.Greet("Sandeep") %>
	</body>
</html>