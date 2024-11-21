package seleniumpractice1;
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
public class Orangehrm {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> links=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(links.size());
		for(WebElement link:links) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
	WebElement searchbox=driver.findElement(By.id("small-searchterms"));
	System.out.println(searchbox.getAttribute("placeholder"));
		
	/*	WebElement click=driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']"));
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", click);
		
		  Set<String> windowHandles = driver.getWindowHandles();
		  //approach 1 through converting into list
	       /* List<String> windowList = new ArrayList<>(windowHandles);
	        
		String windowid1=windowList.get(0);
		String childwindowid2=windowList.get(1);
		driver.switchTo().window(childwindowid2);
		System.out.println(driver.getTitle());
		  //through for loop
		  for(String id:windowHandles) {
			 String title= driver.switchTo().window(id).getTitle();
			 if(title.equals("Human Resources Management Software | OrangeHRM")) {
				 driver.close();
				 break;
			 }
			  
		  }
	
		
	}*/
}
}
