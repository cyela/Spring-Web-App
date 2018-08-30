<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
</head>
<body>

<spring:url value="/user/add" var="addURL"></spring:url>
<a href="${addURL }"> Add User</a>
<h1>Users List</h1>
<table width="100%" border="1">
<tr>
<th>Email</th>
<th>Firstname</th>
<th>Lastname</th>
<th colspan="2">Action</th>
</tr>
<c:forEach items="${listUser}" var="user">
	<tr>
		<td>${user.email}</td>
		<td>${user.firstName}</td>
		<td>${user.lastName}</td>
		<td>
			<spring:url value="/user/update/${user.email}" var="updateURL" />
			<a href="${updateURL}" > Update </a> 		
		</td>
		<td>
			<spring:url value="/user/delete/${user.email}" var="delURL" />
			<a href="${delURL}" > Delete </a> 		
		</td>
	</tr>

</c:forEach>
</table>
</body>
</html>