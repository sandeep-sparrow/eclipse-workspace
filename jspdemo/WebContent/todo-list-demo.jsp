<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Todo List Demo</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
	</head>
	<body>
		<form action="todo-list-demo.jsp">
			Add New Item: <input type="text" name="theItem"/>
			<input type="submit" value="Submit"/>
		</form>
		
		<br>
		Item Entered: <%= request.getParameter("theItem") %>
		
		<%
			// get the TO DO Items from the session
			List<String> items = (List<String>) session.getAttribute("myToDoList");
		
			// if the TO DO Items does not exist, the create a new one
			if(items == null){
				items = new ArrayList<String>();
				session.setAttribute("myToDoList", items);
			}
			// see if there is form data to add
			String theItem = request.getParameter("theItem");
			if(theItem != null && (!theItem.trim().equals(""))){
				items.add(theItem);
			}
		%>
		
		<hr>
		<b>To Do List Items:</b><br/>
		
		<ol>
		<%
		for(String temp : items){
			out.println("<li>" + temp + "</li>");
		}
		%>	
		</ol>

	</body>
</html>