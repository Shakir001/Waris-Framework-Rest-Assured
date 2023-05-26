import java.util.HashMap;

public class Shoppersstack {
	
	
	public static void main(String[]args) {
		
		String s="santhosh";
		HashMap<String, Integer> map=new HashMap<>();
		char[] t = s.toCharArray();
		int count=0;
		for(int i=0;i<t.length;i++)
		{
			count++;
			map.put(s, count);
		}
		System.out.println(map);
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.covid19india.org/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String odisha = driver.findElement(By.xpath("//div[@class=\"state-name fadeInUp\" and .='Odisha']")).getText();
//		
//		System.out.println(odisha);
//		baseURI = "https://www.shoppersstack.com/shopping";
//		
//		JSONObject j = new JSONObject();
//		j.put("email", "abc@gmail.com");
//		j.put("password", "xyz");
//		j.put("role", "ADMIN");
////		j.put("firstName", "abc");
////		j.put("gender", "male");
////		j.put("lastName", "xyz");
////		j.put("password", "xyz456");
////		j.put("phone", 998877665);
////		j.put("state", "karnataka");
////		j.put("zoneId", "xyz123");
//		given()
//		.body(j)
//		.contentType(ContentType.JSON)
//		
//		
//		.when()
//		.post("/users/login")
//		
//		.then()
////		.assertThat()
////		.statusCode(200)
////		.contentType(ContentType.JSON)
////		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
//		.log().all();
		
		
	}

}
