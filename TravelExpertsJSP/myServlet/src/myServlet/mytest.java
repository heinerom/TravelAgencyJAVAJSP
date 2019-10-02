package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;

/**
 * Servlet implementation class mytest for different modules
 * Author: Muhammad Islam
 * Date: Apr, 2019
 */
@WebServlet("/mytest")
public class mytest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException  {  
		 
		// String uName=request.getParameter("t1");
		 //String uPass=request.getParameter("t2");
		 PrintWriter out = response.getWriter();  
		 String uName="Muhammad";
		 String uPass="Khan";
		  
		  out.println("<h1> First Name </h1>"+uName+"<h1> Last Name </h1>"+uPass); 
		  
		  if(validate(uName, uPass)){    
              out.println("success");  
             
           }    
           else{    
              out.println("Sorry username or password error");  
                                
           }    
                   
           out.close();    
		  
		  
		  
		  		  
       
}
	 public static boolean validate(String name,String pass){    
	        boolean status=false;    
	        try{    
	           // Class.forName("oracle.jdbc.driver.OracleDriver");  
	           // Connection con=DriverManager.getConnection(  
	                    // "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
	        	
	        	 Class.forName("com.mysql.jdbc.Driver");
	             Connection con=DriverManager.getConnection(
	                     "jdbc:mysql://localhost:3306/travelexperts","root","");
	                
	        PreparedStatement ps=con.prepareStatement(    
	        "SELECT * FROM users where userName=? and userPassword=?");    
	        ps.setString(1,name);    
	        ps.setString(2,pass);    
	                
	        ResultSet rs=ps.executeQuery();    
	        status=rs.next();    
	                    
	        }catch(Exception e){System.out.println(e);}    
	        return status;    
	        }    
	 
}