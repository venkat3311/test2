package abcpack;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenshotOnFailue {
	
	WebDriver d;
	
	String tname;
	@Rule 
	public TestName name = new TestName();
	@Test
	public void testAjax(TestInfo info) throws InterruptedException, Exception
	{
		tname=info.getDisplayName();
		//System.out.println(info.getTestMethod());
		assertEquals("Pass",getScreenshot());	
		Thread.sleep(4000);
		
	}
	public String getScreenshot() throws Exception
	{
		try
		{
			// Load web page
			d.get("https://www.veethi.com/places/india_banks-ifsc-codes.html");
			// Verify page title
			assertEquals("Bank IFSC Codes: Find IFSC for Major Banks in India",d.getTitle());
			selectOption(d.findElement(By.id("selBank")),"Axis Bank");
			selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
			selectOption(d.findElement(By.id("selCity")),"Hyderabad");
			selectOption(d.findElement(By.id("selBranch")),"Madhapur123");
			return "Pass";
		}
		catch(Exception e)
		{
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date();
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("E:\\Selenium_Scripts_Sep18\\Results\\"+tname+df.format(dt)+".png"));
			return "Fail";
		}

	}
	
	public void selectOption(WebElement locator,String optionname)
	{
		Select dd=new Select(locator);
		dd.selectByVisibleText(optionname);
	}
	
	@BeforeEach
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//WebDriver d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\Driver Server\\IEDriverServer.exe");
		//WebDriver d=new InternetExplorerDriver();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@AfterEach
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
