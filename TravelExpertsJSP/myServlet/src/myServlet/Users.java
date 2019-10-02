package myServlet;
import java.io.*;
import java.sql.*;

/* Users class define instance variables for all the customers fields in 
 * customers table. Using constructor initiaze all the instance variables.
 * Authenticate the users for logs in, create users i.e customers gets all the
 * info users i.e customer needed 
 * 
 * Author: Muhammad Islam
 * Date: Apr 2019
 * 
 * 
 * */
public class Users
{
	//define instance variables
	int CustomerId;	
	 String CustFirstName;
	 String CustLastName;
	 String CustAddress;
	 String CustCity;
	 String CustProv;
	 String CustPostal;
	 String CustCountry;
	 String CustHomePhone;
	 String CustBusPhone;
	 String CustEmail;
	 int CustAgentId;
	 String customer_login_id;
	 String cust_pass;
	public String EX;
	//Parameterless constructor
	public Users() {}
	//overloaded parameterized constructor
	public Users(String firstName,String lastName,String custAddress,String custCity,
			String custProv,String custPostal,String custCountry,String custHomePhone,
			String custBusPhone,String custEmail,int AgentId,String customerLoginId,
			String custPass) 
	{
		//Initialize all the instance variables
		CustFirstName=firstName;
		CustLastName=lastName;
		CustAddress=custAddress;
		CustCity=custCity;
		CustProv=custProv;
		CustPostal=custPostal;
		CustCountry=custCountry;
		CustHomePhone=custHomePhone;
		CustBusPhone=custBusPhone;
		CustEmail=custEmail;
		CustAgentId=AgentId;
		customer_login_id=customerLoginId;
		cust_pass=custPass;
		
		
		
		
	}
	//getter functions
	public int getCustomerId()
	{
		return CustomerId;
	}
	
	public String getCustFirsName() 
	{
		return CustFirstName;
	}
	
	public String getCustLastName()
	{
		return CustLastName;
	}
	//Method to unthenticate users
	public boolean authenticateUser(String userName,String userPassword) {
		boolean found=false;
		try {
		 Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/travelexperts","root","");
            
    PreparedStatement ps=con.prepareStatement(    
    "SELECT * FROM customers where customer_login_id=? and 	cust_pass=?");    
    ps.setString(1,userName);    
    ps.setString(2,userPassword);    
            
    ResultSet rs=ps.executeQuery();    
    found=rs.next();    
         con.close();   
    }catch(Exception e){
    	
    	}    
    return found;    
    }    
	
	
		//Method to create users
	public boolean create_user() 
	{
		boolean created=false;
		int updateQuery=0;	
		
		try
        {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con=DriverManager.getConnection(
	                 "jdbc:mysql://localhost:3306/travelexperts","root","");
	            
	    PreparedStatement preparedStmt=con.prepareStatement(    
	    "insert into customers(CustFirstName,CustLastName,CustAddress,CustCity,CustProv,"
	    + "CustPostal,CustCountry,CustHomePhone,CustBusPhone,CustEmail,AgentId,"
	    + "customer_login_id,cust_pass) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");    
	    preparedStmt.setString(1, CustFirstName);
        preparedStmt.setString(2, CustLastName);
        preparedStmt.setString(3,CustAddress);
        preparedStmt.setString(4,CustCity);
        preparedStmt.setString(5, CustProv);
        preparedStmt.setString(6,CustPostal);
        preparedStmt.setString(7,CustCountry);
        preparedStmt.setString(8,CustHomePhone);
        preparedStmt.setString(9,CustBusPhone);
        preparedStmt.setString(10,CustEmail);
        preparedStmt.setInt(11, CustAgentId);
        preparedStmt.setString(12,customer_login_id);
        preparedStmt.setString(13,cust_pass);
	            
            
            updateQuery= preparedStmt.executeUpdate();
            if(updateQuery!=0) 
            {
         	   created=true;
            }
        }
		catch(Exception ex)
		{
			EX=ex+"";
		}
		
		
		return created;
		
		
	}
	//Method to get customers info based on the argument provided
	public void getCustomerInfo(String userName,String userPassword) {
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con=DriverManager.getConnection(
	                 "jdbc:mysql://localhost:3306/travelexperts","root","");
	            
	    PreparedStatement ps=con.prepareStatement(    
	    "SELECT CustomerId,CustFirstName,CustLastName FROM customers where customer_login_id=? and 	cust_pass=?");    
	    ps.setString(1,userName);    
	    ps.setString(2,userPassword);    
	            
	    ResultSet rs=ps.executeQuery();    
	    while(rs.next()) {
	    	CustomerId=rs.getInt(1);
	    	CustFirstName=rs.getString(2);
	    	CustLastName=rs.getString(3);
	    	
	    }
	         con.close();   
	    }catch(Exception e){
	    	
	    	}    		
	}
}
