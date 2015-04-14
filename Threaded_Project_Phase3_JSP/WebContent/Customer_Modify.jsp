<%@page import = "java.sql.*" %>
<%
	String custFName = request.getParameter("username");
	String custLName = request.getParameter("userpass");
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts","root","");
		String selectSQL = "select * from Customers where CustFirstName=? AND CustLastName=?";
		PreparedStatement pStmt = conn.prepareStatement(selectSQL);
		pStmt.setString(1 , custFName);
		pStmt.setString(2, custLName);
		ResultSet rs = pStmt.executeQuery();
	
		if(rs.next())
		{
			
			%><jsp:include page="index.jsp"/><%
			out.print("<form name='NewCustomerForm' method='post' action=''>");
			out.print("<table width='600' border='0' aligh='center' cellpadding='0' cellspacing='5'");
			out.print("<tr>");
			out.print("<caption>Customer Modification</caption>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td colspan='2'><h6><i>Required Fields Indicated With a *</i></h6></td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td width='110'><div align='left'><b>*First Name:</b></div>");
			out.print("</td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustFirstName' type='text' id='CustFirstName' value='" + rs.getString(2) + "'></div>"); 
			out.print("</td>");
			out.print("<td width='110'><div align='left'><b>*Last Name:</b></div></td>");
			out.print("<td><div align='left'>");
			out.print("<input name='CustLastName' type='text' id='CustLastName' value='" + rs.getString(3) + "'></div>");
			out.print("</td>");
			out.print("</tr>");
			out.print("</div>");
			out.print("</table>");
			out.print("</form>");
			
		}
		else 
		{
		    out.println("Customer Not in the DB....");
		}
		} catch (Exception ex) 
		{
			System.out.println(ex);
		}
%>

<%-- <%	
	String custFName = request.getParameter("name");
	String custLName = request.getParameter("name1");
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts","root","");
	String selectSql = "select * from Customers where CustFirstName=? and CustLastName=?";
	pStmt = conn.prepareStatement(selectSql);
	pStmt.setString(1, custFName);
	pStmt.setString(2, custLName);
%>
<%@ page import="java.sql.*, java.io.*"%>
<%!
	String driver;
	String conn;
	PreparedStatement pStmt = null;
	ResultSet rs = null;
	
	public void searchCustomer()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts1","root","");
			String selectSql = "select * from Customers where CustFirstName=? and CustLastName=?";
			pStmt = conn.prepareStatement(selectSql);
			//pStmt.setString(1, custFName);
			//pStmt.setString(2, custLName);		
			rs = pStmt.executeQuery();
			System.out.println("Hello Results");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				rs.getString(3);
				rs.getString(4);
				rs.getString(5);
				rs.getString(6);
				rs.getString(7);
				rs.getString(8);
				rs.getString(9);
				rs.getString(10);
				rs.getString(11);
			}
			System.out.println("Bye Results");
		}catch (SQLException sex)
		{
			System.out.println(sex);
			sex.printStackTrace();
		}catch (ClassNotFoundException ex){
			System.out.println(ex);
			ex.printStackTrace();
		}
		
		
		//status = rs.next();
	} 
	
	public String updateCustomer(String [] customerDataArray)
	{
		String updateSql = "UPDATE Customers SET ("
				+"CustFirstName=+ '"+ customerDataArray[0] + "',CustLastName+ '"+ customerDataArray[1] + "', CustAddress+ '"+ customerDataArray[2] + "', CustCity+ '"+ customerDataArray[3] + "', CustProv+ '"+ customerDataArray[4] + "', CustCountry+ '"+ customerDataArray[5] + "', CustPostal+ '"+ customerDataArray[6] + "', CustHomePhone+ '"+ customerDataArray[7] + "', CustBusPhone+ '"+ customerDataArray[8] + "', CustEmail+ '"+ customerDataArray[9] + "', AgentID+ '"+ customerDataArray[10]+ "'"
			    + "where CustFirstName='"+ customerDataArray[0] + "'";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexpert","root","");
			Statement stmt = conn.createStatement();
			int rows = stmt.executeUpdate(updateSql);
			conn.close();
			
			if(rows == 1)
			{
				return "Customer Information Successfully Updated!";
			}
			else
			{
				return "Update was not Gone Through. Please Try Again Later!";
			}
		}
			catch (Exception ex)
			{
				System.out.println(ex);
				//ex.printStackTrace();
			}
			return null;
	}
	public void displayCustomerForm(String [] customerArray, JspWriter out) throws IOException
	{
		out.print("<form name='NewCustomerForm' method='get' action=''>");
		out.print("<table width='600' border='0' aligh='center' cellpadding='0' cellspacing='5'");
		out.print("<tr>");
		out.print("<caption>Customer Modification</caption>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan='2'><h6><i>Required Fields Indicated With a *</i></h6></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td width='110'><div align='left'><b>*First Name:</b></div>");
		out.print("</td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustFirstName' type='text' id='CustFirstName' value='" + customerArray[0] + "'DISABLED></div>"); 
		out.print("</td>");
		out.print("<td width='110'><div align='left'><b>*Last Name:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustLastName' type='text' id='CustLastName' value='" + customerArray[1] + "'DISABLED></div>");
		out.print("</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td>&nbsp;</td><td>&nbsp;</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>*Address:</b></div></td>");
		out.print("<td colspan='2'><div align='left'>");
		out.print("<input name='CustAddress' type='text' id='CustAddress' value='" + customerArray[2] + "' maxlength='75' size='25'DISABLED></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>*City:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustCity' type='text' id='Custcity' value='" + customerArray[3] + "'DISABLED></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<div align='left' id='label'><b>*Province:</b></div>");
		out.print("</td>");
		
		out.print("<td>");
		out.print("<div align='left' id='region'>");
		out.print("<select name='CustProv'  id='CustProv' DISABLED>");
		out.print("<option value=''>Select One...</option>");
		
		out.print("<option value='AB'>AB</option>");
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
		out.print("<option value='YT'>YT</option>");
		out.print("</select>");
		
		out.print("</div>");
		out.print("</td>");
		out.print("<td><div align='left'><b>*Country:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<select name='CustCountry' id='CustCountry' onchange='getProvStat(this.value)' DISABLED>");
		out.print("<option value=''>Select One...</option>");
		
		/* try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dburl, "root", "");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from countries");
			while (rs.next())
			{
				
				out.print("<option value='" + rs.getString(1) + "'>" + rs.getString(2) + "</option>");
				//out.print("<option value='" + rs.getString(1) 
				//		+ "'>" + rs.getString(2) + "</option>");
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} */
		
		
		out.print("<option value='Canada'>Canada</option>");
		out.print("<option value='United States'>United States</option>");
		
		
		
		out.print("</select>");
		out.print("</div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left' id='zippostal'><b>*Postal Code:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustPostal' type='text' id='CustPostal' value='" + customerArray[6] + "'DISABLED></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>&nbsp;</td><td>&nbsp;</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>*Home Phone:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustHomePhone' type='text' id='CustHomePhone' value='" + customerArray[7] + "'DISABLED></div>");
		out.print("</td>");
		out.print("<td><div align='left'><b>Business Phone:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustBusPhone' type='text' id='CustBusPhone' value='" + customerArray[8] + "'DISABLED></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>*Email:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustEmail' type='text' id='CustEmail' value='" + customerArray[9] + "' size='25' DISABLED></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>&nbsp;</td><td>&nbsp;</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>AgentID:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='AgentID' type='text' id='AgentID' value='" + customerArray[10] + "' size='25'DISABLED></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>&nbsp;</td><td>&nbsp;</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("<table width='200' border='0' align='center'>");
		
		out.print("<tr>");
		out.print("<td width='100'>");
		out.print("<input type='submit'  name='edit' value='Edit'>");
		out.print("</td>");
		out.print("<td width='150'>");
		out.print("<input type='submit'  name='submit' value='Update' DISABLED>");
		out.print("</td>");
		out.print("<td width='100'>");
		out.print("<div align='left'>");
		out.print("<input name='reset' type='reset' id='reset' value='Reset' DISABLED/>");
		out.print("</div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
				
		out.print("<p><b>Privacy statement:</b> Any information entered in the above fields will be used for the purposes of Travel Experts alone. We will not share your information with anyone</p>");
		out.print("<p>&nbsp;</p>");
		out.print("<p>&nbsp;</p>");
	}
		
		public String validateCustomer(String [] customerData)
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

	<div id="banner"></div>

	<div id="body">
		
		<%
		searchCustomer();	
		if(request.getParameter("edit")!=null)
			{
				
			}
			
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
				String message = validateCustomer(customer);
				if (message.equals(""))
				{
					//if not valid set error message and redisplay form
					out.print("<h4 style='color:crimson'>" + updateCustomer(customer) + "</h4>");
					
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
				
					
					displayCustomerForm(customer, out);
				} else
				{
				   out.print("<h4 style='color:crimson'>" + message + "</h4>");
				   displayCustomerForm(customer, out);
			    }
			}
			else
			{
				//display form
				String [] customer = {"","","","","","","","","","",""};
				displayCustomerForm(customer, out);
			}
			%>
		
	</div>
	

</div>

</body>
</html>	 --%>