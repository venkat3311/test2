package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDDemo {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		// Load web page
		d.get("https://www.facebook.com/");
		// DD
		Select dd=new Select(d.findElement(By.id("month")));
		dd.selectByIndex(3);
		Thread.sleep(1000);
		dd.selectByValue("5");
		Thread.sleep(1000);
		dd.selectByVisibleText("Jun");
		Thread.sleep(1000);
		// Print selected option
		System.out.println("Selected options is:"+dd.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		// close browser
		d.quit();

	}

}
