package seleniumpractice1;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class opencart {
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/upload/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//input[contains(@placeholder='Sea')]")).sendKeys("Htc");
		//driver.findElement(By.xpath("//input[starts-with(@placeholder='Sea')]")).sendKeys("Htc");	
		boolean status=driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		String windowid=driver.getWindowHandle();
		Set<String> windowids=driver.getWindowHandles();
		System.out.println(windowids);
		System.out.println(windowid);
		
		
		
		driver.quit();
		
	}
}
