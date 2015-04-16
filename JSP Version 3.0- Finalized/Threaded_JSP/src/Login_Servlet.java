/*Coded By: Garret John
Functionality: Login Servlet where it connect between login page and their Database*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Using request setting up local variable where it will assign login credentials into local variables
		
		String n = request.getParameter("username");
		String p = request.getParameter("userpass");
		
		//Setting up a Session
		HttpSession session = request.getSession();
		
		//If newly session is not empty
		if(session!=null){
			
			//Adding locally defined varaibles in to session.
			session.setAttribute("fName", n);
			session.setAttribute("lName", p);
		}
		//Then pass the values into login process
		if(Login.validate(n, p)){
			//If login values authenticates, then it is re-directing to portal page
			RequestDispatcher rd = request.getRequestDispatcher("Portal.jsp");
			rd.forward(request, response);
		}
		//Else display error message
		else{
			out.print("<p style=\"color:red\">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		out.close();
	}

}
