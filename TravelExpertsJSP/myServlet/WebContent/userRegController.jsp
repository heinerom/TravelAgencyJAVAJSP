<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="myServlet.*" %>
  <%@ page import="java.sql.* "%>
  <!-- This page gets customers input data and create a new customer file to database
  
  	   Author 1: Muhammad Islam
  	   Author 2: Sheila Zhao
  	   Date: April 2019 
  
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
<%
String custFirstName=request.getParameter("firstName");
String custLastName=request.getParameter("lastName");
String custAddress=request.getParameter("streetAddress");
String custCity=request.getParameter("city");
String custProv=request.getParameter("province");
String custPostal=request.getParameter("postalCode");
String custCountry=request.getParameter("country");
String custHomePhone=request.getParameter("homePhone");
String custBusPhone=request.getParameter("businessPhone");
String custEmail=request.getParameter("cEmail");
int custAgentId=Integer.parseInt(request.getParameter("agent").trim());
String custLoginId=request.getParameter("userId");
String custPass=request.getParameter("pass");

Users AddCustomerObj=new Users(custFirstName,custLastName,custAddress,custCity
		,custProv,custPostal,custCountry,custHomePhone,custBusPhone,custEmail,custAgentId
		,custLoginId,custPass);

if(AddCustomerObj.create_user()){
	%><script type="text/javascript">
        alert('Profile successfully created!');
        window.location="SignIn.jsp";
   </script><%
	response.sendRedirect("SignIn.jsp");
	
	
}
else{
	out.println(AddCustomerObj.EX);
}

%>

</body>
</html>