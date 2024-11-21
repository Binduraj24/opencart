package PageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Basepage
{
	
public RegistrationPage(WebDriver driver) {
	super(driver);
	}

@FindBy(xpath="//input[@id='input-firstname']")
WebElement firstname;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement lastname;
@FindBy(xpath="//input[@id='input-email']")
WebElement email;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement telephone;
@FindBy(xpath="//input[@id='input-password']")
WebElement pwd;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement confirmpwd;
@FindBy(xpath="//input[@value='0']")
WebElement radiobtn;
@FindBy(xpath="//input[@name='agree']")
WebElement checkbox;

@FindBy(xpath="//input[@value='Continue']")
WebElement submit;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgconfirmation;

public void userfname(String fname) {
	firstname.sendKeys(fname);
}
public void userlname(String lname) {
	lastname.sendKeys(lname);
}
public void useremal( String emails) {
	email.sendKeys( emails);
}
public void userphone(String phone) {
	telephone.sendKeys(phone);
}
public void userpassword(String password) {
	pwd.sendKeys(password);
}
public void userpasswordconfirm(String password) {
	confirmpwd.sendKeys(password);
}
public void userradiobtn() {
	radiobtn.click();
}
public void usercheckbox() {
	checkbox.click();
}
public void usersubmit() {
	submit.click();
}


public String getconfirmationmsg() {
	try {
	return (msgconfirmation.getText());
}
	catch(Exception e) {
		return(e.getMessage());
	}
}
}