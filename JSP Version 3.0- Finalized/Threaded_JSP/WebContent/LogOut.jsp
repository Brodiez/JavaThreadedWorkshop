<!-- Coded By: Anushka De Silva
Functionality: Log Out Function -->
<%
//Get the Current Session and make it null
session.setAttribute("name", null);
//Invalidate current Session
session.invalidate();
//Redirect page to login page
response.sendRedirect("index.jsp");
%>