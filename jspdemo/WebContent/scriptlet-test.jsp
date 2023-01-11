<html>

    <head>
        <meta charset="UTF-8"></meta>
        <title>JSP Scriptlets</title>
        <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    
    <body>
    	Scriptlet Example!
		<br/>
		<%
			for(int i=1; i<=5; i++){
				out.println("<br/>I Really JSP: " + i);
			}
		%>
    </body>
    
</html>