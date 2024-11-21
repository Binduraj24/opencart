package Testng;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Dataprovidermethod {
WebDriver driver;
@Parameters({"browser"})
@BeforeClass
	void setup(String br) {
	switch(br.toLowerCase()){
	case  "chrome":driver=new ChromeDriver();break;
	case "edge":driver=new EdgeDriver();break;
	case "firefox":driver=new FirefoxDriver();break;
	default:System.out.println("invalid broser");
	return;
	
		
	}
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
 @Test(dataProvider="dp")
 void login() throws InterruptedException {
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();

	    // Login steps
	    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	    // Use WebDriverWait instead of Thread.sleep()
	  
	    // Wait for the Dashboard element to be visible
	  //h6[normalize-space()='Dashboard']"))).isDisplayed();

	    
	}
 @Test
 void apptitle() {
	 System.out.println("binduraj");
 }
 @AfterClass
 void teardown() {
	 driver.close();
	 
 }
 /*@DataProvider(name="dp")
 Object[][] testdata() {
	 Object data[][]= {
			 {"testuser1@example.com", "password123"},
	            {"testuser2@example.com", "password456"},
	            {"testuser3@example.com", "password789"}
	 };
	 return data;
 }*/
	
}

