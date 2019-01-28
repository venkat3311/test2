package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDD {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		// Load web page
		d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		// Switch driver focus to frame
		d.switchTo().frame("iframeResult");
		// Multi DD
		Select dd=new Select(d.findElement(By.name("cars")));
		for(int i=0;i<dd.getOptions().size();i++)
		{
			dd.selectByIndex(i);
			System.out.println(dd.getAllSelectedOptions().get(i).getText());
		}
		Thread.sleep(2000);
		dd.deselectAll();
		Thread.sleep(2000);
		// Close the browser
		d.quit();

	}

}
