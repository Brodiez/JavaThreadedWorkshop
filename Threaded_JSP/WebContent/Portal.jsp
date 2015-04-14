<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>  
</head>  
<body>  
    <h3>Login successful!!!</h3>  
    <h4>  
        Hello,  
        <%=session.getAttribute("name")%></h4>
        <br><br>
	<h3><a href='Customer_Modify.jsp'>Update Profile</a></h3>
	<br>
	<h3><a href='LogOut.jsp'>Logout</a></h3>	  
</body> 
</html> --%>

<%@page import = "java.sql.*, java.io.*" %>
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
				%><jsp:include page="header.jsp" />
				<body>
				<div align="center">

					<div id="banner"></div>

					<div id="body">
						
						<%
				out.print("<form name='NewCustomerForm' method='post' action='Update_Customer'>");
				
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
				out.print("<input name='CustFirstName' type='text' id='CustFirstName' value='" + rs.getString(2) + "'DISABLED></div>"); 
				out.print("</td>");
				out.print("<td width='110'><div align='left'><b>*Last Name:</b></div></td>");
				out.print("<td><div align='left'>");
				out.print("<input name='CustLastName' type='text' id='CustLastName' value='" + rs.getString(3) + "'DISABLED></div>");
				out.print("</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>&nbsp;</td><td>&nbsp;</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td><div align='left'><b>*Address:</b></div></td>");
				out.print("<td colspan='2'><div align='left'>");
				out.print("<input name='CustAddress' type='text' id='CustAddress' value='" + rs.getString(4) + "' maxlength='75' size='25'DISABLED></div>");
				out.print("</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td><div align='left'><b>*City:</b></div></td>");
				out.print("<td><div align='left'>");
				out.print("<input name='CustCity' type='text' id='Custcity' value='" + rs.getString(5) + "'DISABLED></div>");
				out.print("</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>");
				out.print("<div align='left' id='label'><b>*Province:</b></div>");
				out.print("</td>");
				out.print("<td><div align='left'>");
				out.print("<input name='CustProv' type='text' id='CustProv' value='" + rs.getString(6) + "'DISABLED></div>");
				out.print("</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>");
				out.print("<div align='left' id='label'><b>*Country:</b></div>");
				out.print("</td>");
				out.print("<td>");
				out.print("<input name='CustCity' type='text' id='CustCity' value='" + rs.getString(8) + "'DISABLED></div>");
				out.print("</td>");
				
				out.print("<tr>");
				out.print("<td><div align='left' id='zippostal'><b>*Postal Code:</b></div></td>");
				out.print("<td><div align='left'>");
				out.print("<input name='CustPostal' type='text' id='CustPostal' value='" + rs.getString(7) + "'DISABLED></div>");
				out.print("</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td>&nbsp;</td><td>&nbsp;</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td><div align='left'><b>*Home Phone:</b></div></td>");
				out.print("<td><div align='left'>");
				out.print("<input name='CustHomePhone' type='text' id='CustHomePhone' value='" + rs.getString(9) + "'DISABLED></div>");
				out.print("</td>");
				out.print("<td><div align='left'><b>Business Phone:</b></div></td>");
				out.print("<td><div align='left'>");
				out.print("<input name='CustBusPhone' type='text' id='CustBusPhone' value='" + rs.getString(10) + "'DISABLED></div>");
				out.print("</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td><div align='left'><b>*Email:</b></div></td>");
				out.print("<td><div align='left'>");
				out.print("<input name='CustEmail' type='text' id='CustEmail' value='" + rs.getString(11) + "' size='25' DISABLED></div>");
				out.print("</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td>&nbsp;</td><td>&nbsp;</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td>&nbsp;</td><td>&nbsp;</td>");
				out.print("</tr>");
				out.print("</table>");
					
				out.print("<table width='200' border='0' align='center'>");
					
				out.print("<tr>");
				out.print("<td width='100'>");
				out.print("<input type='button'  value='Edit' id ='edit' onClick='enablefild()'>");
				out.print("</td>");
				out.print("<td width='150'>");
				out.print("<input type='submit'  name='submit' value='Update' id ='update' DISABLED>");
				out.print("</td>");
				out.print("<td width='100'>");
				out.print("<div align='left'>");
				out.print("<input name='button' type='reset' id='reset' value='Reset' DISABLED/>");
				out.print("</div>");
				out.print("</td>");
				out.print("</tr>");
				out.print("</table>");
				out.print("</form>");
				
				out.print("</div>");
				
					
				out.print("</table>");
				out.print("</form>");
				
			}else{
			    out.println("Customer Not in the DB....");
			}
			} catch (Exception ex){
				System.out.println(ex);
			}
		
%>
<script>
	window.onload = function(){
		document.getElementById('CustFirstName').onclick = enablefild;
		document.getElementById('CustLastName').onclick = enablefild;
		document.getElementById('CustAddress').onclick = enablefild;
		document.getElementById('Custcity').onclick = enablefild;
		document.getElementById('CustProv').onclick = enablefild;
		document.getElementById('CustCity').onclick = enablefild;
		document.getElementById('CustPostal').onclick = enablefild;
		document.getElementById('CustHomePhone').onclick = enablefild;
		document.getElementById('CustBusPhone').onclick = enablefild;
		document.getElementById('CustEmail').onclick = enablefild;
		document.getElementById('edit').onclick = enablefild;
		document.getElementById('reset').onclick = enablefild;
		document.getElementById('update').onclick = enablefild;
	}
	function enablefild()
	{
		if (document.getElementById('CustFirstName').checked == false){
			document.getElementById('CustFirstName').disabled = false;
		}
		if (document.getElementById('CustLastName').checked == false){
			document.getElementById('CustLastName').disabled = false;
		}
		if (document.getElementById('CustAddress').checked == false){
			document.getElementById('CustAddress').disabled = false;
		}
		if (document.getElementById('Custcity').checked == false){
			document.getElementById('Custcity').disabled = false;
		}
		if (document.getElementById('CustProv').checked == false){
			document.getElementById('CustProv').disabled = false;
		}
		if (document.getElementById('CustHomePhone').checked == false){
			document.getElementById('CustHomePhone').disabled = false;
		}
		if (document.getElementById('CustBusPhone').checked == false){
			document.getElementById('CustBusPhone').disabled = false;
		}
		if (document.getElementById('CustEmail').checked == false){
			document.getElementById('CustEmail').disabled = false;
		}
		if (document.getElementById('edit').checked == false){
			document.getElementById('edit').disabled = false;
		}
		if (document.getElementById('CustCity').checked == false){
			document.getElementById('CustCity').disabled = false;
		}
		if (document.getElementById('CustPostal').checked == false){
			document.getElementById('CustPostal').disabled = false;
		}
		if (document.getElementById('edit').checked == true){
			document.getElementById('edit').enabled = true;
		}
		if (document.getElementById('reset').checked == false){
			document.getElementById('reset').disabled = false;
		}
		if (document.getElementById('reset').checked == false){
			document.getElementById('reset').disabled = false;
		}
		if (document.getElementById('update').checked == false){
			document.getElementById('update').disabled = false;
		}
	}
</script>
</body>
</html>