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
	//Define Database Connection
	static Connection conn = null;
	
	//Method to Add a Customer to Database
	public static String AddCustomer(Customer customer)
	{
		String customerId ="";
		try {
			//Assign Database Connection to conn variable
			conn = travelExpertsConnectionDB .dbConnection();
			
			//Insert Statement
			String insertQuery =  "INSERT INTO customers (CUSTFIRSTNAME,CUSTLASTNAME,CUSTADDRESS,CUSTCITY,CUSTPROV,CUSTPOSTAL,CUSTCOUNTRY,CUSTHOMEPHONE,CUSTBUSPHONE,CUSTEMAIL,AGENTID,USERNAME,PASSWORD)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//Assign Insert Statement as Prepared Statement
			PreparedStatement pStmt = conn.prepareStatement(insertQuery);
			
			//Setting Strings for Insert Statement's values
			pStmt.setString(1, customer.getCustFirstName());
			pStmt.setString(2, customer.getCustLastName());
			pStmt.setString(3, customer.getCustAddress());
			pStmt.setString(4, customer.getCustCity());
			pStmt.setString(5, customer.getCustProv());
			pStmt.setString(6, customer.getCustPostal());
			pStmt.setString(7, customer.getCustCountry());
			pStmt.setString(8, customer.getCustHomePhone());
			pStmt.setString(9, customer.getCustBusPhone());
			pStmt.setString(10, customer.getCustEmail());
			pStmt.setString(11, customer.getAgentId());
			pStmt.setString(12, customer.getUserName());
			pStmt.setString(13, customer.getPassword());
			pStmt.executeUpdate();
		
			//Close Prepared Statement
			pStmt.close();
			
			//Make Prepared Statement variable as null
			pStmt = null;
			
			//Close Connection and reassign conn variable as null
			conn.close();
			conn = null;
			
			//Catch Statements
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}		
		return customerId;
	}
	//Define Database Connection
	static Connection conn1 = null;
	
	//Method to Update a Customer to Database
	public static String UpdateCustomer(Customer customer)
	{
		try
		{
			//Assign Database Connection to conn variable
			conn1 = travelExpertsConnectionDB .dbConnection();
			
			//Defines some local variables and get customer information from Customer Class and set them for local variables
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
			
			//Update Statement
			String updateQuery = "Update customers set CustFirstName='"+ custFirstName +"', CustLastName='"+ custLastName +"', CustAddress='"+ custAddress +"', CustCity='"+ custCity +"', CustProv='"+ custProv +"', CustPostal='"+ custPostal +"', CustCountry='"+ custCountry +"', CustHomePhone='"+ custHomePhone +"', CustBusPhone='"+ custBusPhone +"', CustEmail='"+ custEmail +"', AgentId='"+ custAgtID +"', UserName='"+ custUName +"', Password='"+ custPassword+ "' where CustomerId='"+ custID +"'";
			
			//Assign Update Statement as Prepared Statement and Execute Prepared Statement
			PreparedStatement pstmt = conn1.prepareStatement(updateQuery);
			pstmt.execute();
			
			//Display message if the process completes
			JOptionPane.showMessageDialog(null,"Data Updated Successfully!");
			
			//Close Prepared Statement and set it to null
			pstmt.close();
			pstmt = null;
			
			//Close Connection and set it to null
			conn1.close();
			conn1 = null;
			
			//Catch statements
		}catch (Exception ex)
		{
			System.out.println(ex);
			//ex.printStackTrace();
		}
		return null;		
	}
	//Define Database Connection
	static Connection conn2 = null;
	
	//Method to Delete a Customer to Database
	public static String DeleteCustomer(Customer customer)
	{
		try
		{
			//Assign Database Connection to conn variable
			conn2 = travelExpertsConnectionDB .dbConnection();
			
			//Defines local variable and set up Customer's ID through Customer ID Getter 
			int custID = customer.getCustomerID();
			
			//Delete Statement
			String deleteQuery = "delete from customers where CustomerId=?";
			
			//Assign Delete Statement as Prepared Statement and Execute Prepared Statement
			PreparedStatement pstmt = conn2.prepareStatement(deleteQuery);
			
			//Setting up Prepared Statement and execute it
			pstmt.setInt(1,custID);
			pstmt.execute();
			
			//Display message if the process completes
			JOptionPane.showMessageDialog(null,"Customer Deleted!");
			
			//Prepared Statement Close and set it null
			pstmt.close();
			pstmt = null;
			
			//Set Conn close and make it null
			conn2.close();
			conn2 = null;
			
			//Catch Statement
		}catch (Exception ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
		return null;		
	}
}