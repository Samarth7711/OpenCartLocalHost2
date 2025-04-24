package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver ) {
		super(driver);	
	}
	
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement lnkmyaccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement lnkregister;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement lnklogin;
	
	public void clickMyaccount() {
		lnkmyaccount.click();
}
	public void clickregister() {
		lnkregister.click();
	}
	
	public void clicklogin() {
		lnklogin.click();
	}


}
