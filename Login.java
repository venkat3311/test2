package abcpack;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver d;
	@Test
	public void testLogin() throws InterruptedException
	{
		// Load web page
		d.get("https://demo.cyclos.org/");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		// Click on Sign in
		d.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		// Enter user name
		d.findElement(By.name("principal")).clear();
		d.findElement(By.name("principal")).sendKeys("demo");
		String uname=d.findElement(By.name("principal")).getAttribute("value");
		// Enter password
		d.findElement(By.name("password")).clear();
		d.findElement(By.name("password")).sendKeys("fsgdfgfh");
		String password=d.findElement(By.name("password")).getAttribute("value");
		// Click on Sign In button
		d.findElement(By.cssSelector("button.actionButton")).click();
		Thread.sleep(2000);
		
		// Blank user name & Blank password
		if(uname.equals("") && password.equals(""))
		{
			assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine > ul")).getText().contains("Login name is required\nPassword is required"));
		}
		// Blank user name & Valid/Invalid password
		else if(uname.equals("") && !(password.equals("")))
		{
			assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine > ul")).getText().contains("Login name is required"));
		}
		// Blank password & Valid/Invalid user name
		else if(!(uname.equals("")) && password.equals(""))
		{
			assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine > ul")).getText().contains("Password is required"));
		}
		// Valid user name & Valid password
		else if(isElementPresent(d,By.linkText("Logout")))
		{
			// Click on Logout
			d.findElement(By.linkText("Logout")).click();
		}
		// Invalid username & Invalid password
		else
		{
			assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("The given name / password are incorrect"));
		}
		

		Thread.sleep(3000);
	}
	private boolean isElementPresent(WebDriver driver,By by) 
	{
	    driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	}
	@BeforeMethod
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
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
