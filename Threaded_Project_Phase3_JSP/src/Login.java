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
		String dbName = "travelexperts1";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String passWord = "";
		Customer customer = new Customer();
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
	public static Customer getCustomerData(String firstName, String lastName){
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "travelexperts1";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String passWord = "";
		Customer customer = new Customer();
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url +dbName,userName,passWord);
			
			String selectSql = "select * from Customers where CustFirstName=? and CustLastName=?";
			pStmt = conn.prepareStatement(selectSql);
			pStmt.setString(1, firstName);
			pStmt.setString(2, lastName);
			
			rs = pStmt.executeQuery();			
			rs.next();
			System.out.println("FUCK ME!");
			customer.setCustomerID(rs.getInt("CustomerID"));
			customer.setCustFirstName(rs.getString("CustFirstName"));
			customer.setCustLastName(rs.getString("CustLastName"));
			customer.setCustAddress(rs.getString("CustAddress"));
			customer.setCustCity(rs.getString("CustCity"));
			customer.setCustProv(rs.getString("CustProv"));
			customer.setCustPostal(rs.getString("CustPostal"));
			customer.setCustCountry(rs.getString("CustCountry"));
			customer.setCustHomePhone(rs.getString("CustHomePhone"));
			customer.setCustBusPhone(rs.getString("CustBusPhone"));
			customer.setCustEmail(rs.getString("CustEmail"));
			
			//return customer;
			
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
		return customer;
	}
}
