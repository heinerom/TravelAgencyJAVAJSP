<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <!-- 
    	Previous registration page
    	Author: Muhammad Islam
    	Date: April 2019     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<script  type="text/javascript">
var xmlHttp
function showState(str)
{alert("1"); 
//xmlHttp=GetXmlHttpObject()
xmlHttp=getHttPObject();
alert("1");
  if (xmlHttp==null)
{alert("inside if");
alert ("Browser does not support HTTP Request")
return
} 
alert("outside");
var url="register.jsp"
url=url+"?count="+str
xmlHttp.onreadystatechange=stateChange
xmlHttp.open("GET",url,true)
xmlHttp.send(null)
}
function stateChange() 
{ 
if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
{ 
document.getElementById("state").innerHTML=xmlHttp.responseText 
} 
} 
</script>

</head>
<body>

<select name='country' onchange="showState(this.value)">
<option value="none" selected>Select One</option>
<option value='001'>india</option>
</select>
<br>
<div id='state'>
<select name='state' >
<option value='-1'>pickone</option>
</select>
</div>
<%

String country=request.getParameter("count");
response.setContentType("text/html"); 
response.setHeader("Cache-Control","no-cache");
out.print("Country "+country);
%>


</body>
</html>