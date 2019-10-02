package myServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  




/**
 * Servlet implementation class login
 * Author: Muhammad Islam
 * Date: Apr, 2019
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
	 public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	         response.setContentType("text/html");    
	             
	            ObjectOutputStream out=new ObjectOutputStream(response.getOutputStream());  
	                   
	            String n=request.getParameter("name");    
	            String p=request.getParameter("pass");  
	           // String n="Muhammad";
	           // String p="Khan";
	            //System.out.println(n);  
	           // System.out.println(p);  
	                    PrintWriter output= response.getWriter();
	                    output.write(n);
	                    output.write(p);
	            if(validate(n, p)){    
	               out.writeObject("success");  
	              
	            }    
	            else{    
	               out.writeObject("Sorry username or password error");  
	                                 
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
	   // public void doPost(HttpServletRequest request,HttpServletResponse response)  
	    //throws ServletException, IOException {  
	//doGet(request, response);  
	  
	//}  
	}  
	
	
	