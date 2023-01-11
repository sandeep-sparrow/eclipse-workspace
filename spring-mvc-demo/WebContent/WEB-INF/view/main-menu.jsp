<!DOCTYPE html>
<html>
<head>
<title>Spring Model View Controller</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">
<link type="image/png" sizes="16x16" rel="icon" 
	href="${pageContext.request.contextPath}/resources/images/spring-icon.png">
<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>
	<h2>Spring MVC demo - Home Page</h2>
	<br><br>
	<a href="hello/showForm">Hello world Form</a>
	<br><br>
	<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png"/>
	<br><br>
	<a href="student/showForm">Student Registration Form</a>
	<br><br>
	<a href="customer/showForm">Customer Registration Form</a>
	<br><br>
	<input type="button" onClick="doSomeWork()" value="Click me!"/>
</body>
</html>