

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
		System.out.println("HELLO1");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("username");
		String p = request.getParameter("userpass");
		
		HttpSession session = request.getSession();
		if(session!=null){
			System.out.println("HELLO5");
			session.setAttribute("name", n);
			session.setAttribute("name1", p);
		}	
		if(Login.validate(n, p)){
			Customer customer = Login.getCustomerData(n,p);
			session.setAttribute("firstName", customer.getCustFirstName());
			System.out.println(customer.getCustFirstName());
			session.setAttribute("lastName", customer.getCustLastName());
			session.setAttribute("address", customer.getCustAddress());
			session.setAttribute("city", customer.getCustCity());
			session.setAttribute("province", customer.getCustProv());
			session.setAttribute("postal", customer.getCustPostal());
			session.setAttribute("country", customer.getCustCountry());
			session.setAttribute("hPhone", customer.getCustHomePhone());
			session.setAttribute("bPhone", customer.getCustBusPhone());
			session.setAttribute("email", customer.getCustEmail());
			System.out.println("HELLO3");
			RequestDispatcher rd = request.getRequestDispatcher("Portal.jsp");
			rd.forward(request, response);
		}
		else{
			out.print("<p style=\"color:red\">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		out.close();
	}

}
