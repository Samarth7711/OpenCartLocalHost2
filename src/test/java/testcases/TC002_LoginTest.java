package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccount;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test()
	public void verifylogin() {
		logger.info("********Starting TC002_LoginTest********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clicklogin();
		
		
		LoginPage lp=new LoginPage(driver);
		lp.enteremail(p.getProperty("email"));
		//lp.enterpassword(p.getProperty("password"));
		lp.enterpassword(p.getProperty("password"));
		lp.clicklogin();
		
		
		MyAccount macc=new MyAccount(driver);
		boolean targetPage=macc.isMyloginexists();
		Assert.assertEquals(targetPage, true,"Login Failed");
		}
		catch(Exception e){
			Assert.fail();
			
		}
		
	}

}
