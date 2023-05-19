package pojoClass1;

public class Worker {
	
	
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	public Worker(String createdBy, String projectName, String status, int teamSize ) {
		this.createdBy=createdBy;
		this.projectName=projectName;
		this.status=status;
		this.teamSize=teamSize;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getTeamSize() {
		return teamSize;
	}

}
