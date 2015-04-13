

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetProvState
 */
public class GetProvState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProvState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String country = request.getParameter("country");
		String driver = this.getServletContext().getInitParameter("dbDriver");
		String dburl = this.getServletContext().getInitParameter("dbURL");
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dburl, "root", "");
			Statement stmt = conn.createStatement();
			String sql = "SELECT provstatecode, provstatename FROM provstates where countrycode = '" + country + "'";
			ResultSet rs = stmt.executeQuery(sql);
			out.print("<option value=''>Select a Province or State</option>");
			while(rs.next()) {
				out.print("<option value = '" + rs.getString(1) + "'>" + rs.getString(2) + "</option>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
