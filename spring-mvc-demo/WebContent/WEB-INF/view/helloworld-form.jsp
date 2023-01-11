<!DOCTYPE html>
<html>
<head>
<title>Hello world - Input Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">
<link type="image/png" sizes="16x16" rel="icon" 
	href="${pageContext.request.contextPath}/resources/images/spring-form.png">
</head>
<body>
	<form action="processFormVersionThree" method="GET">
		<input type="text" name="studentName"
			placeholder="What's your Name?" />
		<input type="submit" />
	</form>
</body>
</html>