<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="myServlet.*" %>
    <%@ page import="java.util.ArrayList" %>
    
    <!-- 
    	Previous packages page
    	Author: Muhammad Islam
    	Date: April 2019     -->
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
 <script src="assets/bootstrap/js/bootstrap.min.js"></script> 
 <script src="assets/jquery.js"></script> 



<title>Insert title here</title>
</head>
<body>
<%
int CustId=(int)session.getAttribute("custId");

try
{
	int i=0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/travelexperts","root","");
    PreparedStatement pstmt=con.prepareStatement("SELECT BookingId FROM bookings WHERE CustomerId =?");
    pstmt.setInt(1,CustId);
    ResultSet rs=pstmt.executeQuery();
    while(rs.next()){
	i++;
	
			}
con.close();
if(i>0){
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

<%
/*
packageController myPkg=new packageController();
ArrayList<Packages> pkgList=new ArrayList<Packages>();
//pkgList=myPkg.getPackage();


for(int i=0; i<myPkg.getPackage().size(); i++){
	
	out.println((packageController)myPkg.getPackage().get(i));
	out.println("hi");
}
//out.println(myPkg.getPackage());
*/
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
                // agentObj.setAgentId(rs.getInt(1));
                // System.out.println(rs.getInt(1)+"  "+rs.getString(2));
            	%>
            	
                <div class="container">
	<div class="row">
		<div class="col-2"></div>
			<div class="col-8">
				<div class="card" style="width: 100%; height:18rem; margin-top:200px;">
  <img src="assets/images/<%= i%>.jpg" class="card-img-top" alt="...">
  					<div class="card-body">
    <h5 class="card-title"><%= rs.getString(2) %><a href="getSelectedPackage.jsp?pkgId=<%= rs.getString(1)%>" style="margin-left:10px;">Click Here to Book</a></h5>
    
                <p class="card-text"><em>Package Details: </em><strong> <%= rs.getString(5)%> </strong><br>
                <em>Starting Date:&nbsp; </em><strong> <%=rs.getDate(3)%></strong> <em>Ending Date: &nbsp;</em><strong> <%=rs.getDate(4)%></strong><br>
                <em>Package Base Price: </em><strong> <%=rs.getDouble(6) %></strong> <br>
                <em>Agency Commission: </em><strong> <%=rs.getDouble(7) %></strong>
                
                </p>
                
             
    
  					</div>
				</div>
			</div>
			<div class="col-2"></div>
	</div>

</div>
                
                <%
           // out.println(rs.getString(2));
            	//out.println(rs.getDate(3));
            //	out.println(rs.getDate(4));
            	//out.println(rs.getString(5));
            	//out.println(rs.getDouble(6));
            	//out.println(rs.getDouble(7));
            //	out.println("<br><br>");
            	
            	
                //agentObjList.add(rs.getInt(1)+"");
            }
            con.close();

        }
        //Define catch block for runtime exception
        catch(Exception e)
        {
            out.println(e);
        }
		

%>
<!--  
<div class="container">
	<div class="row">
		<div class="col-2"></div>
			<div class="col-8">
				<div class="card" style="width: 100%; height:18rem;">
  <img src="assets/images/4.jpg" class="card-img-top" alt="...">
  					<div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  					</div>
				</div>
			</div>
			<div class="col-2"></div>
	</div>

</div>
-->
</body>
</html>