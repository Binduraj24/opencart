package seleniumpractice1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
public class checkbox {

	public static void main(String[] args) {
		
  WebDriver driver=new ChromeDriver();
  driver.get("https://testautomationpractice.blogspot.com/");
 List<WebElement>checknboxs= driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
 checknboxs.size();
 /*for(int i=0;i<checknboxs.size();i++) {
	 checknboxs.get(i).click();
	
	 
	 
 }*/
 for(WebElement box:checknboxs) {
	 if(box.isSelected()) {
		 box.click();
	 }
	 else {
		 box.click();
	 }
	
 }
	driver.quit();
	}

}
