<%@ page import="java.sql.*, java.io.*" %>
<%
	 driver = application.getInitParameter("dbDriver");
	 dbURL = application.getInitParameter("dbURL");
 %>
<%!
	String driver;
	String dbURL;
   public String createCustomer(String [] customerArray)
		{
			String sql = "INSERT INTO customers ("
				+ "CustomerID, CustFirstName, CustLastName, CustAddress, CustCity, CustProv, CustCountry, CustPostal, CustHomePhone, CustBusPhone, CustEmail, AgentID"
			    + ") values (S_101_1_CUSTOMERS.NEXTVAL, "
				+ "'" + customerArray[0] + "'," 
				+ " '" + customerArray[1] + "',"
				+ " '" + customerArray[2] + "',"
				+ " '" + customerArray[3] + "',"
				+ " '" + customerArray[4] + "',"
				+ " '" + customerArray[5] + "',"
				+ " '" + customerArray[6] + "',"
				+ " '" + customerArray[7] + "',"
				+ " '" + customerArray[8] + "',"
				+ " '" + customerArray[9] + "',"
				+ " " + customerArray[10] + ")";


		    try
		    {
		        Class.forName("com.mysql.jdbc.Driver");
				//Class.forName("oracle.jdbc.driver.OracleDriver");
		        Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts","root","");
		        //Connection dbConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ICTOOSD", "ICTOOSD");

		        Statement stmt = dbConn.createStatement();

		        int rows = stmt.executeUpdate(sql);

		        // Cleanup
		        dbConn.close();  // close the connection
		        
				if (rows == 1)
				{
					return "Your registration was a success. Thank you for joining The Travel Experts.";
				}
				else
				{
					return "Insert was NOT successful";
				}
		    }
		    catch (Exception excp)
		    {
		        excp.printStackTrace();
		    }
			return "";
		}
		
		public void displayForm(String [] customerArray, JspWriter out) throws IOException
		{
			out.print("<form name='form1' method='get' action=''>");
			out.print("<table width='600' border='0' align='center' cellpadding='0' cellspacing='5'>");
			out.print("<tr>");
			out.print("<caption>Customer Registration</caption>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td colspan='2'><h6>Required fields indicated with a *</h6></td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td width='90'><div align='left'>*First Name:</div>");
			out.print("</td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustFirstName' type='text' id='CustFirstName' value='" + customerArray[0] + "'></div>"); 
			out.print("</td>");
			out.print("<td width='110'><div align='left'>*Last Name:</div></td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustLastName' type='text' id='CustLastName' value='" + customerArray[1] + "'></div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>&nbsp;</td><td>&nbsp;</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td><div align='left'>Address:</div></td>");
			out.print("<td colspan='2'><div align='left'>");
			out.print("<input name='CustAddress' type='text' id='CustAddress' value='" + customerArray[2] + "' maxlength='75' size='25'></div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td><div align='left'>*City:</div></td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustCity' type='text' id='Custcity' value='" + customerArray[3] + "'></div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>");
			out.print("<div align='left' id='label'>*Province:</div>");
			out.print("</td>");
			out.print("<td>");
			out.print("<div align='left' id='region'>");
			out.print("<select name='CustProv'  id='CustProv'>");
			out.print("<option value=''>Select One...</option>");
			/* out.print("<option value='AB'>AB</option>");
			out.print("<option value='BC'>BC</option>");
			out.print("<option value='MB'>MB</option>");
			out.print("<option value='NB'>NB</option>");
			out.print("<option value='NF'>NF</option>");
			out.print("<option value='NT'>NT</option>");
			out.print("<option value='NS'>NS</option>");
			out.print("<option value='NU'>NU</option>");
			out.print("<option value='ON'>ON</option>");
			out.print("<option value='PE'>PE</option>");
			out.print("<option value='QC'>QC</option>");
			out.print("<option value='SK'>SK</option>");
			out.print("<option value='YT'>YT</option>"); */
			out.print("</select>");
			out.print("</div>");
			out.print("</td>");
			out.print("<td><div align='left'>*Country:</div></td>");
			out.print("<td><div align='left'>");
			out.print("<select name='CustCountry' id='CustCountry' onchange='getProvState(this.value)'>");
			out.print("<option value=''>Select One...</option>");
			
			try{
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(dbURL, "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Countries");
				while(rs.next())
				{
					out.print("<option value='"+ rs.getString(1) + "'>" + rs.getString(2) + "</option>");
				}
				conn.close();
			}
			catch (Exception excp) {
		        excp.printStackTrace();
		    }
	
		    //out.print("<option value='Canada'>Canada</option>");
			//out.print("<option value='United States'>United States</option>");
			out.print("</select>");
			out.print("</div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td><div align='left' id='zippostal'>*Postal Code:</div></td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustPostal' type='text' id='CustPostal' value='" + customerArray[6] + "'></div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>&nbsp;</td><td>&nbsp;</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td><div align='left'>*Home Phone:</div></td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustHomePhone' type='text' id='CustHomePhone' value='" + customerArray[7] + "'></div>");
			out.print("</td>");
			out.print("<td><div align='left'>Business Phone:</div></td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustBusPhone' type='text' id='CustBusPhone' value='" + customerArray[8] + "'></div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td><div align='left'>Email:</div></td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustEmail' type='text' id='CustEmail' value='" + customerArray[9] + "' size='25'></div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>&nbsp;</td><td>&nbsp;</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td><div align='left'>AgentID:</div></td>");
			out.print("<td><div align='left'>");
			out.print("<input name='AgentID' type='text' id='AgentID' value='" + customerArray[10] + "' size='25'></div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>&nbsp;</td><td>&nbsp;</td>");
			out.print("</tr>");
			out.print("</table>");
			out.print("<table width='200' border='0' align='center'>");
			out.print("<tr>");
			out.print("<td width='100'>");
			out.print("<input type='submit'  name='submit' value='Register'>");
			out.print("</td>");
			out.print("<td width='100'>");
			out.print("<div align='left'>");
			out.print("<input name='reset' type='reset' id='reset' value='Reset' />");
			out.print("</div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("</table>");
			out.print("</form>");
					
			out.print("<p><b>Privacy statement:</b> Any information entered in the above fields will be used for the purposes of Travel Experts alone. We will not share your information with anyone</p>");
			out.print("<p>&nbsp;</p>");
			out.print("<p>&nbsp;</p>");			
		}
		
		public String validate(String [] customerData)
		{
			for (int i=0; i<customerData.length; i++)
			{
				if (customerData[i].equals(""))
				{
					switch(i)
					{
						case 0:
							return "**First name must have a value!**";
						
						case 1:
							return "**Last name must have a value!**";
						
						case 2:
							break;						
						
						case 3:
							return "**You must include your city name!**";
							
						case 4:
							return "**You must include your province or state name!**";
							
						case 5:
							return "**You must include your country name!**";
							
						case 6:
							return "**You must include your postal or zip code!**";
							
						case 7:
							return "**Please provide your home phone number!**";
							
						case 8:
							break;
							
						case 9:

							break;
						
						default:
						return "field must have a value.";
					}
				}
			}
			return "";
		}
		
%>

<jsp:include page="header.jsp" />
<body>
<div align="center">

	<div id="banner">
	
	
	</div>


	<div id="menu">
		
		<div align="right">
		
			<a href="index.jsp" onmouseover="mouseOver()" onmouseout="mouseOut()"><img src="images/homebut.gif" name="b1" border="0"></a>
			
			<a href="packages.jsp" onmouseover="mouseOver2()" onmouseout="mouseOut2()"><img src="images/packagebut.gif" name="b2" border="0"></a>

			<a href="register.jsp" onmouseover="mouseOver3()" onmouseout="mouseOut3()"><img src="images/registerbut.gif" name="b3" border="0"></a>
			
			<a href="contact.jsp" onmouseover="mouseOver4()" onmouseout="mouseOut4()"><img src="images/contactbut.gif" name="b4" border="0"></a>
			
			<a href="links.jsp" onmouseover="mouseOver5()" onmouseout="mouseOut5()"><img src="images/linksbut.gif" name="b5" border="0"></a>

		</div>
		
	</div>

	<div id="body">
		
		<%
			if (request.getParameter("submit") != null)
			{
				String [] customer = new String[11];
				customer[0] = (String)request.getParameter("CustFirstName");
				customer[1] = (String)request.getParameter("CustLastName");
				customer[2]= (String)request.getParameter("CustAddress");
				customer[3]= (String)request.getParameter("CustCity");
				customer[4] = (String)request.getParameter("CustProv");
				customer[5] = (String)request.getParameter("CustCountry");
				customer[6] = (String)request.getParameter("CustPostal");
				customer[7] = (String)request.getParameter("CustHomePhone");
				customer[8] = (String)request.getParameter("CustBusPhone");
				customer[9] = (String)request.getParameter("CustEmail");
				customer[10] = (String)request.getParameter("AgentID");
		
				//pass data to validation function
				String message = validate(customer);
				if (message.equals(""))
				{
					//if not valid set error message and redisplay form
					out.print("<h4 style='color:crimson'>" + createCustomer(customer) + "</h4>");
					
					//after writing customer data empty the array so form will be empty
					
						customer[0] = "";
						customer[1] = "";
						customer[2] = "";
						customer[3] = "";
						customer[4] = "";
						customer[5] = "";
						customer[6] = "";
						customer[7] = "";
						customer[8] = "";
						customer[9] = "";
						customer[10] = "";
				
					
					displayForm(customer, out);
				} else
				{
				   out.print("<h4 style='color:crimson'>" + message + "</h4>");
				   displayForm(customer, out);
			    }
			}
			else
			{
				//display form
				String [] customer = {"","","","","","","","","","",""};
				displayForm(customer, out);
			}
			%>
		
	</div>
	

	<div id="footer">
	
		<span>[</span>
		
		<a href="index.jsp">Home</a>
		
		<span>||</span>
		
		<a href="packages.jsp">Packages</a>
		
		<span>||</span>
		
		<a href="register.jsp">Registration</a>
		
		<span>||</span>
		
		<a href="contact.jsp">Contact Us</a>
		
		<span>||</span>
		
		<a href="links.jsp">Links</a>
		
		<span>]</span><br />
		
		<span>Copyright &copy; 2008</span>
		
		<br />
	
	</div>

</div>

</body>
</html>