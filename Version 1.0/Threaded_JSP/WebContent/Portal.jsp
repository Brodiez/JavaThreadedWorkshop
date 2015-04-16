<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
</html>
<%-- <%@page import = "java.io.*, java.sql.*" %>
<%
	String custFName = (String)session.getAttribute("fName");
	String custLName = (String)session.getAttribute("lName");
%>
<jsp:include page="header.jsp" />
<body>
				<div align="center">

					<div id="banner"></div>

					<div id="body">
						<% out.print("<h2> Hello '"+ custFName +"'</h2>"); %>
					</div>	
					</div>
					</body>
					</html> --%>
