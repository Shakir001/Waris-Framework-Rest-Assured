package pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[.='Projects']") private WebElement projectsModuel;
	@FindBy(xpath="//a[.='Logout']") private WebElement logout;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickProjectModuel() {
		projectsModuel.click();
	}
	
	public void logoutApp() {
		logout.click();
	}
}
