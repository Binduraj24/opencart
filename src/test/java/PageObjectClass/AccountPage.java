package PageObjectClass;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends Basepage{

	public AccountPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement accounttext ;
	
	//@FindBy(xpath="//a[contains(@href, 'route=account/logout') and contains(text(), 'Logout')]")
	//WebElement logout;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	

	
	public boolean usr_account() 
	{
		try {
		return (accounttext.isDisplayed());
	}
		catch(Exception e) {
			return (false);
		}
		
	}
	
	public void clicklogout() {
		lnkLogout.click();
		}

}

