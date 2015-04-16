<!-- Coded By: Anushka De Silva
Functionality: Portal Page -->
<%@page import = "java.io.*, java.sql.*" %>
<%
	//Get the Session and defined them to local variable	
	String custFName = (String)session.getAttribute("fName");
	String custLName = (String)session.getAttribute("lName");
%>
<!-- Include Heade pages -->
<jsp:include page="header.jsp" />
<body>
				<div align="center">

					<div id="banner"></div>
					<div id="menu">
					<!-- Defined Buttons  -->
					<div align="right">
					
						<a href="Portal.jsp" onmouseover="mouseOver()" onmouseout="mouseOut()"><img src="images/homebut.gif" name="b1" border="0"></a>
						
						<a href="packages.jsp" onmouseover="mouseOver2()" onmouseout="mouseOut2()"><img src="images/packagebut.gif" name="b2" border="0"></a>
			
						<a href="Customer_Registration.jsp" onmouseover="mouseOver3()" onmouseout="mouseOut3()"><img src="images/registerbut.gif" name="b3" border="0"></a>
						
						<a href="contact.jsp" onmouseover="mouseOver4()" onmouseout="mouseOut4()"><img src="images/contactbut.gif" name="b4" border="0"></a>
						
					</div>
					<!-- Defined Body  -->
					<div id="body">
						<% 	
							//Display Customer First and Last Name
							out.print("<h2> Hello "+ custFName +" " + custLName +"</h2>");
							out.print("<br>");
							//Display Image
							out.print("<img src='images/Travel-angency.jpg' name='b2' border='0' width='400px' height='400px'>");
						%>
						<!-- Defined Footer -->
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
