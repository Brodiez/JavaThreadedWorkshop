<%-- <%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String custFName = (String)session.getAttribute("fName");
	String custLName = (String)session.getAttribute("lName");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Travel Experts <%=session.getAttribute("fName")%></title>
</head>
<body>
	<h1>Hello <%=session.getAttribute("fName")%></h1>
	<br><br/>
	<h2><a href="Customer_Modify.jsp">Update Your Profile</a></h2>
	<br><br/>
	<h2><a href="packages.jsp">Check Your Bookings</a></h2>
	<br><br/>
	<h2><a href="LogOut.jsp">Log Out</a></h2>
</body>
</html> --%>
<%@page import = "java.io.*, java.sql.*" %>
<%
	String custFName = (String)session.getAttribute("fName");
	String custLName = (String)session.getAttribute("lName");
%>
<jsp:include page="header.jsp" />
<body>
				<div align="center">

					<div id="banner"></div>
					<div id="menu">
		
					<div align="right">
					
						<a href="index.jsp" onmouseover="mouseOver()" onmouseout="mouseOut()"><img src="images/homebut.gif" name="b1" border="0"></a>
						
						<a href="packages.jsp" onmouseover="mouseOver2()" onmouseout="mouseOut2()"><img src="images/packagebut.gif" name="b2" border="0"></a>
			
						<a href="Customer_Registration.jsp" onmouseover="mouseOver3()" onmouseout="mouseOut3()"><img src="images/registerbut.gif" name="b3" border="0"></a>
						
						<a href="contact.jsp" onmouseover="mouseOver4()" onmouseout="mouseOut4()"><img src="images/contactbut.gif" name="b4" border="0"></a>
						
					</div>
					<div id="body">
						<% 	out.print("<h2> Hello "+ custFName +"</h2>");
							out.print("<br></br>");
						   	out.print("<h2><a href='Customer_Modify.jsp'>Update Profile</a></h2>");
						   	out.print("<br></br>");
						   	out.print("<h2><a href='packages.jsp'>View Packages</a></h2>");
						   	out.print("<br></br>");
						   	out.print("<h2><a href='LogOut.jsp'>Logout</a></h2>");
						%>
						<div id="footer">
	
							<span>[</span>
							
							<a href="Customer_Modify.jsp">Update Profile</a>
							
							<span>||</span>
							
							<a href="packages.jsp">View Packages</a>
							
							<span>||</span>
							
							<a href="LogOut.jsp">Logout</a>
							
							<span>||</span>
							
							<span>Powered By: BAG Solutions </span> <span>||</span> <span> Copyright &copy; 2008</span>
							
							<br />
	
					</div>
					</div>	
					</div>
					</body>
					</html>
