<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="images/bg1.jpg">
<script type="text/javascript">

  function checkForm(form)
  {
    
    if(form.Password.value != "" && form.Password.value == form.rePassword.value) {
      if(form.Password.value.length < 6) {
        alert("Error: Password must contain at least six characters!");
        form.pwd1.focus();
        return false;
      }
      
      re = /[0-9]/;
      if(!re.test(form.Password.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.pwd1.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.Password.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.pwd1.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.Password.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.Password.focus();
        return false;
      }
      re=/[$@$!%*#?&]/;
      if(!re.test(form.Password.value)) {
          alert("Error: password must contain at least one uppercase letter ($@$!%*#?&)!");
          form.Password.focus();
          return false;
        }
    } else {
      alert("Error: Mismatch in password!");
      form.Password.focus();
      return false;
    }

    alert("You entered a valid password: " + form.Password.value);
    return true;
  }

</script>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Furniture Mart</a>
    </div>
   </div>
</nav>

<p> Create your account: </p>
	<spring:url value="/user/savedetails" var="signURL" />
	<form:form class="form-horizontal border border-success"   modelAttribute="usersignform" method="post" action="${signURL}" onsubmit="return checkForm(this);" >
               <div class="form-group">
			      <label class="control-label col-sm-2" for="firstName">First Name: </label>
	  			  <div class="col-sm-3">
				        <form:input type="text" class="form-control" path="firstName"/><br>
				   </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="LastName">Last Name: </label>
	  			  <div class="col-sm-3">
				        <form:input type="text" class="form-control" path="lastName"/><br>
				   </div>
			    </div>
			    <div class="form-group">
			     <label class="control-label col-sm-2" for="Gender">Gender: </label>
	  			  <div class="col-sm-4">
	  			  		 <div class="col-sm-4">
				        <form:radiobutton path = "gender" value = "M" label = "Male" />
				        </div>
				        <div class="col-sm-4">
                        <form:radiobutton path = "gender" value = "F" label = "Female" /> 
						</div>
				   </div>
			    </div><br>
			    <div class="form-group">
			     <label class="control-label col-sm-2" for="LastName">Date of Birth: </label>
	  			  <div class="col-sm-3">
				        <form:input type="date" class="form-control" path="DOB"/><br>
				   </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="LastName">Email: </label>
	  			  <div class="col-sm-3">
				        <form:input type="email" class="form-control" path="email"/><br>
				   </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="LastName">Phone number: </label>
	  			  <div class="col-sm-3">
				        <form:input type="number" class="form-control" path="phonenumber"/><br>
				   </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="LastName">Password: </label>
	  			  <div class="col-sm-3">
				        <form:input type="text" class="form-control" path="password" onkeyup="CheckPasswordStrength(this.value)"/><br>
						<span id="password_strength"></span>			   
				   </div>
			    </div>
	    
		
		<script type="text/javascript">
		    function CheckPasswordStrength(password) {
		        var password_strength = document.getElementById("password_strength");
		 
		        //TextBox left blank.
		        if (password.length == 0) {
		            password_strength.innerHTML = "";
		            return;
		        }
		 
		        //Regular Expressions.
		        var regex = new Array();
		        regex.push("[A-Z]"); //Uppercase Alphabet.
		        regex.push("[a-z]"); //Lowercase Alphabet.
		        regex.push("[0-9]"); //Digit.
		        regex.push("[$@$!%*#?&]"); //Special Character.
		 
		        var passed = 0;
		 
		        //Validate for each Regular Expression.
		        for (var i = 0; i < regex.length; i++) {
		            if (new RegExp(regex[i]).test(password)) {
		                passed++;
		            }
		        }
		 
		        //Validate for length of Password.
		        if (passed > 2 && password.length > 6) {
		            passed++;
		        }
		 
		        //Display status.
		        var color = "";
		        var strength = "";
		        switch (passed) {
		            case 0:
		            case 1:
		                strength = "Weak";
		                color = "red";
		                break;
		            case 2:
		                strength = "Good";
		                color = "darkorange";
		                break;
		            case 3:
		            case 4:
		                strength = "Strong";
		                color = "green";
		                break;
		            case 5:
		                strength = "Very Strong";
		                color = "darkgreen";
		                break;
		        }
		        password_strength.innerHTML = strength;
		        password_strength.style.color = color;
		    }
		</script>
		 		
			      <div class="col-sm-offset-2 col-sm-10">
			        <input type="submit"  value="Sign up" class="btn btn-default">
			      </div>
			    </div> 
</form:form>
</div>

</body>
</html>