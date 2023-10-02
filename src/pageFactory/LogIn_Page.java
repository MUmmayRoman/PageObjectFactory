package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogIn_Page {
	
	final WebDriver driver;
	
	
	@FindBy(how = How.NAME, using = "uid")
	public WebElement text_UserName; 
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement text_Password;
	
	@FindBy(how = How.NAME, using = "btnLogin")
	public WebElement btn_Login;

	public LogIn_Page(WebDriver driver) 
	{
		this.driver = driver;
	}

}
