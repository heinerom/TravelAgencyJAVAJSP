<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="myServlet.*" %>
<!-- 
	 This page gets customer username and password, and authenticate and initialize 
	 the session variables.
	 
	 Author: Muhammad Islam
	 Date: Apr 2019
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String userName=request.getParameter("custName");
String userPassword=request.getParameter("custPass");
int customerId=0;
String CustFirstName;
String CustLastName;
Users objUser=new Users();
if(objUser.authenticateUser(userName,userPassword))
{
	//out.println("Found");
	objUser.getCustomerInfo(userName, userPassword);
	customerId=objUser.getCustomerId();
	CustFirstName=objUser.getCustFirsName();
	CustLastName=objUser.getCustLastName();
	session.setAttribute("custId",customerId);
	session.setAttribute("custFirstName",CustFirstName);
	session.setAttribute("custLastName",CustLastName);
	//response.sendRedirect("testdemo.jsp");
	//out.println("Cust id"+customerId);
	
}
response.sendRedirect("testdemo.jsp");

/*
else{
	
	out.println("<h3>Invalied User Name or Password</h3>");
	//response.sendRedirect("register.jsp");
	out.println("<a href=loginForm.html> Clcik here to try again</a>");
}
*/
%>


</body>
</html>