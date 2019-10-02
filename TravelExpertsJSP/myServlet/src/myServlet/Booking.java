package myServlet;
import java.sql.*;
import java.util.Date;



import java.text.SimpleDateFormat;

/*Booking class defines instance variables for all the fields of packages table
 * We can book a package using this class
 * Author: Muhammad Islam
 * Date: Apr 2019
 * 
 * 
 * */
public class Booking {
	//Instance variables
	int BookingId;
	String BookingDate;
	String BookingNo;
	int TravelerCount;
	int CustomerId;
	String TripType;
	int PackageId;
	public String EX;
	//Constructor
	public Booking(int travlerCount,int customerId,String tripType,int packageId)
	{
		TravelerCount=travlerCount;
		CustomerId=customerId;
		TripType=tripType;
		PackageId=packageId;
		Date date=new Date();
		BookingDate=getDate(date);
		
	}
	//Method to create a booking for a package
	public boolean addBooking()
	{
		boolean bookingadded=false;
		int updateQuery=0;
		
		try
        {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con=DriverManager.getConnection(
	                 "jdbc:mysql://localhost:3306/travelexperts","root","");
	            
	    PreparedStatement preparedStmt=con.prepareStatement(    
	    "insert into bookings(BookingDate,TravelerCount,CustomerId,TripTypeId,PackageId) values(?,?,?,?,?)");    
	    preparedStmt.setString(1,BookingDate);
        preparedStmt.setInt(2,TravelerCount);
        preparedStmt.setInt(3,CustomerId);
        preparedStmt.setString(4,TripType);
        preparedStmt.setInt(5, PackageId);
        
	            
            
            updateQuery= preparedStmt.executeUpdate();
            if(updateQuery!=0) 
            {
         	   bookingadded=true;
            }
        }
		catch(Exception ex)
		{
			EX=ex+"";
		}
		
		
		
		
		
		
		return bookingadded;
	}
	
	//To convert the date format
	 public  String  getDate(Date date){

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        String strDate = sdf.format(date);
	        return strDate;
	    }
	
	

}
