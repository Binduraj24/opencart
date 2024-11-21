package seleniumpractice1;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class practice2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		// Set implicit wait time
	

		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/");
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement>alllinks=driver.findElements(By.tagName("a"));
		System.out.println("total links are "+alllinks.size());
		List<WebElement>imges=driver.findElements(By.tagName("img"));
		System.out.println("total images present"+imges.size());


	     WebElement productLink = mywait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
	     System.out.println("Link text before click: " + productLink.getText());
	        productLink.click();
	        WebElement productName = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='name']"))); // Adjust the XPath as needed

	        // Print the product name from the product page
	        System.out.println("Product name on the product page: " + productName.getText());
	       //taking screenshot in selenium webdriver .
	        TakesScreenshot shot= (TakesScreenshot)driver;
			File sourcefile=shot.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage.png");
			sourcefile.renameTo(targetfile);
	        
		
		//System.out.println(productLink.getText());
		//System.out.println("hi");
		driver.quit();
		

	}

}
