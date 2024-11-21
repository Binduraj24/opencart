package seleniumpractice1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
public class firsturldemo {

	public static void main(String[] args) {
		
		//intialisatin it will lanch the chrome browser
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//get method open a webpage
		driver.get("http://localhost/opencart/upload/");
		String actual_title=driver.getTitle();
		
		
		WebElement searchbox=driver.findElement(By.name("search"));
		searchbox.sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		//driver.findElement(By.xpath("//button[@type='button']")).click();
		
		boolean logo=driver.findElement(By.xpath("//img[@title='Your Store']")).isDisplayed();
		System.out.println("displayed logo "+logo);
		//capturing the links and printing linktext and href attribute
		List<WebElement> headerlinks=driver.findElements(By.cssSelector("#top-links ul.list-inline li a"));
		headerlinks.size();
		System.out.println(headerlinks.size());
		for(WebElement link:headerlinks) {
			System.out.println("link text"+link.getText());
			System.out.println("href text"+link.getAttribute("href"));
		}
		
		/*  List<WebElement> links = driver.findElements(By.xpath("//button[@class='btn btn-link dropdown-toggle']"));
		  links.size();
		  
		  for(WebElement l:links) {
			  System.out.println("currencyies" +l.getText());
			 
		  }*/
		 WebElement currencyButton = driver.findElement(By.cssSelector(".btn-group > .dropdown-toggle"));
	        currencyButton.click();

	        // Wait for the dropdown menu to be visible
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-menu")));

	        // Capture all the currency buttons within the dropdown
	        List<WebElement> currencyButtons = driver.findElements(By.cssSelector(".dropdown-menu .currency-select"));

	        // Iterate through each currency button and print its text
	        for (WebElement button : currencyButtons) {
	            System.out.println("Currency Name: " + button.getText());
	        }

	       List<WebElement>alllinks= driver.findElements(By.tagName("a"));
	       System.out.println(alllinks.size());
	       
	       List<WebElement>allimges=driver.findElements(By.tagName("img"));
	       System.out.println(allimges.size());
	       
	       
		if(actual_title.equals("Your Store")) 
		{
			System.out.println("title is valid");
		}
			else
			{
				System.out.println("title is not valid");
			}
		//it will close the window
		driver.quit();
		//driver.close();
	}

}
