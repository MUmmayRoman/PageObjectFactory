package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page {
	
	final WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "Log out")
	public WebElement link_LogOut;
	

	public Home_Page(WebDriver driver) 
	{
		this.driver = driver;
	}

}
