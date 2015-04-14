// Brodie Zoschke - created Apr 06 8:30
public class Agent {
	
	private int agentId;
	private String agtFirstName;
	private String agtMiddleInitial;
	private String agtLastName;
	private String agtBusPhone;
	private String agtEmail;
	private String agtPosition;
	private int agencyId;
	
	//Getters and Setters for the initialized variables
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getAgtFirstName() {
		return agtFirstName;
	}
	public void setAgtFirstName(String agtFirstName) {
		this.agtFirstName = agtFirstName;
	}
	public String getAgtMiddleInitial() {
		return agtMiddleInitial;
	}
	public void setAgtMiddleInitial(String agtMiddleInitial) {
		this.agtMiddleInitial = agtMiddleInitial;
	}
	public String getAgtLastName() {
		return agtLastName;
	}
	public void setAgtLastName(String agtLastName) {
		this.agtLastName = agtLastName;
	}
	public String getAgtBusPhone() {
		return agtBusPhone;
	}
	public void setAgtBusPhone(String agtBusPhone) {
		this.agtBusPhone = agtBusPhone;
	}
	public String getAgtEmail() {
		return agtEmail;
	}
	public void setAgtEmail(String agtEmail) {
		this.agtEmail = agtEmail;
	}
	public String getAgtPosition() {
		return agtPosition;
	}
	public void setAgtPosition(String agtPosition) {
		this.agtPosition = agtPosition;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	
	@Override
	public String toString(){
		return agtFirstName +" "+ agtLastName;
	}
	
	
}
