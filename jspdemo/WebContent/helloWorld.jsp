<%@page import="java.util.Date"%>
<html>

    <head>
        <meta charset="UTF-8"></meta>
        <title>JSP Expressions</title>
        <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
	
	<body>
		<h3>Hello World for Java</h3>
		The time on server is <%= new Date() %>
		<br/><br/>
		Converting a string to upper case <%= new String("Sandeep").toUpperCase() %>
		<br/><br/>
		<p>
			JSP Scripting Elements
			<br/><br/>
			1. JSP Expression  angle bracket open % = % angle bracket close
			<br/>
			2. JSP Scriptlet   angle bracket open %   % angle bracket close
			<br/>
			3. JSP Declaration angle bracket open % ! % angle bracket close
		</p>
	</body>
</html>