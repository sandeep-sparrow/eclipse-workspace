<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.luv2code.jsp.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>JSP Home Page</title>
        <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
	</head>
	<body>
		<jsp:include page="my-header.html"/>
		
		<br><br/>
		
		Welcome our new JSP Student to the class: 
		<% GeneralUtility gu = new GeneralUtility(); %>
		<%= gu.Greet("Sandeep") %>
		
		<br><br/>
		
		Request user agent: <%= request.getHeader("User-Agent") %>
		
		<br><br/>
		
		Request Language: <%= request.getLocale() %>
		<jsp:include page="my-footer.jsp"/>
	</body>
</html>