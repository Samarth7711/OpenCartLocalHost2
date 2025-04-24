package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import testbase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test
	public void AccountVerification() {
		logger.info("******Starting TC001_AccountRegistrationTest**** ");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickregister();
		
		AccountRegistrationPage rpage=new AccountRegistrationPage(driver);
		rpage.FirstName(randomString().toUpperCase());
		rpage.LastName(randomString().toUpperCase());
		rpage.email(randomString()+"@gmail.com");
		rpage.telephone(randomNumber());
		
		String password=randomAlphaNumeric();	
		rpage.password(password);
		rpage.confirmpass(password);
		rpage.setPolicy();
		rpage.setContinue();
		
		String confmsg=rpage.msfconfirm();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	
	
	 

}
