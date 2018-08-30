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
<body style="background: url('<spring:url value="/images/MainPage.jpg"/>') no-repeat center center;">
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
<div class="jumbotron text-center" style="margin-bottom: 0px;
    opacity: 0.6;
    color: #fff;
    background: #000 ;" >

	  <h1>Furniture Mart</h1> 
	  <p>Its home for furniture products</p> 
 
     <form class="form-inline">
     <div class="input-group">
	        <div class="form-group">        
	        <div class="col-sm-offset-2 col-sm-10">
		        <spring:url value="/user/login" var="addURL"></spring:url>
				<a href="${addURL }"><button type="button"  class="btn btn-primary btn-lg" >Login</button></a>
			</div>
			</div>
      </div>
   
  </form>
</div>

</body>
</html>