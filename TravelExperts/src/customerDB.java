/*Developer's Name: Anushka Kaushalya De Silva*/
/*Developer's SAIT ID: 000680968*/
/*Project Name: Threaded Workshop 03*/
/*Class Name: customer.java*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class customerDB
{
	static Connection conn = null;
	public static String AddCustomer(Customer customer)
	{
		String customerId ="";
		try {
			conn = travelExpertsConnectionDB .dbConnection();
			String insertQuery =  "INSERT INTO CUSTOMERS (CUSTOMERID,CUSTFIRSTNAME,CUSTLASTNAME,CUSTADDRESS,CUSTCITY,CUSTPROV,CUSTPOSTAL,CUSTCOUNTRY,CUSTHOMEPHONE,CUSTBUSPHONE,CUSTEMAIL,AGENTID,USERNAME,PASSWORD)"
					+ " VALUES (LAST_INSERT_ID(),?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(insertQuery);
			ResultSet rs = pStmt.getGeneratedKeys();
			//if(rs.next()){
			//	rs = pStmt.getGeneratedKeys();
			//	customer.setCustomerID(rs.getInt(1));
			//}
			rs = pStmt.executeQuery("select last_insert_id() as last_id from customers");
			//pStmt = conn.prepareStatement(insertQuery,pStmt.RETURN_GENERATED_KEYS);
			
			//pStmt.setLong(1, customer.getCustomerID());
			pStmt.setString(2, customer.getCustFirstName());
			pStmt.setString(3, customer.getCustLastName());
			pStmt.setString(4, customer.getCustAddress());
			pStmt.setString(5, customer.getCustCity());
			pStmt.setString(6, customer.getCustProv());
			pStmt.setString(7, customer.getCustPostal());
			pStmt.setString(8, customer.getCustCountry());
			pStmt.setString(9, customer.getCustHomePhone());
			pStmt.setString(10, customer.getCustBusPhone());
			pStmt.setString(11, customer.getCustEmail());
			pStmt.setString(12, customer.getAgentId());
			pStmt.setString(13, customer.getUserName());
			pStmt.setString(14, customer.getPassword());
			pStmt.execute();
		
			pStmt.close();
			pStmt = null;
			conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}		
		return customerId;
	}
	static Connection conn1 = null;
	public static String UpdateCustomer(Customer customer)
	{
		try
		{
			conn1 = travelExpertsConnectionDB .dbConnection();
			//Defines new set of variable and set the text fields for each and every text field and get the content of them
			
			int custID = customer.getCustomerID();
			String custFirstName = customer.getCustFirstName();
			String custLastName = customer.getCustLastName();
			String custAddress = customer.getCustAddress();
			String custCity = customer.getCustCity();
			String custProv = customer.getCustProv();
			String custPostal = customer.getCustPostal();
			String custCountry = customer.getCustCountry();
			String custHomePhone = customer.getCustHomePhone();
			String custBusPhone = customer.getCustBusPhone();
			String custEmail = customer.getCustEmail();
			String custAgtID = customer.getAgentId();
			String custUName = customer.getUserName();
			String custPassword = customer.getPassword();
			
			//Defines update query statement and execute it
			//String updateQuery =  "Update agents set AGENTID='"+upAgtID+"',AGTFIRSTNAME='"+upAgtFirstName+"',AGTMIDDLEINITIAL='"+upAgtMiddleIni+"',AGTLASTNAME='"+upAgtLastName+"',AGTBUSPHONE='"+upAgtBusPhone+"',AGTEMAIL='"+upAgtEMail+"',AGTPOSITION='"+upAgtPosition+"',AGENCYID='"+upAgtAgencyID+"' where AGENTID='"+upAgtID+"'";
			String updateQuery = "Update customers set CustFirstName='"+ custFirstName +"', CustLastName='"+ custLastName +"', CustAddress='"+ custAddress +"', CustCity='"+ custCity +"', CustProv='"+ custProv +"', CustPostal='"+ custPostal +"', CustCountry='"+ custCountry +"', CustHomePhone='"+ custHomePhone +"', CustBusPhone='"+ custBusPhone +"', CustEmail='"+ custEmail +"', AgentId='"+ custAgtID +"', UserName='"+ custUName +"', Password='"+ custPassword+ "' where CustomerId='"+ custID +"'";
			PreparedStatement pstmt = conn1.prepareStatement(updateQuery);
			pstmt.execute();
			
			//Display message if the process completes
			JOptionPane.showMessageDialog(null,"Data Updated Successfully!");
			pstmt.close();
			pstmt = null;
			conn1.close();
			conn1 = null;
		}catch (Exception ex)
		{
			System.out.println(ex);
			//ex.printStackTrace();
		}
		return null;		
	}
	
	static Connection conn2 = null;
	public static String DeleteCustomer(Customer customer)
	{
		try
		{
			conn2 = travelExpertsConnectionDB .dbConnection();
			//Defines new set of variable and set the text fields for each and every text field and get the content of them
			
			int custID = customer.getCustomerID();
			
			String deleteQuery = "delete from customers where CustomerId=?";
			PreparedStatement pstmt = conn2.prepareStatement(deleteQuery);
			pstmt.setInt(1,custID);
			pstmt.execute();
			//Display message if the process completes
			JOptionPane.showMessageDialog(null,"Customer Deleted!");
			pstmt.close();
			pstmt = null;
			conn2.close();
			conn2 = null;
		}catch (Exception ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
		return null;		
	}
}