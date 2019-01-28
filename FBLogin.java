package abcpack;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBLogin {
	
	WebDriver d;
	@BeforeEach
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
	}
	@Test
	public void testFBLogin() throws InterruptedException
	{
		// Load web page
		d.get("https://www.facebook.com/");
		// Verify page title
		assertEquals("Facebook – log in or sign up",d.getTitle());
		// print page title
		//System.out.println(d.getTitle());
		// Enter user name
		assertTrue(d.findElement(By.id("email")).isDisplayed());
		d.findElement(By.id("email")).sendKeys("selenium");
		// Enter password
		d.findElement(By.id("pass")).sendKeys("selenium");
		// Click on Login
		d.findElement(By.xpath("//input[@value='Log In']")).click();
		// Pause 4sec
		Thread.sleep(4000);
	}
	@AfterEach
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
