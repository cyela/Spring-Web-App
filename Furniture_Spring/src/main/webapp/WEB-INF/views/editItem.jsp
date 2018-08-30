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
<div class="form-container">
<spring:url value="/user/editProductsave" var="addURL" />
<form:form class="form-horizontal" modelAttribute="productform" method="POST" action="${addURL}" >
    <div  class="container">
      <h4 id="add">Edit Products </h4>
      <p>Please provide new description for the updated product</p>
      <hr>
        	<div   class="row">
                  <div class="form-group">
        	        <div class=" col-sm-4 col-md-24">
        	        
            			      <form:input type="text" class="form-control"  path="productname" value="${selproduct.productname}"/><br>
            			      <form:textarea rows="5" class="form-control" path="description" value="${selproduct.description}" placeholder="${selproduct.description}"/></textarea><br>
            			      <form:input type="number" class="form-control" path="productprice" value="${selproduct.productprice}"/><br>
            			      <form:input type="number" class="form-control" path="quantity"  value="${selproduct.quantity}"/><br>
            			      <form:input type="hidden" class="form-control"  path="productId" value="${selproduct.productId}"/>
            			      <input type="submit" class="btn btn-primary btn-block" value="UPDATE" />
            			</div>
                </div>
           </div>
		<hr>
        </div>
 </form:form>
</div>
  </div>

</body>
</html>