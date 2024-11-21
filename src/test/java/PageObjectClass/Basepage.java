package PageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Basepage
{
 WebDriver driver;

public Basepage(WebDriver driver) {
	 
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	 
 }

}