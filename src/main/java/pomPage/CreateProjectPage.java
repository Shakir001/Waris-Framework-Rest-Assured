package pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.WebDriverLibrary;

public class CreateProjectPage {
	
	@FindBy(name="projectName") private WebElement projectName;
	@FindBy(name="createdBy") private WebElement createdBy;
	@FindBy(name="status") private WebElement statusDropDown;
	@FindBy(xpath="//input[@value=\"Add Project\"]") private WebElement addProject;
	
	
	public CreateProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createProject(WebDriverLibrary web, String projectname, String createdby, int index) {
		projectName.sendKeys(projectname);
		createdBy.sendKeys(createdby);
		web.dropDown(statusDropDown, index);
		addProject.click();
		
	}

}
