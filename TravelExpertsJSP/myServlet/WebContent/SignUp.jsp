<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.* "%>

<!-- 
	This is registration page
	Author 1: Muhammad Islam
	Author 2: Sheila zhao
	Date: April 2019
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="icon" href="assets/images/world.png">
 <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="assets/bootstrap/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/default.css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/styles.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
 <script src="assets/bootstrap/js/bootstrap.min.js"></script> 
 <script src="assets/jquery.js"></script> 

 <style>
                .errormessage{
                    display:none;
                    color:tomato;
                    font-size: 20px;
                    font-family: fantasy;
                }
            </style>                                           					
 
</head>
<body>
<!-- nav button to home page -->
 <div class="icon-bar">
      <a class="active" href="index.jsp"><i class="fas fa-arrow-left"></i></a>
    </div>
<!-- Sign up div -->
		<div class="register-wrap">       
			<div class="login-html">			  
				<input id="tab-1" type="radio" name="tab" class="sign-in"><label class="tab"><a href="SignIn.jsp">Sign In</a></label>
				<input id="tab-2" type="radio" name="tab" class="sign-up" checked><label class="tab">Sign Up</label>
				<div class="login-form">					
	<!-- Registration form -->				
					<div class="sign-up-htm">
					<form action="userRegController.jsp" method="post">
						<div class="group">
							<label for="user" class="label">First Name</label>
							<input type="text" class="input" placeholder="First name" name="firstName" id="firstName">
							<div  class="errormessage"  id="fnamemsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">Last Name</label>
							<input type="text" class="input" placeholder="Last name" name="lastName" id="lastName">
							<div  class="errormessage"  id="lnamemsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">Street Address</label>
							<input type="text" class="input" placeholder="Streer Address" name="streetAddress" id="streetAddress">
							<div  class="errormessage"  id="staddressmsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">City</label>
							<input type="text" class="input" placeholder="City" name="city" id="city">
							<div  class="errormessage"  id="citymsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">Province</label>
							<input type="text" class="input" placeholder="Province" name="province" id="province" maxlength="2">
							<div  class="errormessage"  id="provincemsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">Postal Code</label>
							<input type="text" class="input" placeholder="T3J 5L9" name="postalCode" id="postalCode">
							<div  class="errormessage"  id="postalcodemsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">Country</label>
							<select class="input" name="country" id="country">
							
	                			<option selected>Choose Country</option>
	                			<option value="Canada">Canada</option>
	                 			<option value="USA">USA</option>
                 			
            			</select>
             			<div  class="errormessage"  id="countrymsg"> </div>
						</div>
						<div class="group">
							<label for="user" class="label">Home Phone</label>
							<input type="text" class="input" placeholder="000-000 0000" name="homePhone" id="homePhone">
							<div  class="errormessage"  id="homephonemsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">Business Phone</label>
							<input type="text" class="input" placeholder="000-000 0000" name="businessPhone" id="businessPhone">
							<div  class="errormessage"  id="businessphonemsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">Email</label>
							<input type="text" class="input" placeholder="abc123xyz@xyz.com" name="cEmail" id="cEmail">
							<div  class="errormessage"  id="cemailmsg"></div>
						</div>
						<div class="group">
							<label for="user" class="label">Agent</label>
							<select class="input" name="agent" id="agent">
                <option selected>Choose Agent</option>
		<!-- To get agents from database -->				   
					<% 

		try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT AgentId,AgtFirstName FROM agents order by AgentId");
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
        }

					%>
					</select>
             <div  class="errormessage"  id="agencymsg"> </div>
            
    </div>
						
						<div class="group">
							<label for="user" class="label">Login ID</label>
							<input type="text" class="input" placeholder="Choose Your Login ID" name="userId" id="userId">
							<div  class="errormessage"  id="useridmsg"></div>
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label>
							<input type="password" class="input" data-type="password" placeholder="Enter Password" name="pass" id="pass">
							<div  class="errormessage"  id="passmsg"> </div>
						</div>
						<div class="group">
							<label for="pass" class="label">Confirm Password</label>
							<input type="password" class="input" data-type="password" placeholder="Confirm Password" name="confirmPass" id="confirmPass">
							<div  class="errormessage"  id="passmsg"> </div>
						</div>
						
						
						 <div class="group">
							<input type="submit" class="button" value="Sign Up" id="sbutton" name="submit_customer">							
						</div>
						
						<div class="group">
							<input type="reset" class="button" value="Reset">
						</div>
						<div class="hr"></div>
						<div class="foot-lnk">
							<a href="SignIn.jsp">Already Member?</a>
						</div>
						</form>
						</div>
					</div>					
				</div>
			</div>
</body>
<script>
		 /* 
		 Defined regular expressions for email, phone and postal code and function checks the
		 fields values if is empty shows the message in a specif div
		 */		 			  
              var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
               var phoneNumberPattern = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
                var postalCodeRegex = /^[A-Za-z]\d[A-Za-z] ?\d[A-Za-z]\d$/;
            $(document).ready(function(){
   $('#sbutton').click(function(){
        if ($('#firstName').val() == ""){
          $('#fnamemsg').slideDown("slow");
          $('#fnamemsg').html("Please Provide First Name");
          $('#firstName').focus();
         
            return false;
                  
										}
        
       else if($('#lastName').val()==""){
            $('#lnamemsg').slideDown("slow");
          $("#lnamemsg").html("Please Provide Last Name");
          $('#lastName').focus();
         
            return false;
										}
       
        else if($('#streetAddress').val()==""){
            $('#staddressmsg').slideDown("slow");
          $("#staddressmsg").html("Please Provide Street Address");
          $('#streetAddress').focus();
         
            return false;
											 }
       
         else if($('#city').val()==""){
            $('#citymsg').slideDown("slow");
          $("#citymsg").html("Please Provide City");
          $('#city').focus();
         
            return false;
									 }
       
        else if($('#province').val()==""){
            $('#provincemsg').slideDown("slow");
          $("#provincemsg").html("Please Provide Province");
          $('#province').focus();
         
            return false;           
        
											}

             
       else if(!postalCodeRegex.test($('#postalCode').val())){
            $('#postalcodemsg').slideDown("slow");
          $("#postalcodemsg").html("Please Provide Postal Code");
          $('#postalCode').focus();
         
            return false;
															 }
 else if($('#country').val()=="Choose Country"){
            $('#countrymsg').slideDown("slow");
          $("#countrymsg").html("Please Select Country");
          $('#country').focus();
         
            return false;
												}


      
       
         else if(!phoneNumberPattern.test($('#homePhone').val())){
            $('#homephonemsg').slideDown("slow");
          $("#homephonemsg").html("Please Provide Home Phone");
          $('#homePhone').focus();
         
            return false;
																 }


    else if(!phoneNumberPattern.test($('#businessPhone').val())){
            $('#businessphonemsg').slideDown("slow");
          $("#businessphonemsg").html("Please Provide Business Phone");
          $('#businessPhone').focus();
         
            return false;
																 }




        else if(!expr.test($('#cEmail').val())){
            $('#cemailmsg').slideDown("slow");
          $("#cemailmsg").html("Email Address Invalied");
          $('#cEmail').focus();
         
            return false;
												 }
	   
	   
	   else if($('#agent').val()=="Choose Agent"){
            $('#agencymsg').slideDown("slow");
          $("#agencymsg").html("Please Select Agent");
          $('#agent').focus();
         
            return false;
													}
	   
	   
       
          else if($('#userId').val()==""){
            $('#useridmsg').slideDown("slow");
          $("#useridmsg").html("Please Provide User Id");
          $('#userId').focus();
         
            return false;
											}
       
         else if($('#pass').val()==""){
            $('#passmsg').slideDown("slow");
          $("#passmsg").html("Please Provide Password");
          $('#pass').focus();
         
            return false;
										}
       
         else if ($('#confirmPass').val() == "" || !($('#pass').val() ==  $('#confirmPass').val())) {
             $('#confirmpassmsg').slideDown("slow");
           $("#confirmpassmsg").html("Confirm Password Empty or Missmatched");
           $('#confirmPass').focus();
          
             return false;
         }
        
        																	   
       
        else{
              return true;             
            }
    });
});
            
          
            </script>
</html>