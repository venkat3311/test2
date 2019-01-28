package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementNotPresent {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		// Load web page
		d.get("https://www.onlinesbi.com/");
		// Click on Corporate Internet Banking
		d.findElement(By.linkText("Corporate Internet Banking")).click();
		Thread.sleep(2000);
		// Close browser
		d.quit();

	}

}
