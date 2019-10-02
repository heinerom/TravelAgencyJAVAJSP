<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.* "%>
    <!--
    	This page displays the invoices details and a print option
    	
    	Author 1: Muhammad Islam
    	Author 2: Sheila Zhao
    	Author 3: Eugenia Chiu
    	Date: April 2019
      -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="assets/images/world.png">
 	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
 	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/default.css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/styles.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
 	<script src="assets/bootstrap/js/bootstrap.min.js"></script> 
	 <script src="assets/jquery.js"></script> 
<title>Invoice</title>
</head>
<body>

	   <!-- get the invoice details from the database -->
					<% 
					int packageId=Integer.parseInt(request.getParameter("BookingId"));

		try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts","root","");
            PreparedStatement pstmt=con.prepareStatement("select bookings.BookingId,bookings.TravelerCount,customers.CustFirstName,customers.CustLastName,"+
                    "customers.CustHomePhone,customers.CustEmail,bookingdetails.Destination,bookingdetails.TripStart,"+
                    "bookingdetails.TripEnd,bookingdetails.BasePrice,bookingdetails.AgencyCommission "+
                    "from customers join bookings on customers.customerId=bookings.customerId"+
                    " join bookingdetails on bookings.bookingid=bookingdetails.bookingid WHERE  bookingdetails.BookingId=?");
           pstmt.setInt(1,packageId);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
            	
            	              
		%>
		
		
		
		
		 <div class="icon-bar">
      <a class="active" href="customerLanding.jsp"><i class="fas fa-arrow-left"></i></a>
    </div>
       
		<div class="invoice-wrap">       
			<div class="login-html">
			  
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked>
                <label for="tab-1" class="tab">Invoice</label>
  
				<div id="invoice" class="login-form"><br/>
				
						<div class="group">                        
                            <label for="pass" class="label">Booking Number</label>
                            <text class="info" readonly><%=rs.getInt(1) %></text>
                        </div>
                        <div class="group">
                            <label for="user" class="label">Number of Travellers</label>
                            <text class="info" readonly><%=rs.getInt(2) %></text>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">First Name</label>
                            <text class="info" readonly> <%=rs.getString(3) %></text>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Last Name</label>
                            <text class="info" readonly><%=rs.getString(4) %></text>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Phone number</label>
                            <text class="info" readonly><%=rs.getString(5) %></text>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Email</label>
                            <text class="info" readonly><%=rs.getString(6) %></text>
                        </div>
						<div class="group">
                            <label for="pass" class="label">Description</label>
                            <text class="info" readonly><%=rs.getString(7) %></text>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Start Date</label>
                            <text class="info" readonly><%=rs.getDate(8) %></text>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">End Date</label>
                            <text class="info" readonly><%=rs.getDate(9) %></text>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Base Price</label>
                            <text class="info" readonly>$ <%=rs.getDouble(10) %></text>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Agency Commission</label>
                            <text class="info" readonly>$ <%=rs.getDouble(11) %></text>
                        </div>
                         <div class="group">
                            <label for="pass" class="label">Total Amount</label>
                            <text class="info" readonly>$ <% out.println(rs.getInt(2)*(rs.getDouble(10)+rs.getDouble(11))); %></text>
                        </div>
                            <div class="group">
							<input onclick="printForm()" type="submit" class="button" value="Print">
                        </div>				
                </div>
                <script>
                        function printForm() {
                          window.print();
                        }
                        </script>
			</div>
		</div>
		
		

			
	<%
		}
            con.close();

        }
        //Define catch block for runtime exception
        catch(Exception e)
        {
           // System.out.println(e);
        }

					%>	   


</body>
</html>