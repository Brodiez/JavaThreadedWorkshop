<%@page import = "java.io.*, java.sql.*" %>

<jsp:include page="header.jsp" />
<body>
<STYLE TYPE="text/css">
<!--
TD{font-family: Arial; font-size: 14pt; color: black;}
TH{font-family: Arial; font-size: 15pt; color: black;}

--->
</STYLE>


<div align="center">

	<div id="banner">
	
	
	</div>


	<div id="menu">
		
		<div align="right">
		
			<a href="Portal.jsp" onmouseover="mouseOver()" onmouseout="mouseOut()"><img src="images/homebut.gif" name="b1" border="0"></a>
						
			<a href="packages.jsp" onmouseover="mouseOver2()" onmouseout="mouseOut2()"><img src="images/packagebut.gif" name="b2" border="0"></a>
			
			<a href="Customer_Registration.jsp" onmouseover="mouseOver3()" onmouseout="mouseOut3()"><img src="images/registerbut.gif" name="b3" border="0"></a>
						
			<a href="contact.jsp" onmouseover="mouseOver4()" onmouseout="mouseOut4()"><img src="images/contactbut.gif" name="b4" border="0"></a>
						
		</div>
		
	</div>

	<div id="body">
		
		
	</div>
	<div id="body">
	<font color="black">
		<h1><%
		
		
		String firstname = (String)session.getAttribute("fName");
		String lastName = (String)session.getAttribute("lName");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts","root","");
		String sql = "SELECT * FROM Customers c, Bookings b, BookingDetails bd Where c.CustomerId = b.CustomerId AND b.BookingId = bd.BookingId AND c.CustFirstName = ? AND c.CustLastName =?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, firstname);
		stmt.setString(2, lastName);
		ResultSet rs = stmt.executeQuery();
		out.println(firstname + " " + lastName + "<br>");
		out.println("<form>");
		out.print("<h3><table border=2><tr><th>Booking No</th><th>Itinerary No</th><th>Destination</th><th>Date</th><th>Description</th>");
		while(rs.next()) {
			//out.print("<table><th>rs.getString("CustLastName"));
			out.print("<tr>");
			out.print("<td>" + rs.getString("BookingNo") + "</td><td>" + rs.getInt("ItineraryNo") + "</td><td>" + rs.getString("Destination") + "</td><td>" + 
						rs.getDate("TripStart").toString() + "</td><td>" + rs.getString("Description") + "</td></tr>");
		}
		out.print("<tr><td><input type='button' onClick='window.print()' value='Print' /></td> ");

		out.print("</tr></table></h3>");
		
		
		
		%></h1>
		</font>	
		</div>

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

</body>
</html>