package automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageFactory.Home_Page;
import pageFactory.Log;
import pageFactory.LogIn_Page;

public class TestCase {
	
	static WebDriver driver;
	
	LogIn_Page loginpage;
	
	Home_Page homepage;
	
	@BeforeClass
	public void setup() throws InterruptedException 
	{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("sTestCaseName");
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("Opening the chrome browser");
		Thread.sleep(2000);
		
		String url = "https://demo.guru99.com/V4/index.php";
		driver.get(url);
		Log.info("Entering the Url");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		homepage  = PageFactory.initElements(driver, Home_Page.class);
		loginpage  = PageFactory.initElements(driver, LogIn_Page.class);
	}
	
	@AfterClass
	public void tear() 
	{
		driver.close();
		driver.quit();
		
		Log.info("Closing the browser");
		Log.endTestCase("THIS IS AN END");
		
	}
	
	@Test
	public void login() throws InterruptedException 
	{
		loginpage.text_UserName.clear();
		loginpage.text_UserName.sendKeys("mngr511845");
		Thread.sleep(2000);
		Log.info("Entering the Username");
		
		loginpage.text_Password.clear();
		loginpage.text_Password.sendKeys("jYmetet");
		Thread.sleep(2000);
		Log.info("Entering the Password");
		

		loginpage.btn_Login.click();
		Thread.sleep(2000);
		Log.info("Clicking the Login button");
		
		homepage.link_LogOut.click();
		Thread.sleep(2000);
		Log.info("Clicking the Logout link");
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}

}
