<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
    <%@ page import="myServlet.*" %>
    <%@ page import="java.util.ArrayList" %>
    
    <!--
    	Customer landing page after login which displays all packages and invoices
    	
    	Author 1: Sheila Zhao
    	Author 2: Muhammad Islam
    	Author 3: Eugenia Chiu
    	
    	Date: April 2019
    
      -->
<!DOCTYPE html>
<html>
<head>
    <title>Travel Experts</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
        // When the user scrolls down 20px from the top of the document, show the button
        
        window.onscroll = function() {scrollFunction()};

        function scrollFunction() {
          if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            document.getElementById("myBtn").style.display = "block";
          } else {
            document.getElementById("myBtn").style.display = "none";
          }
        }

        // When the user clicks on the button, scroll to the top of the document
        function topFunction() {
          document.body.scrollTop = 0;
          document.documentElement.scrollTop = 0;
        }
    </script>

    <!-- css files -->
    <link rel="icon" href="assets/images/world.png">
    <link href="assets/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
    <link href="assets/bootstrap/css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
    <!-- //css files -->
 	<script src="assets/bootstrap/js/bootstrap.min.js"></script> 
 	<script src="assets/jquery.js"></script> 

    <!-- google fonts -->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <!-- //google fonts -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

</head>
    <body>
    <!-- //header -->
    <header>
        <div class="container">
            <!-- top header -->
            <section class="row top_header pt-3">
                <div class="col-lg-6 buttons ml-auto">
                    <ul class="social mt-lg-0 mt-3">
                        <li class="mr-1"><a href="#"><span class=" "></span></a></li>
                        <li class="mr-1"><a href="#"><span class=" "></span></a></li>
                        <li class="mr-1"><a href="#"><span class=" "></span></a></li>
                        <li class="mr-1"><a href="#"><span class=" "></span></a></li>

                    </ul>
                </div>
            </section>
            <!-- top header -->
            <!-- nav -->
            <nav class="pt-2 d-lg-flex">
                <div id="logo">
                    <h1> <a href="index.jsp"><span class="fa fa-globe"></span>Travel Experts</a></h1>
                </div>
                <label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
                <input type="checkbox" id="drop" />
                <ul class="menu mt-md-2 ml-auto">
                    <li class="mr-lg-4 mr-2 active"><a href="index.jsp">Home</a></li>                   
                    <li class="mr-lg-4 mr-2"><a href="#pricing">Packages</a></li>
                    <li class="mr-lg-4 mr-2"><a href="#book">View Bookings</a></li>
                    <li class="mr-lg-4 mr-2"><a href="#contact">Contact Us</a></li>
                    <li class=""><a href="index.jsp">Sign Out</a></li>
                </ul>
            </nav>
            <!-- //nav -->
        </div>
    </header>
    <!-- //header -->

        <!-- banner -->
        <section class="banner" id="home2">
            <div class="container">
                <div class="banner-text">
                    <div class="slider-info">
                        <div class="w3layouts-text mt-lg-5">
                            <h2>Welcome to your Travel Account</h2>
                            <p class="mt-3"> </p>
                        </div>
                    </div>
                <!-- To bottom button-->
                <div class="thim-click-to-bottom mt-sm-5 mt-3 pt-lg-5">
                    <div class="rotate">
                        <a href="#choose" class="scroll">
                            <span class="fa fa-angle-double-down"></span>
                        </a>
                    </div>
                </div>
                <!-- //To bottom button-->
                </div>
            </div>
        </section>
        <!-- //banner -->

            <!-- packages -->
            <section class="choose py-5" id="choose">
            </section>
    <section class="pricing py-5" id="pricing">
        <div class="container py-md-5">
            <h3 class="heading text-center mb-5"> Travel <span>Packages</span></h3>
            <div class="row pricing-grids">
            <!-- display all the packages from the database -->
            <%
int i=0;
try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM packages order by PackageId");
            while(rs.next()) {
            	i++;

%>
                <div class="col-lg-6 col-md-6 price mb-md-0 mb-sm-5 mb-4">
                    <div class="shadow">
                        <div class="pricing-grid mb-md-0 mb-sm-5 mb-4">
                            <div class="head">
                                <h3><%= rs.getString(2) %> </h3>
                            </div>
                            <h4>$<%=rs.getDouble(6) %></h4>
                            <p class="py-3 text-center"><%= rs.getString(5)%></p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Start Date:  <%=rs.getDate(3)%></p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  End Date: <%=rs.getDate(4)%></p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Agency Commission Fee: $ <%=rs.getDouble(7) %></p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  06 days Travel Trip</p>
                        </div>
                    </div>
                    <a href="getSelectedPackage.jsp?pkgId=<%= rs.getString(1)%>">Select Plan <span class="fa fa-angle-double-right"></span></a>
                	 <br/><br/>
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
            </div>
        </div>

    </section>
    <!-- packages -->

        <!--/Invoices-->
        <section class="banner-bottom-w3layouts py-md-5 py-4" id="book" >
            <div class="container">
                <h3 class="heading text-center mb-4">Your <span>Current Bookings</span></h3>
                <div class="inner-sec-w3ls py-md-5 py-4">
                    <!--/services-grids-->
                    <div class="row blog-sec">
                        
                        <div class="col-lg-8 col-md-6 about-in blog-grid-info text-left mt-md-0 mt-5" style="width: 60%; margin: 0px auto;">
                            <div class="card img">
                                <div class="card-body img">
                                    <div class="blog-des mt-3">
        <!-- display the combobox for invoice to print -->                            
                                    
                                      <%
int CustId=(int)session.getAttribute("custId");

try
{
	int j=0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/travelexperts","root","");
    PreparedStatement pstmt=con.prepareStatement("SELECT BookingId FROM bookings WHERE CustomerId =?");
    pstmt.setInt(1,CustId);
    ResultSet rs=pstmt.executeQuery();
    while(rs.next()){
	j++;
	
			}
con.close();
if(j>0){
	%>
	<div class="row mx-md-n5">
  <div class="col px-md-5"><div class="p-3 border bg-light">
  
  <form name="invoiceForm" action="invoice.jsp" method="post">

  <div class="form-group">
   <label for="BookingId">Choose your Booking Id to show Invoice</label>
    <select  class="form-control" id="BookingId" name="BookingId" style="width:50%">
      
      <%
     
      try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection pcon=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts","root","");
            PreparedStatement pkstmt=pcon.prepareStatement("SELECT BookingId FROM bookings WHERE CustomerId =?");
            pkstmt.setInt(1,CustId);
            ResultSet rsp=pkstmt.executeQuery();
            while(rsp.next()){
                
		%>

			
			<option value=<%= rsp.getInt(1)%>><%= rsp.getInt(1)%></option>
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
  
  </div></div>
 
</div>
	
	
	<%
	
}
}
//Define catch block for runtime exception
catch(Exception e)
{
// System.out.println(e);
out.println(e);
}


%>                                        
                                        
                                        
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>
        <!--//Blog-Posts-->
            <!-- contact -->
    <section class="contact py-5" id="contact">
        <div class="container py-md-3">
            <h3 class="heading text-center mb-4">Contact Us</h3>
            <div class="row contact-w3layouts">
                <div class="col-lg-5 contact-right">
                    <form action="#" method="post">
                        <input type="text" name="Name" placeholder="Enter Your Name" required="">
                        <input type="email" class="email" name="Email" placeholder="Enter Your Email" required="">
                        <input type="text" name="Phone no" placeholder="Enter Your Phone Number" required="">
                        <textarea name="Message" placeholder="Add Your Message" required=""></textarea>
                        <button class="btn submit">Submit </button>
                    </form>
                </div>
                <div class="col-lg-7 contact-middle mt-lg-0 mt-4">
                    <div class="location-w3layouts-map">
                        <iframe src="" allowfullscreen></iframe>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <!-- //contact -->
         <button onclick="topFunction()" id="myBtn" title="Go to top"><i class="fa fa-chevron-up"></i></button>
          
        <script src="" async defer></script>
    </body>
</html>