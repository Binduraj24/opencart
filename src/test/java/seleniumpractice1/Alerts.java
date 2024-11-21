package seleniumpractice1;
import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Alerts {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//h3[normalize-space()='JavaScript Alerts']
		String text=driver.findElement(By.xpath("//h3[normalize-space()='JavaScript Alerts']")).getText();
		System.out.println(text);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		WebElement alrt=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		alrt.click();
		Alert al=driver.switchTo().alert();
		al.sendKeys("hi");
		al.accept();
		String mesg=driver.findElement(By.xpath("//p[@id='result']")).getText();
		if(mesg.contains("h")) {
			System.out.println("sucessful alert");
		}
		else {
			System.out.println("no alerts");
		}
		
		
		
		

	}

}
