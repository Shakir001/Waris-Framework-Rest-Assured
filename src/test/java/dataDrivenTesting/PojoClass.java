package dataDrivenTesting;

public class PojoClass {
	
	String createdBy;
	String projectName;
	
	public PojoClass(String createdBy, String projectName) {
		this.createdBy=createdBy;
		this.projectName=projectName;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public String getProjectName() {
		return projectName;
	}

}
