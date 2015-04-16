import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {
	public static boolean validate(String name, String pass){
		boolean status = false;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "travelexperts";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String passWord = "";
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url +dbName,userName,passWord);
			
			String selectSql = "select * from Customers where CustFirstName=? and CustLastName=?";
			pStmt = conn.prepareStatement(selectSql);
			pStmt.setString(1, name);
			pStmt.setString(2, pass);
			
			rs = pStmt.executeQuery();			
			status = rs.next();
			
		}catch (Exception e){
			System.out.println(e);
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException sex){
					System.out.println(sex);
				}
			}
			if(pStmt != null){
				try{
					pStmt.close();
				}catch(SQLException sex){
					System.out.println(sex);
				}
			}
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
	public static boolean updateCustomer(String FirstName, String LastName, String Address, String City, String Province, String Country, String Postal, String HPhone, String BPhone, String Email)
	{
		boolean status = false;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "travelexperts";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String passWord = "";
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url +dbName,userName,passWord);
			
			String updateSql = "Update customers set CustLastName=?, CustAddress=?, CustCity=?, CustProv=?, CustPostal=?, CustCountry=?, CustHomePhone=?, CustBusPhone=?, CustEmail=? where CustFirstName=?";
			pStmt = conn.prepareStatement(updateSql);
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
