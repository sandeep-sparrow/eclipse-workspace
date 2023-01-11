<html>

    <head>
        <meta charset="UTF-8"></meta>
        <title>JSP Expressions</title>
        <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    
	<body>
		Converting a String to uppercase: <%= new String("Hello World!").toUpperCase() %>
		<br/>
		Is 75 less than 25: <%= 75 < 25 %>
	</body>
	
</html>