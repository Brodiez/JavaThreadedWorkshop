
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
        <a href='Customer_Modify.jsp'>Update Profile</a>
        <a href='LogOut.jsp'>Log out</a>
        
        <%
        
        out.print("<form name='NewCustomerForm' method='post' action=''>");
		out.print("<table width='600' border='0' aligh='center' cellpadding='0' cellspacing='5'");
		out.print("<tr>");
		out.print("<caption>Customer Registration</caption>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan='2'><h6><i>Required Fields Indicated With a *</i></h6></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td width='110'><div align='left'><b>*First Name:</b></div>");
		out.print("</td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustFirstName' type='text' id='CustFirstName' value='" + session.getAttribute("firstName") + "'></div>"); 
		out.print("</td>");
		out.print("<td width='110'><div align='left'><b>*Last Name:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustLastName' type='text' id='CustLastName' value='" + session.getAttribute("lastName") + "'></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>&nbsp;</td><td>&nbsp;</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>*Address:</b></div></td>");
		out.print("<td colspan='2'><div align='left'>");
		out.print("<input name='CustAddress' type='text' id='CustAddress' value='" + " " + "' maxlength='75' size='25'></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>*City:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustCity' type='text' id='Custcity' value='" + " " + "'></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<div align='left' id='label'><b>*Province:</b></div>");
		out.print("</td>");
		out.print("<td>");
		out.print("<div align='left' id='region'>");
		out.print("<select name='CustProv'  id='CustProv'>");
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
		out.print("<select name='CustCountry' id='CustCountry' onchange='getProvStat(this.value)'>");
		out.print("<option value=''>Select One...</option>");
		
		
		out.print("<option value='Canada'>Canada</option>");
		out.print("<option value='United States'>United States</option>");
		
		
		
		out.print("</select>");
		out.print("</div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left' id='zippostal'><b>*Postal Code:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustPostal' type='text' id='CustPostal' value='" + " " + "'></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>&nbsp;</td><td>&nbsp;</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>*Home Phone:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustHomePhone' type='text' id='CustHomePhone' value='" + " " + "'></div>");
		out.print("</td>");
		out.print("<td><div align='left'><b>Business Phone:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustBusPhone' type='text' id='CustBusPhone' value='" + " " + "'></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>*Email:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='CustEmail' type='text' id='CustEmail' value='" + " " + "' size='25'></div>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>&nbsp;</td><td>&nbsp;</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><div align='left'><b>AgentID:</b></div></td>");
		out.print("<td><div align='left'>");
		out.print("<input name='AgentID' type='text' id='AgentID' value='" + " " + "' size='25'></div>");
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
        
        %>
</body> 
</body>
</html>