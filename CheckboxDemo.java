package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckboxDemo {

	public static void main(String[] args) throws InterruptedException {
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		// Load web page
		d.get("http://book.theautomatedtester.co.uk/chapter1");
		WebElement e=d.findElement(By.name("selected(1234)"));
		if(e.isSelected())
		{
			System.out.println("Check box is already selected");
		}
		else
		{
			e.click();
		}
		Thread.sleep(3000);
		// Close browser
		d.quit();

	}

}
