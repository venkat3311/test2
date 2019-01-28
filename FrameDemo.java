package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameDemo {
	
	WebDriver d;
	@Test
	public void testFrame() throws InterruptedException
	{
		// Load web page
		d.get("http://jqueryui.com/autocomplete/");
		// Verify page title
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		// Switch driver focus to frame
		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		// Type text
		d.findElement(By.id("tags")).sendKeys("selenium");
		Thread.sleep(2000);
		// Switch driver focus out side frame
		d.switchTo().defaultContent();
		// Click on Button
		d.findElement(By.linkText("Button")).click();
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
