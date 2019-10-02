<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="myServlet.*" %>
      <%@ page import="java.sql.*" %>
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

<%

int CustId=(int)session.getAttribute("custId");
int PackageId=(int)session.getAttribute("packageId");
int numberOfTravelers=Integer.parseInt(request.getParameter("NumberofTravelers"));
String TripType=request.getParameter("TripType");
String ClassType=request.getParameter("ClassType");
String message="";

/*
out.println("Customer id "+CustId);
out.println("Package Id "+PackageId);
out.println("Number of Trarvelers"+numberOfTravelers);
out.println("Trip Type"+TripType);
out.println("Class Type"+ClassType);
*/

Booking objBooking=new Booking(numberOfTravelers,CustId,TripType,PackageId);
if(objBooking.addBooking())
{
	Invoice invoice=new Invoice();
	int BookingId=invoice.getBookingId(CustId);
	invoice.getPackagInfo(PackageId);
	if(invoice.addBookingDetails()){
		//out.println("Booking Details added");
		message=" and Booking Details Updated ";
	}
	else{
		out.println(invoice.Ex);
	}
	%>
	<div class="alert alert-success" role="alert">
	
	
  	Package Booked<%=message %> Successfully! <br/>
  	Your booking ID is: <%=BookingId %> &nbsp;<br/>
  	The start Date is <%=invoice.TripStart %>
</div>
	
	<%
}
else{
	out.println(objBooking.EX);
}
%>
<form name="invoiceForm" action="invoice.jsp" method="post">

  <div class="form-group">
   <label for="BookingId">Choose your Booking Id to show Invoice</label>
    <select  class="form-control" id="BookingId" name="BookingId" style="width:50%">
      
      <%
     
      try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts","root","");
            PreparedStatement pstmt=con.prepareStatement("SELECT BookingId FROM bookings WHERE CustomerId =?");
            pstmt.setInt(1,CustId);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                
		%>

			
			<option value=<%= rs.getInt(1)%>><%= rs.getInt(1)%></option>
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
  <button type="submit" class="btn btn-primary">Submit</button>
  </form>

<br/>
<%-- <%session.invalidate(); %>
<a href="index.jsp">Logout</a> --%>


</body>
</html>