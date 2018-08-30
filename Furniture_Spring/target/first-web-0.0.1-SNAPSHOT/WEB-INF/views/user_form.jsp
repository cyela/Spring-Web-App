<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user form</title>
</head>
<body>
<spring:url value="/user/save" var="saveURL" />
<form:form modelAttribute="userform" method="POST" action="${saveURL}">
<form:hidden path="email"/>
<table>
	<tr> 
		<td>Firstname:</td>
		<td> <form:input path="firstName"/></td>
	</tr>
	<tr> 
		<td>LastName:</td>
		<td> <form:input path="lastName"/></td>
	</tr>
	<tr> 
		<td>email:</td>
		<td> <form:input path="email"/></td>
	</tr>
	<tr> 
		<td>password:</td>
		<td> <form:input path="password"/></td>
	</tr>
	<tr> 
		<td>Phonenumber:</td>
		<td> <form:input path="phonenumber"/></td>
	</tr>
	<tr> 
		<td></td>
		<td> <button type="submit"/>Save</button></td>
	</tr>
</table>
</form:form>
</body>
</html>