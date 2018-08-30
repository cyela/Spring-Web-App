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
<title>Home</title>
</head>
<body>
  <div  class="container">
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <ul class="nav navbar-nav">
		    <spring:url value="/user/adminhome" var="homeURL"></spring:url>
		    <li><a href="${homeURL}">Home</a></li>
			<spring:url value="/user/addProductView" var="adpURL"></spring:url>
		    <li><a href="${adpURL}" style="float:right">Add Product</a></li>
		    <spring:url value="/user/logout" var="logURL"></spring:url>
		    <li><a href="${logURL}" style="float:right">Log out</a></li> 
     </ul>
    </div>
</nav>
</div>
<div  class="container" style="padding:48px 16px">
<div class="container">
<div id="products" class="row list-group"> 
    <c:forEach items="${listAdminProduct}" var="prod">   
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        ${prod.productname}</h4>
                    <p class="group inner list-group-item-text">
                        ${prod.description}</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                ${prod.productprice}</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                         <spring:url value="/user/editproduct/${prod.productId}" var="editURL" />
                            <a class="btn btn-primary" href="${editURL}">Edit Items</a>
                        </div>
                        <div class="col-xs-12 col-md-6">
                         <spring:url value="/user/delproduct/${prod.productId}" var="delURL" />
                            <a class="btn btn-primary" href="${delURL}">Remove</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         
     </c:forEach>
   </div>
</div>
  </div>

</body>
</html>