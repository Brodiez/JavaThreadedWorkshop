<!-- Coded By: Anushka De Silva
Functionality: Login Page for the Website -->
<%@page import = "java.io.*, java.sql.*" %>
<jsp:include page="header.jsp" />
<body>
				<div align="center">

					<div id="banner"></div>

						<div id="body">
							<% 	out.print("<form action='Login_Servlet' method='post'>");
								out.print("<fieldset style='width: 300px'>");
							   	out.print("<legend> Login to Travel Expert's </legend>");
							   	out.print("<table>");
							   	out.print("<tr>");
							   	out.print("<br></br>");
							   	out.print("<td>User ID</td>");
							   	out.print("<td><input type='text' name='username'/></td>");
							   	out.print("</tr>");
							   	out.print("<tr>");
							   	out.print("<td>Password</td>");
							   	out.print("<td><input type='password' name='userpass'/></td>");
							   	out.print("</tr>");
							   	out.print("<tr>");
							   	out.print("<td><input type='submit' value='Login' /></td>");
							   	out.print("</tr>");
							   	out.print("<tr><td colspan='2'>Yet Not Registered!! <a href='Customer_Registration.jsp'>Register Here</a></td></tr>");
							   	out.print("</table>");
							   	out.print("</fieldset>");
							   	out.print("</form>");
							%>
						</div>	
					</div>
				</body>
			</html>