<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@	page import="com.luv2code.springdemo.util.SortUtils" %>
<!DOCTYPE html>

<html>

	<head>
		<title>List Customers</title>
		<!-- Reference to the CSS file -->
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css"/>
			  
		<link type="image/png" sizes="16x16" rel="icon" 
			  href="${pageContext.request.contextPath}/resources/images/spring-confirm.png">
	</head>

	<body>
	
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		&nbsp;
		
		<div id="Container">
		
			<div id="content">
			
				<!-- put new button: Add Customer -->
				<input type="button" value="Add Customer"
					   onclick="window.location.href='showFormForAdd'; return false;"
					   class="add-button"
				/>
				
				<!-- add new search box -->
				<form:form action="search" method="GET">
					Search Customer: <input type="text" name="theSearchName"/>
					<input type="submit" value="Search" class="add-button"/>
				</form:form>
				
				<!-- add out html table here -->
				<table>
				
					<!-- construct a sort link for first name -->
					<c:url var="sortLinkFirstName" value="/customer/list">
						<c:param name="sort" value="<%=Integer.toString(SortUtils.FIRST_NAME) %>" />
					</c:url>

					<!-- construct a sort link for last name -->
					<c:url var="sortLinkLastName" value="/customer/list">
						<c:param name="sort" value="<%=Integer.toString(SortUtils.LAST_NAME) %>" />
					</c:url>

					<!-- construct a sort link for email -->
					<c:url var="sortLinkEmail" value="/customer/list">
						<c:param name="sort" value="<%=Integer.toString(SortUtils.EMAIL) %>" />
					</c:url>
						
					<tr>
						<th><a href="${sortLinkFirstName}">First Name</a></th>
						<th><a href="${sortLinkLastName}">Last Name</a></th>
						<th><a href="${sortLinkEmail}">Email</a></th>
						<th>Action</th>
					</tr>
					
					<!-- loop over and print the customers -->
					<c:forEach var="tempCustomer" items="${customers}">
				
						<!-- construct an "update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"/>
						</c:url>
						
						<!-- construct an "delete link with customer id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}"/>
						</c:url>
						
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<!-- diplay th updateLink -->
								<a href="${updateLink}">Update</a>
								|
								<!-- diplay th deleteLink -->
								<a href="${deleteLink}"
								   onclick="if (!(confirm('Are you sure you want to delete this?'))) return false">
									Delete
								</a>								
							</td>
						</tr>
						
					</c:forEach>
					
				</table>
				
			</div>
			
		</div>
		 
	</body>

</html>