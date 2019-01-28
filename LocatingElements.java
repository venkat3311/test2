package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatingElements {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		// Load web page
		d.get("https://www.google.com/");
		// Type text
		// ID
		//d.findElement(By.id("lst-ib")).sendKeys("Selenium");
		// Name
		//d.findElement(By.name("q")).sendKeys("Appium");
		// ClassName
		//d.findElement(By.className("gsfi")).sendKeys("Cucumber framework");
		// Link Text
		//d.findElement(By.linkText("Gmail")).click();
		// Partial link text
		//d.findElement(By.partialLinkText("in")).click();
		// XPath
		//d.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		// Tag Name
		//System.out.println("No of links:"+d.findElements(By.tagName("a")).size());
		// CSS
		d.findElement(By.cssSelector("a.gb_P")).click();
		
		// Pause 4sec
		Thread.sleep(4000);
		// Close browser
		d.quit();

	}

}
