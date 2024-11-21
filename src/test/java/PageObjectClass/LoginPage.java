package PageObjectClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Basepage {
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email_login;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement login_submit;

    // Action methods
    public void user_email(String email) {
        // Wait for the email field to be visible before interacting
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(email_login));
        email_login.sendKeys(email);
    }

    public void usr_password(String pw) {
        // Wait for the password field to be visible before interacting
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pw);
    }

    public void login() {
        // Wait for the login button to be clickable before clicking
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(login_submit));
        login_submit.click();
    }
}
