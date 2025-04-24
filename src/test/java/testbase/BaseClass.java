package testbase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public Logger logger;
	public Properties p;
	
public WebDriver driver;
	
	@BeforeClass
	public void setup() throws IOException {
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		
		logger =LogManager.getLogger(this.getClass());
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samarth Patil\\eclipse-workspace\\OpenCartLocalHost2\\rsources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public String randomNumber() {
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
		
	}
	
	public String randomAlphaNumeric() {
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		String Alphanumeric=(generatedString+generatedNumber);
		return Alphanumeric;
	}

}
