<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View Cart </title>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
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

<div class="container">

    
    <p> Click to continue your shopping</p>
	<br>
	<spring:url value="/user/home" var="homeURL" ></spring:url>
    <a href="${homeURL}" class="btn btn-primary"><i class="fa fa-angle-left"></i> Continue Shopping</a>
    <p> To change Quantity, Edit Quantity and Click on Update button</p>
	<table id="cart" class="table table-hover table-condensed">
 		<thead>
			<tr>
				<th style="width:50%">Product</th>
				<th style="width:10%">Price</th>
				<th style="width:8%">Quantity</th>
				<th style="width:22%" class="text-center">Subtotal</th>
				<th style="width:10%"></th>
			</tr>
		</thead>
		<tbody>
		<script>
			  var sumto=0;
			  
		  </script>
		<c:forEach items="${listBufcart}" var="prod"> 
			<tr>
				<td data-th="Product">
					<div class="row">
						<div class="col-sm-10">
								<h4 class="nomargin">${prod.productName}</h4>
								
						</div>
					</div>
				</td>
				<td data-th="Price">${prod.price}</td>
          <spring:url value="/user/updateQuantity" var="updateURL" />
               <form:form  method="POST" action="${updateURL}">
                      <td data-th="Quantity">
       					<input type="number" name="newquantity" class="form-control text-center" value="${prod.quantity}">
       				  </td>
       				  <script>
	       				  var qunatity=Number(${prod.quantity});
	       				  var price=Number(${prod.price});
	       				  var total=qunatity*price;
	       				sumto=sumto+total;
       				  </script>
                      <td data-th="Subtotal" class="text-center"><script type="text/javascript">
															        document.write(total);
															      </script>
				      </td>
      				  <td class="actions" data-th="">
                      <input type="hidden" name="newprodId" value="${prod.productId}" />
                      <input type="submit" name="submit" class="btn btn-info btn-sm" value="update" />

               </form:form>
                <spring:url value="/user/removeItem" var="delURL" />
                 <form:form  method="POST" action="${delURL}">
                 		 <input type="hidden" name="newdelprodId" value="${prod.productId}" />
						 <input type="submit" name="submit" class="btn btn-info btn-sm" value="delete " />
                 </form:form>	
				</td>
			</tr>
		 </c:forEach>
		</tbody>
		<tfoot>
			<tr class="visible-xs">
          				 <td class="text-center"><strong><script type="text/javascript">
															        document.write(sumto);
															      </script></strong>
						</td>
			</tr>
			<tr>
				<td colspan="2" class="hidden-xs"></td>
           				<td class="hidden-xs text-center"><strong><script type="text/javascript">
															        document.write(sumto);
															      </script></strong></td>
            			   <td>
            			   <spring:url value="/user/place" var="placeURL" />
            			   <a href="${placeURL}" class="btn btn-primary btn-block">Checkout 
            			   <i class="fa fa-angle-right"></i></a></td>
			</tr>
		</tfoot>
	</table>
</div>
</body>
</html>