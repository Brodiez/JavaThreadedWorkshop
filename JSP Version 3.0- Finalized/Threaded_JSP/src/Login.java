//Coded by: Anushka De Silva
//Functionality: Do the SQL functionality for login into web-site and updating customer information
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {
	
	//Public function to validate customer
	public static boolean validate(String name, String pass){
		boolean status = false;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		//Database Connection Strings
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "travelexperts";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String passWord = "";
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url +dbName,userName,passWord);
			
			//Select SQL Statement where it check for Customer based on login authentication values
			String selectSql = "select * from Customers where CustFirstName=? and CustLastName=?";
			pStmt = conn.prepareStatement(selectSql);
			
			//Set Parameters for the Select SQL Statement
			pStmt.setString(1, name);
			pStmt.setString(2, pass);
			
			//Get Result set using execute query
			rs = pStmt.executeQuery();			
			status = rs.next();
		
		//If Something gone wrong then this will print the error	
		}catch (Exception e){
			System.out.println(e);
		//Closing Database Connection	
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException sex){
					System.out.println(sex);
				}
			}
			//Closing up Prepared Statement
			if(pStmt != null){
				try{
					pStmt.close();
				}catch(SQLException sex){
					System.out.println(sex);
				}
			}
			//Closing up Result Set Statement
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException sex){
					System.out.println(sex);
				}
			}	
		}
		return status;
	}
	//Method for Customer Update Information
	public static boolean updateCustomer(String FirstName, String LastName, String Address, String City, String Province, String Country, String Postal, String HPhone, String BPhone, String Email)
	{
		boolean status = false;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		//Database Connection Strings
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "travelexperts";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String passWord = "";
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url +dbName,userName,passWord);
			
			//Update SQL Statement for currently logged in customer
			String updateSql = "Update customers set CustLastName=?, CustAddress=?, CustCity=?, CustProv=?, CustPostal=?, CustCountry=?, CustHomePhone=?, CustBusPhone=?, CustEmail=? where CustFirstName=?";
			pStmt = conn.prepareStatement(updateSql);
			
			//Setting up Strings
			pStmt.setString(1, LastName);
			pStmt.setString(2, Address);
			pStmt.setString(3, City);
			pStmt.setString(4, Province);
			pStmt.setString(5, Postal);
			pStmt.setString(6, Country);
			pStmt.setString(7, HPhone);
			pStmt.setString(8, BPhone);
			pStmt.setString(9, Email);
			pStmt.setString(10, FirstName);
			
			int i;
			i = pStmt.executeUpdate();
			//Close Prepared Statement and set it to null
			pStmt.close();
			pStmt = null;
			
			//Close Connection and set it to null
			conn.close();
			conn = null;
			//Based on update setting up whether Customer get Updated or Not
			if (i > 0)
			{
				return true;
			}
			else
				return false;
			
			
		}catch (Exception ex)
		{
			System.out.println(ex);
			//ex.printStackTrace();
		}
		return status;
	}
}
