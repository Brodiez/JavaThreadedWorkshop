

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
 * Servlet implementation class Update_Customer
 */
@WebServlet("/Update_Customer")
public class Update_Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String f = request.getParameter("CustFirstName");
		String l = request.getParameter("CustLastName");
		String a = request.getParameter("CustAddress");
		String ci = request.getParameter("Custcity");
		String pr = request.getParameter("CustProv");
		String co = request.getParameter("CustCity");
		String po = request.getParameter("CustPostal");
		String hp = request.getParameter("CustHomePhone");
		String bp = request.getParameter("CustBusPhone");
		String em = request.getParameter("CustEmail");
		
		
		HttpSession session = request.getSession();
		if(session!=null){
			session.setAttribute("CustFirstName", f);
			session.setAttribute("CustLastName", l);
			session.setAttribute("CustAddress", a);
			session.setAttribute("Custcity", ci);
			session.setAttribute("CustProv", pr);
			session.setAttribute("CustCity", co);
			session.setAttribute("CustPostal", po);
			session.setAttribute("CustHomePhone", hp);
			session.setAttribute("CustBusPhone", bp);
			session.setAttribute("CustEmail", em);
		}	
		if(Login.updateCustomer(f, l, a, ci, pr, co, po, hp, bp, em)){
			RequestDispatcher rd = request.getRequestDispatcher("Portal.jsp");
			rd.forward(request, response);
		}
		else{
			out.print("<p style=\"color:red\">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}

}
