<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="myServlet.*" %>
<!--  This page verify the customer password.
	  Redirect to customer landing page if it's correct or go to sign in page.
	  
	  Author: Muhammad Islam
	  
	  Date: April 2019
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Demo objDemo=new Demo();
//String name=(String)session.getAttribute("sessname");
int CustId=(int)session.getAttribute("custId");

if(CustId==0){

	%>
	 <script type="text/javascript">
        alert('Wrong Password, Please try again');
        window.location="SignIn.jsp";
   </script><%
	
	//response.sendRedirect("SignIn.jsp");
	//out.println("<h3>Invalied User Name or Password</h3>");
	//response.sendRedirect("register.jsp");
	//out.println("<a href=SignIn.jsp> Clcik here to try again</a>");
}
else{

//out.println("Name"+objDemo.getName("islam")+"Cust Id"+CustId);
response.sendRedirect("customerLanding.jsp");

}
%>

</body>
</html>