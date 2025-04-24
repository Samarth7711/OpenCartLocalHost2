package testcases;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test
	public void verifylogin() {
		logger.info("********Starting TC002_LoginTest********");
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clicklogin();
		
		
		LoginPage lp=new LoginPage(driver);
		lp.enteremail(p.getProperty("email"));
		lp.enterpassword(p.getProperty("password"));
		lp.clicklogin();
		
	}

}
