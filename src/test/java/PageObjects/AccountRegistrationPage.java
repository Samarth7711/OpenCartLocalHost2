package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	WebElement txtfname;
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	WebElement txtlname;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement txtemail;
	
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	WebElement txttelephone;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement txtpassword;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	WebElement txtconfirmpass;
	
	@FindBy (xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement clickchkbox;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btncntn;
	
	
	public void FirstName(String fname) {
		txtfname.sendKeys(fname);
	}
	
	public void LastName(String lname) {
		txtlname.sendKeys(lname);
	}
	
	public void email(String email) {
		txtemail.sendKeys(email);
	}
	
	public void telephone(String tele) {
		txttelephone.sendKeys(tele);
	}
	
	public void password(String pass) {
		txtpassword.sendKeys(pass);
	}
	
	public void confirmpass(String pass) {
		txtconfirmpass.sendKeys(pass);
	}
	
	public void setPolicy() {
		clickchkbox.click();
	}
	
	public void setContinue() {
		btncntn.click();
	}
	
		}
	

