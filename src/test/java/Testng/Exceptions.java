package Testng;

import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test; 
public class Exceptions {
	WebDriver driver;
	@Test
	public void search() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			WebElement s=driver.findElement(By.xpath("//input[@placeholder='Search']"));
			s.sendKeys("iphone");
			s.click();
			Thread.sleep(3000);
			Assert.assertTrue(true);
		}
		catch(NoSuchElementException e) {
			System.out.println("element not found"+ e.getMessage());
			
		}
		driver.close();
	}
	

}
