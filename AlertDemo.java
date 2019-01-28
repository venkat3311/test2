package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertDemo {
	
	WebDriver d;
	@Test
	public void testAlert() throws InterruptedException
	{
		// Load web page
		d.get("https://retail.onlinesbi.com/retail/login.htm");
		// Verify page title
		assertEquals("State Bank of India - Personal Banking",d.getTitle());
		// Click on CONTINUE TO LOGIN
		d.findElement(By.linkText("CONTINUE TO LOGIN")).click();
		// Click on Login
		d.findElement(By.id("Button2")).click();
		// Switch driver focus to alert
		Alert al=d.switchTo().alert();
		// Verify alert text
		assertEquals("Enter username",al.getText());
		// Ok
		al.accept();
		// Enter user name
		d.findElement(By.id("username")).sendKeys("selenium");
		// Click on Login
		d.findElement(By.id("Button2")).click();
		// ok
		al.accept();
		// Enter password
		d.findElement(By.name("password")).sendKeys("selenium");
		Thread.sleep(3000);
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
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@AfterEach
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
