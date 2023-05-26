package practice1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[@class=\"ic_circularclose_grey\"]")).click();
		
		driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("DayPicker-Day")));
		String date = "03", year="2023", month="June";
		String MY = month+" "+year;
		
		//boolean flag = false;
		while(true) {
			
			if(driver.findElements(By.xpath("//div[@class='DayPicker-Day' or @aria-disabled='false']")).size()>0)  {
				
				driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,\""+month+" "+date+" "+year+"\")]")).click();
				break;
			}else { 
				driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();

			}
		}
				
					
//		JavascriptExecutor j = (JavascriptExecutor)driver;
//		j.executeScript("window.scrollBy(0,100)");
		
	}
}
