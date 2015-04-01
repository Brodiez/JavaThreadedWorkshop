/*Project Name: Threaded Workshop 03*/
/*Class Name: travelExpertsConnectionDB.java*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class travelExpertsConnectionDB 
{
	Connection conn = null;
	public static Connection dbConnection()
	{
		try
		{
			//Defines Connection to Database
			Class.forName("com.mysql.jdbc.Driver");
			Properties info = new Properties();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts","root","");
			return conn;
		}catch (Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}

}
