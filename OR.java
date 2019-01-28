package abcpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OR {
	
	OR(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	@FindBy(linkText="Sign in") WebElement lnkSignin;
	@FindBy(name="principal") WebElement txtUsername;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(css="button.actionButton") WebElement btnSignin;
	@FindBy(linkText="Logout") WebElement lnkLogout;
	
	public void fillLogin(String uname,String password)
	{
		lnkSignin.click();
		txtUsername.sendKeys(uname);
		txtPassword.sendKeys(password);
		btnSignin.click();
	}

}
