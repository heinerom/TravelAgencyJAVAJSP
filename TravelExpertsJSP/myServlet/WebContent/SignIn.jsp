<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.* "%>
<!-- Login Page
	 Author 1: Muhammad Islam
	 Author 2: Sheila Zhao
	 Date: Apr 2019
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<link rel="icon" href="assets/images/world.png">
 <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="assets/bootstrap/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/default.css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/styles.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
 <script src="assets/bootstrap/js/bootstrap.min.js"></script> 
 <script src="assets/jquery.js"></script>            
          
<!-- Form validation -->
 <script>
$(document).ready(function(){
	  $("form").submit(function(){
		  var name=$('#custName').val();
		  var pass=$('#custPass').val();
		  if((name=='')||(pass==''))
		  {
			  if(name==''){
				  alert("Please provide Name");
				  $('#custName').focus();
				  return false;
			  }
			  else{
				  alert("Plese provide Password");
				  $('#custPass').focus();
				  return false;
			  }			  
		  }
	    
	  });
	});

</script>
 
</head>
<body>
<!-- nav button to home page -->
 <div class="icon-bar">
      <a class="active" href="index.jsp"><i class="fas fa-arrow-left"></i></a>
    </div>
    
 <!-- Login Form -->      
		<div class="login-wrap">       
			<div class="login-html">			  
				<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label class="tab">Sign In</label>
				<input id="tab-2" type="radio" name="tab" class="sign-up"><label class="tab"><a href="SignUp.jsp">Sign Up</a></label>
				<div class="login-form">
					<div class="sign-in-htm">
					<form name="formReg" method="post" action="login.jsp">

						<div class="group">
							<label for="user" class="label">Username</label>
							<input class="input" type="text" name="custName" id="custName" >
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label>
							<input class="input" type="password" id="custPass" name="custPass">
						</div>
						<div class="group">
							<input id="check" type="checkbox" class="check" checked>
							<label for="check"><span class="icon"></span> Keep me Signed in</label>
						</div>
						<div class="group">
							<input type="submit" class="button" value="Sign In" id="btnValidate" name="btnValidate">
						</div>
						<div class="hr"></div>
						<div class="foot-lnk">
							<a href="#forgot">Forgot Password?</a>
						</div>
						</form>
					</div>			
					</div>
					</div>
					</div>							

</body>
</html>