package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pomPage.CreateProjectPage;
import pomPage.HomePage;
import pomPage.LoginPage;
import pomPage.ProjectPage;

public class BaseAPIClass {
	
	protected JavaLibrary jLib ;
	protected DataBaseLibrary dLib ;
	protected RestAssuredLibrary rLib; 
	protected ResponseSpecification resp;
	protected RequestSpecification req;
	protected WebDriverLibrary web ;
    protected WebDriver driver;
    protected CreateProjectPage createp;
    protected HomePage home ;
    protected LoginPage login ;
    protected ProjectPage project ;
    protected PropertyFileLibrary pLib;
    
	
	
	@BeforeSuite
	public void suiteConfig()  {
		pLib = new PropertyFileLibrary();
		jLib= new JavaLibrary();
		dLib= new DataBaseLibrary();
		rLib= new RestAssuredLibrary();
		web= new WebDriverLibrary();
		dLib.connectToDb();
		req = new RequestSpecBuilder().setBaseUri(IconstantPath.baseUri).setContentType(ContentType.JSON).build();
		resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(StatusCodeLibrary.post).expectResponseTime(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS).build();
		
		
		
	}
	
	@BeforeMethod
	public void methodCon() {
		driver = web.launchBrowser(pLib.fetchDataFromPropertyFile("browser"));
		createp= new CreateProjectPage(driver);
		home= new HomePage(driver);
		login= new LoginPage(driver);
		project= new ProjectPage(driver);
	}
	
	@AfterMethod
	public void AfterMethodCon() {
		web.closeBrowsr();
	}
	
	
	@AfterSuite
	public void asCofig() {
		dLib.closeDB();
		
	
	}
}
