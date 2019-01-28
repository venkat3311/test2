package abcpack;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiFrame {
		
	WebDriver d;
	@Test
	public void testFrame() throws InterruptedException
	{
		// Load web page
		d.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		System.out.println("No of frame:"+d.findElements(By.tagName("frame")).size());
		// Switch driver focus to 1st frame
		d.switchTo().frame(0);
		d.findElement(By.linkText("com.thoughtworks.selenium")).click();
		Thread.sleep(1000);
		// Switch driver focus outside frame
		d.switchTo().defaultContent();
		// Switch driver focus to 2nd frame
		d.switchTo().frame(1);
		d.findElement(By.linkText("Selenium")).click();
		Thread.sleep(1000);
		// Switch driver focus outside frame
		d.switchTo().defaultContent();
		// Switch driver focus to 3rd frame
		d.switchTo().frame(2);
		d.findElement(By.linkText("WebDriverBackedSelenium")).click();
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
