<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Furniture Mart</a>
    </div>
    <ul class="nav navbar-nav">
    <spring:url value="/user/signup" var="signURL"></spring:url>
     	<li style="float:right;" ><a href="${signURL}">Sign Up</a></li>
    </ul>
   </div>
</nav>
		<spring:url value="/user/logincheck" var="loginURL" />
		<form:form class="form-horizontal" modelAttribute="userloginform" method="POST" action="${loginURL}">
				<div class="form-group">
			      <label class="control-label col-sm-2" for="email">User Name:</label>
			      <div class="col-sm-2">
			        <form:input type="email" class="form-control" path="email"/><br>
			      </div>
			    </div>
				<div class="form-group">
			      <label class="control-label col-sm-2" for="email">Password:</label>
			      <div class="col-sm-2">
			        <form:input type="password" class="form-control" path="password"/><br>
			       
			      </div>
			    </div>  
				<div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <input type="submit"  value="Login" class="btn btn-default">
			      </div>
			    </div>    
				
				    
		</form:form>
</body>
</html>