import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;


public class AgentDB {

	public static Agent getAgent(int id) throws ClassNotFoundException, SQLException
	{
		Agent agent = new Agent();
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "Select * from agents where agentId = " + id;
		
		try 
		{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				agent.setAgentId(rs.getInt("AgentId"));
				agent.setAgtFirstName(rs.getString("AgtFirstName"));
				agent.setAgtMiddleInitial(rs.getString("AgtMiddleInitial"));
				agent.setAgtLastName(rs.getString("AgtLastName"));
				agent.setAgtBusPhone(rs.getString("AgtBusPhone"));
				agent.setAgtEmail(rs.getString("AgtEmail"));
				agent.setAgtPosition(rs.getString("AgtPosition"));
				agent.setAgencyId(rs.getInt("AgencyId"));
			}
			return agent;
		}
		finally 
		{
			conn.close();
		}
		
	}
	public static Vector<Agent> getAgents() throws ClassNotFoundException, SQLException 
	{
		
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "Select * from agents";
		
		try 
		{
			Vector<Agent> alist = new Vector<Agent>();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				Agent agent = new Agent();
				
				agent.setAgentId(rs.getInt("AgentId"));
				agent.setAgtFirstName(rs.getString("AgtFirstName"));
				agent.setAgtMiddleInitial(rs.getString("AgtMiddleInitial"));
				agent.setAgtLastName(rs.getString("AgtLastName"));
				agent.setAgtBusPhone(rs.getString("AgtBusPhone"));
				agent.setAgtEmail(rs.getString("AgtEmail"));
				agent.setAgtPosition(rs.getString("AgtPosition"));
				agent.setAgencyId(rs.getInt("AgencyId"));
			
				alist.add(agent);
			}
			return alist;
		}
		finally 
		{
			conn.close();
		}

	}
	public static void createAgent(Agent agent) throws ClassNotFoundException, SQLException
	{
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "INSERT into Agents (AgtFirstName, AgtMiddleInitial, AgtLastName, AgtBusPhone, AgtEmail, AgtPosition, AgencyId)"
					+ "values (?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,agent.getAgtFirstName());
		stmt.setString(2,agent.getAgtMiddleInitial());
		stmt.setString(3,agent.getAgtLastName());
		stmt.setString(4,agent.getAgtBusPhone());
		stmt.setString(5,agent.getAgtEmail());
		stmt.setString(6,agent.getAgtPosition());
		stmt.setInt(7,agent.getAgencyId());
		
		stmt.executeUpdate();
		
		conn.close();
	}
	
	public static boolean updateAgent(Agent newAgent, Agent oldAgent) throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		
		String sql = "Update Agents set AgtFirstName = ?, AgtMiddleInitial = ?, AgtLastName = ?, "
				+ "AgtBusPhone = ?, AgtEmail = ?, AgtPosition = ?, AgencyId = ? " +
				"WHERE AgentId = ?";
		
		
		try {
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,newAgent.getAgtFirstName());
			pstmt.setString(2,newAgent.getAgtMiddleInitial());
			pstmt.setString(3,newAgent.getAgtLastName());
			pstmt.setString(4,newAgent.getAgtBusPhone());
			pstmt.setString(5,newAgent.getAgtEmail());
			pstmt.setString(6,newAgent.getAgtPosition());
			pstmt.setInt(7,newAgent.getAgencyId());
			pstmt.setInt(8, oldAgent.getAgentId());
			int rcount = pstmt.executeUpdate();
			
			if (rcount > 0)
			
				return true;
			
			else 
			
				return false;


		}
		finally
		{
			conn.close();
		}
			
	}
	
	public static boolean UpdateAgentCustomers(Integer oldagt,Integer newagt) throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		
		String sql = "Update Customers set agentId = ? WHERE agentId = ?";
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,oldagt);
			pstmt.setInt(2,newagt);
			int count = pstmt.executeUpdate();
			if(count > 0)
				return true;
			else 
				return false;
		}
		finally { 
		
			conn.close(); 
		}
	}
	
}
