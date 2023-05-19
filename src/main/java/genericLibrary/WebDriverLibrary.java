package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverLibrary {
	
	WebDriver driver;
	public void dropDown(WebElement webelement, int index) {
		
		Select s = new Select(webelement);
		s.selectByIndex(index);
	}
	
	public void dropDown(WebElement webelement, String value) {
		Select s = new Select(webelement);
		s.selectByValue(value);
	}
	
	public void dropDown(String text , WebElement webelement ) {
		Select s = new Select(webelement);
		s.selectByVisibleText(text);
	}
	
	public WebDriver launchBrowser(String browser) {
		
		switch (browser) {
		
		case "chrome": WebDriverManager.chromedriver().setup();
		               driver = new ChromeDriver();
		               break;
		case "edge"  : WebDriverManager.edgedriver().setup();
		               driver = new EdgeDriver();
		               break;
		default      : System.out.println("enter valid browser");               
		}
		driver.get(IconstantPath.baseUri);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void closeBrowsr() {
		driver.close();
	}
}
