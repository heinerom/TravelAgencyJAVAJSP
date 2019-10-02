<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <!--  
    	This page displays the package details based on package customer picked
    	And also to confirm the number of travellers for booking 
    	
    	Author: Muhammad Islam
    	Date: April 2019
    -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
 <script src="assets/bootstrap/js/bootstrap.min.js"></script> 
 <script src="assets/jquery.js"></script> 
</head>
<body>
<b>Selected Package: <%=request.getParameter("pkgId") %></b>
<%
int CustId=(int)session.getAttribute("custId");
String cFName=(String)session.getAttribute("custFirstName");
String cLName=(String)session.getAttribute("custLastName");



if(CustId==0){
	%>
<div class="container">
	<div class="row">
		<div class="col-12">
			<em>Log in or sign up to complete the form and a Travel Experts travel agent will contact you within 24 hours.</em>
		</div>
			<div class=col-6>
				<div class="card" style="width:100%;">
 					 <div class="card-body">
   						 <strong>I already have Travel Experts login</strong>
    						<a href="SignIn.jsp" class="btn btn-primary" style="width:100%;">Sign In</a>
  					</div>
				</div>
			</div>
			
			<div class=col-6>
				<div class="card" style="width:100%;">
 					 <div class="card-body">
   						 <strong>I still need to create an account</strong>
    						<a href="SignUp.jsp" class="btn btn-primary" style="width:100%;">Sign Up</a>
  					</div>
				</div>
			</div>
	</div>
</div>
	
	
	<%
	//out.println("<h3>Please sign in to book a Package</h3>");
	//response.sendRedirect("loginForm.html");
	//out.println("<a href=loginForm.html> Clcik here to try again</a>");
}
else{
	int pkgId=Integer.parseInt(request.getParameter("pkgId"));
	session.setAttribute("packageId",pkgId);
	int PackageId=(int)session.getAttribute("packageId");
//out.println("Name"+objDemo.getName("islam")+"Cust Id"+CustId);
//response.sendRedirect("Packages.jsp");
//out.println("Thanks "+CustId+" "+cFName+" "+cLName+" Package Id "+PackageId);
%>

<div class="jumbotron">
  <h1 class="display-4">Hello,  <%=cFName %></h1>
  <div class="alert alert-primary" role="alert">
 	Your's Package Details!
</div>
<%
try
{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/travelexperts","root","");
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("SELECT * FROM packages where PackageId ='"+pkgId+"'");
    while(rs.next()) {
    	%>
    	
    	
  
    	
    	
    	<div class="row mx-md-n5">
  		<div class="col px-md-5"><div class="p-3 border bg-light">Package: &nbsp;<%=rs.getString(2) %> </div></div>
 		 <div class="col px-md-5"><div class="p-3 border bg-light">Details:<%=rs.getString(5) %></div></div>
      
    	</div>
    	
    	<div class="row mx-md-n5">
    	 <div class="col px-md-5"><div class="p-3 border bg-light">Start Date:&nbsp;<%=rs.getDate(3) %></div></div>
   		<div class="col px-md-5"><div class="p-3 border bg-light">End Date:&nbsp;<%=rs.getDate(4) %></div></div>
    	</div>
    	
    	<div class="row mx-md-n5">
    	<div class="col px-md-5"><div class="p-3 border bg-light">Base Price:&nbsp;$<%=+rs.getDouble(6) %></div></div>
    	<div class="col px-md-5"><div class="p-3 border bg-light">Agency Commission: &nbsp;$<%=+rs.getDouble(7) %></div></div>
    	</div>
    	
    	<%
    	
    }
    con.close();

}
//Define catch block for runtime exception
catch(Exception e)
{
    out.println(e);
}


%>

  <hr class="my-4">
  <p>Please provide the following information to confirm your booking!</p>
 
  
  	<form name="booking" method="post" action="confirmBooking.jsp" target="print_popup" onsubmit="window.open('about:blank','print_popup','width=500,height=700');">
   	 <strong>Number of Travelers</strong>
  		 <div class="form-group">
  			<input type="number" style="width:50%;" class="form-control" name="NumberofTravelers" id="NumberofTravelers" placeholder="Number of Travelers">
  	  	</div>
  	  			<div class="form-group">
  	  			 <label for="TripType">Trip Type</label>
  	  				<select class="form-control" id="TripType" name="TripType" style="width:50%;">
      					<option value="B">Business</option>
     					 <option value="G">Group</option>
      					<option value="L">Leisure</option>
     				</select>
  				</div>
  <div class="form-group">
  	<label for="ClassType">Class Type</label>
  		<select class="form-control" id="ClassType" name="ClassType" style="width:50%;">
      					<option value="BSN">Business Class</option>
     					 <option value="DLX">Delux</option>
      					<option value="ECN">Economy</option>
      					<option value="FST">First Class</option>
     				</select>
  </div>
  
   <div class="form-group">
  	<label for="ClassType">Supplier</label>
  		<select class="form-control" id="Supplier" name="Supplier" style="width:50%;">
      				<option>Choose Supplier</option>
      				
      							   
					<% 

		try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT products_suppliers.SupplierId,suppliers.SupName FROM "+
                    "products_suppliers JOIN suppliers ON products_suppliers.SupplierId=suppliers.SupplierId WHERE products_suppliers.ProductId=1");
            while(rs.next()){
                
		%>

			
			<option value=<%= rs.getInt(1)%>><%= rs.getString(2)%></option>
<%
}
            con.close();

        }
        //Define catch block for runtime exception
        catch(Exception e)
        {
           // System.out.println(e);
           out.println(e);
        }

					%>	   
      				
      				
     				</select>
  </div>
  
  
  <button type="submit" class="btn btn-primary" onclick="window.location.href='customerLanding.jsp#book'">Submit</button>
 	 </form>
  
  
 
</div>




<%


}

%>
</body>
</html>