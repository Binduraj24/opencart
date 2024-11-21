package PageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage  extends Basepage{

	public  Homepage(WebDriver driver) {
		super(driver);
		
	}
	//webelement locater
	@FindBy(xpath="//a[@title='My Account']")
	WebElement accname ;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;

	//action methods
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	public void account_usr() {
	   accname.click();
	}
	public void register_user() {
	register.click();
	}
	public void login() {
		login.click();
	}
	
}
