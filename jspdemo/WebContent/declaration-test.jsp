<html>

    <head>
        <meta charset="UTF-8"></meta>
        <title>JSP Scriptlets</title>
        <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    
    <body>
    	<h3>JSP Declaration Example</h3>
    	<br/>
    	Hello World! - the below JSP tag declares a method...
    	<br/>
    	<%!
    		String makeItLower(String data){
    		String str = data.toLowerCase();
    		String fnl = "Good Morning! " +  str;
    		return fnl;
    	}
    	%>
    	Lower Case "Hello World": <%= makeItLower("Sandeep") %>
    
    </body>
    
</html>