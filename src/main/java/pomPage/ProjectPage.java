package pomPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
	
	
	@FindBy(xpath="//button[@class=\"btn btn-success\"]") private WebElement createButton;
	@FindBy(xpath="//input[@value=\\\"Delete\\\"]") private WebElement deleteButton;
	@FindBy(xpath="//tbody/tr/td[1]") private List<WebElement> list; 
	
	
	public ProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateButton() {
		createButton.click();
	}
	
	public void clickDeleteButton() {
		deleteButton.click();
	}
	
	public String getProjectId(WebDriver driver) {
		String projectName = "Agni";
		String pId = driver.findElement(By.xpath("//td[.='"+projectName+"']/preceding-sibling::td")).getText();
		return pId;
	}

	public void listOfProject(String projectId) {
		boolean flag=false;
		for (int i=0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase(projectId)) {
				flag=true; break;
			}
		}
		if(flag) {
			System.out.println("project is present in gui");
		}else {
			System.out.println("project is not present in gui");
		}
	}
}
