<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Home Of Furniture</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 <spring:url value="/user/login" var="loginrURL"></spring:url>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setHeader("Expires", "0"); // Proxies.
	
	if(session.getAttribute("user")==null){
		response.sendRedirect("${loginrURL}");
	}
	%>
</head>
<body >

<script type="text/javascript">
	var Msg ='<%=request.getAttribute("Login")%>';
	    if (Msg == "success")
	    {
				 function alertName(){
					 
				 alert("Logged in successfully");
				 }
				 
	    } 
	var Msg1='<%=request.getAttribute("cart_item")%>';
	
	if (Msg1 == "added")
	{
		 function alertName(){
		 alert("Item has been successfully added to cart");
		 }
	} else if (Msg1 == "exists")
	{
		 function alertName(){
		 alert("Already in cart\nYou can change quantity by visiting View Cart Page\nThank you");
		 }
	}    
	var Msg ='<%=request.getAttribute("cart")%>';
	   if (Msg == "placed")
	   {
			 function alertName(){
				 
			 alert("Your order has been placed successfully");
			 }
			 
	   } else if (Msg == "empty")
	{
		 function alertName(){
		 alert("Sorry your cart is empty");
		 }
	} 
	    
	 var Msg ='<%=request.getAttribute("contact")%>';
	    if (Msg == "contact") {
	 function alertName(){
	 alert("Thank you for contacting us");
	 } 
	 }
	    
	    var Msg ='<%=request.getAttribute("address")%>';
	    if (Msg == "address") {
	 function alertName(){
	 alert("Address updated successfully");
	 } 
	 }  
   
</script> 
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <ul class="nav navbar-nav">
		    <spring:url value="/user/home" var="homeURL"></spring:url>
		    <li><a href="${homeURL}">Home</a></li>
		    
		    <spring:url value="/user/address" var="addrURL"></spring:url>
		   	<li><a href="${addrURL}" style="float:right">Address</a></li>
		   	
		   	<spring:url value="/user/viewcart" var="cartURL"></spring:url>
			<li><a href="${cartURL}" style="float:right">View Cart</a></li>
			
			<spring:url value="/user/logout" var="logURL"></spring:url>
		    <li><a href="${logURL}" style="float:right">Log out</a></li> 
     </ul>
    </div>
</nav>

<style>
	.glyphicon { margin-right:5px; }
	.thumbnail
	{
	    margin-bottom: 20px;
	    padding: 0px;
	    -webkit-border-radius: 0px;
	    -moz-border-radius: 0px;
	    border-radius: 0px;
	}
	
	.item.list-group-item
	{
	    float: none;
	    width: 100%;
	    background-color: #fff;
	    margin-bottom: 10px;
	}
	.item.list-group-item:nth-of-type(odd):hover,.item.list-group-item:hover
	{
	    background: #428bca;
	}
	
	.item.list-group-item .list-group-image
	{
	    margin-right: 10px;
	}
	.item.list-group-item .thumbnail
	{
	    margin-bottom: 0px;
	}
	.item.list-group-item .caption
	{
	    padding: 9px 9px 0px 9px;
	}
	.item.list-group-item:nth-of-type(odd)
	{
	    background: #eeeeee;
	}
	
	.item.list-group-item:before, .item.list-group-item:after
	{
	    display: table;
	    content: " ";
	}
	
	.item.list-group-item img
	{
	    float: left;
	}
	.item.list-group-item:after
	{
	    clear: both;
	}
	.list-group-item-text
	{
	    margin: 0 0 11px;
	}
</style>

<div class="container">
    
<div id="products" class="row list-group"> 
    <c:forEach items="${listProduct}" var="prod">   
    
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
                         <spring:url value="/user/product/${prod.productId}" var="prodURL" />
                            <a class="btn btn-primary" href="${prodURL}">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         
     </c:forEach>
   </div>
</div>


</body>
<script type="text/javascript"> window.onload = alertName; </script>
</html>