<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="theLocale" 
	value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
	scope="session" />
	
<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="com.luv2code.jsp.tagdemo.i18n.resources.mylables" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>i18n Messages test</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen" />
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
	</head>
	<body>
		<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a>
		|
		<a href="i18n-messages-test.jsp?theLocale=hi_IN">Hindi (IN)</a>
		|
		<a href="i18n-messages-test.jsp?theLocale=de_DE">German (DE)</a>
		
		<hr>
		
		<fmt:message key="label.greeting"/> <br/> <br/>
		
		<fmt:message key="label.firstname"/> <i>Sandeep</i> <br/> <br/>
		
		<fmt:message key="label.lastname"/> <i>Prajapati</i> <br/> <br/>
		
		<fmt:message key="label.welcome"/> <br/>
		
		<hr>
		
		Selected Locale: ${theLocale}
	</body>
</html>