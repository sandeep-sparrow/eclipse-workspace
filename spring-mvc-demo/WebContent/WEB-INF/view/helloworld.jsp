<!DOCTYPE html>
<html>
<head>
<title>Process Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">
<link type="image/png" sizes="16x16" rel="icon" 
	href="${pageContext.request.contextPath}/resources/images/spring-confirm.png">
</head>
<body>
	<p>
		Hello World of Spring!
		<br><br>
		Student Name: ${param.studentName}
		<br><br>
		The message: ${message}
	</p>
</body>
</html>