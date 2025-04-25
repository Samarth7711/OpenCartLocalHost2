package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{
	
	
	public MyAccount (WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@id=\"content\"]/h2[3]")
	WebElement verifyLogin;
	
	
	public boolean isMyloginexists() {
		try
		{
		return(verifyLogin.isDisplayed());
		}
		catch(Exception e ) {
			return false; 
		}
	}

} 