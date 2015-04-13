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
		String dbName = "travelexpert";
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
}
