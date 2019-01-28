package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BrowserHistory extends Common
{
	
	@Test
	public void testbrowserHistory() throws InterruptedException
	{
		// Load web page
		d.navigate().to("https://www.seleniumhq.org/");
		// Verify page title
		assertEquals("Selenium - Web Browser Automation",d.getTitle());
		// Click on Download
		d.findElement(By.linkText("Download")).click();
		Thread.sleep(2000);
		d.navigate().back();
		Thread.sleep(2000);
		d.navigate().forward();
		Thread.sleep(2000);
		d.navigate().refresh();
		Thread.sleep(2000);
		
	}
	
}
