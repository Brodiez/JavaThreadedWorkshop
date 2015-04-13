<%@ page import="java.sql.*, java.io.*" %>

<%!
	public String createLogin(String [] loginArray){
		boolean status = false;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexpert","root","");
			
			String selectSql = "select * from Customers where CustFirstName=? and CustLastName=?";
			pStmt = conn.prepareStatement(selectSql);
			pStmt.setString(1, loginArray[0]);
			pStmt.setString(2, loginArray[1]);
			
			rs = pStmt.executeQuery();
			status = rs.next();
			//int rows = pStmt.executeQuery();
			if(status == true)
			{
				return "Customer Logged in Successfully!";
			}
			else
			{
				return "Customer Failed Log in!. Please Try Again Later!";
			}
			
		}catch (Exception e){
			System.out.println(e);
		}
		return null;
		//return status;
	}
	public void displayForm(String [] loginArray, JspWriter out) throws IOException
	{
		out.print("<form name='login' method='get' action=''>");
		out.print("<table width='600' border='0' align='center' cellpadding='0' cellspacing='5'>");
		out.print("<tr>");
		out.print("<caption>Customer Login</caption>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan='2'><h6>Required fields indicated with a *</h6></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td width='90'><div align='left'>*Username:</div>");
		out.print("</td>");
		out.print("<td><div align='left'>");
		out.print("<input name='UserName' type='text' id='UserName' value='" + loginArray[0] + "'></div>"); 
		out.print("</td>");
		out.print("<td width='110'><div align='left'>*Password:</div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='UserPass' type='text' id='UserPass' value='" + loginArray[1] + "'></div>");
		out.print("</td>");
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
	}

	public String validate(String [] loginData)
	{
		for (int i=0; i<loginData.length; i++)
		{
			if (loginData[i].equals(""))
			{
				switch(i)
				{
					case 0:
						return "**User-Name must have a Value!**";
					
					case 1:
						return "**Password must have a value!**";
											
					case 3:
	
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
			if (request.getParameter("submit") != null)
			{
				String [] login = new String[2];
				login[0] = (String)request.getParameter("UserName");
				login[1] = (String)request.getParameter("UserPass");
				
		
				//pass data to validation function
				String message = validate(login);
				if (message.equals(""))
				{
					//if not valid set error message and redisplay form
					out.print("<h4 style='color:crimson'>" + createLogin(login) + "</h4>");
					HttpSession session2 = request.getSession(false);
					if(session2 != null)
					{
						session2.setAttribute("name", login[0]);
						RequestDispatcher rd = request.getRequestDispatcher("Portal.jsp");
						rd.forward(request,response);
					}
					//after writing customer data empty the array so form will be empty
					
						login[0] = "";
						login[1] = "";				
					
					displayForm(login, out);
				} else
				{
				   out.print("<h4 style='color:crimson'>" + message + "</h4>");
				   displayForm(login, out);
			    }
			}
			else
			{
				//display form
				String [] login = {"",""};
				displayForm(login, out);
			}
			%>	
	</div>
</div>
</body>
</html>
	