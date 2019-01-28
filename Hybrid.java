package abcpack;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hybrid {
	
	WebDriver d;
	ExcelUtils excel;
	@Test
	public void testLogin() throws InterruptedException
	{
		// Load web page
		d.get("https://demo.cyclos.org/");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		
		OR page=new OR(d);
		page.fillLogin(excel.getCellData(1,0), excel.getCellData(1,1));
	
		Thread.sleep(2000);
		page.lnkLogout.click();
		Thread.sleep(2000);
		
	}
	@BeforeMethod
	public void setUp() throws Exception
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//WebDriver d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\Driver Server\\IEDriverServer.exe");
		//WebDriver d=new InternetExplorerDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
		excel=new ExcelUtils("E:\\Selenium_Scripts_Aug18\\Test Data\\Login.xlsx","Sheet1");
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
