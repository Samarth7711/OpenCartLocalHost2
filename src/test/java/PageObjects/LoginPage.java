package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//*[@id=\"input-email\"]")
	WebElement enteremail;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement enterpassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement btnclick;
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[3]")
	WebElement verifylogin;
	
	public void enteremail(String email) {
		enteremail.sendKeys(email);
		
	}
	public void enterpassword(String pwd) {
		enterpassword.sendKeys(pwd);
	}
	public void clicklogin() {
		btnclick.click();
	}
	

}
