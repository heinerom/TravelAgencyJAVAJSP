package myServlet;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/*  Invoice Class generates, a dynamic invoice for customers on booking a 
 * package, first it will create a booking record in booking table, then 
 * dynamically will bookingdetails record from three tables(customers,packages,bookings)
 * and then get the dynamic invoice from three tables(customers, bookings and booking details)
 * 
 * Author: Muhammad Islam
 * Date: Apr 2019
 * 
 * 
 * */
public class Invoice {
	//Declare instance variables
	int BookingId;
	public String TripStart;
	public String TripEnd;
	String Destination;
	double BasePrice;
	double AgencyComm;
	double SuppId;
	public String Ex;
	//Define constructor
	public Invoice() {}
	
	
	//It will return me the recent booking id for a specific user/customer
	public int getBookingId(int bookingid) {
		int Bid=0;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con=DriverManager.getConnection(
	                 "jdbc:mysql://localhost:3306/travelexperts","root","");
	            
	    PreparedStatement ps=con.prepareStatement(    
	    "SELECT MAX(BookingId) FROM bookings where CustomerId=?");    
	    ps.setInt(1,bookingid);    
	              
	    ResultSet rs=ps.executeQuery();    
	    while(rs.next()) {
	    	Bid=rs.getInt(1);
	    	BookingId=rs.getInt(1);
	    	
	    }
	         con.close();   
	    }catch(Exception e){
	    	this.Ex=e+"";
	    	}    
		
		
		
		return Bid;
		
		
	}
	//Based the on the package chose by the customer it returns me the specifi
	//package info
	public void getPackagInfo(int PkgId) {
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con=DriverManager.getConnection(
	                 "jdbc:mysql://localhost:3306/travelexperts","root","");
	            
	    PreparedStatement ps=con.prepareStatement("SELECT * FROM Packages where PackageId=?");    
	    ps.setInt(1,PkgId);    
	              
	    ResultSet rs=ps.executeQuery();    
	    while(rs.next()) {
	    	
	    	TripStart=rs.getString(3);
	    	TripEnd=rs.getString(4);
	    	Destination=rs.getString(5);
	    	BasePrice=rs.getDouble(6);
	    	AgencyComm=rs.getDouble(7);
	    	
	    	
	    }
	         con.close();   
	    }catch(Exception e){
	    	this.Ex=e+"";
	    	}    
            	
            	
		
		
		
		
	}
	
	
//Insert data into bookingdetails based on a specific package choosen
	public boolean addBookingDetails()
	{
		boolean pkgDetailadded=false;
		int updateQuery=0;
		
		try
        {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con=DriverManager.getConnection(
	                 "jdbc:mysql://localhost:3306/travelexperts","root","");
	            
	    PreparedStatement preparedStmt=con.prepareStatement(    
	    "INSERT INTO bookingdetails(TripStart,TripEnd,Destination,BasePrice,AgencyCommission"
	    + ",BookingId) values(?,?,?,?,?,?)");    
	    preparedStmt.setString(1, TripStart);
        preparedStmt.setString(2, TripEnd);
        preparedStmt.setString(3,Destination);
        preparedStmt.setDouble(4,BasePrice);
        preparedStmt.setDouble(5,AgencyComm);
        preparedStmt.setInt(6,BookingId);
                   
            
            updateQuery= preparedStmt.executeUpdate();
            if(updateQuery!=0) 
            {
            	pkgDetailadded=true;
            }
        }
		catch(Exception ex)
		{
			Ex=ex+"";
		}
		
		
		
		return pkgDetailadded;
		
	}
	
	//Convert date format
	 public  String  getDate(Date date){

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        String strDate = sdf.format(date);
	        return strDate;
	    }
}
