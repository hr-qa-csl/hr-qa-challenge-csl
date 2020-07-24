package test;

public class SeleniumTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "*/hrproject/src/app/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void happyReturnsSearch() {
		String hrSlogan = "Happy Returns makes returns beautiful for retailers, shoppers";
		
		driver.get("https://google.com");
		WebElement searchFiled = driver.findElement(By.title("Search"));
		searchField.sendKeys("Happy Returns");
		String linkText = driver.findElement(by.className("LC20lb DKV0Md")).getText();
		Assert.assertTrue(linkText.contains(hrSlogan));
	}
	
}
