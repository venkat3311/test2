package abcpack;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmationDemo {
	
	WebDriver d;
	@Test
	public void testConfirmation() throws InterruptedException
	{
		// Load web page
		d.get("http://output.jsbin.com/enifaf");
		// Click button
		d.findElement(By.cssSelector("button")).click();
		Thread.sleep(2000);
		d.switchTo().alert().dismiss();
		Thread.sleep(2000);
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
