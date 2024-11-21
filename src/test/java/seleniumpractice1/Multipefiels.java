package seleniumpractice1;
import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Multipefiels {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practice.expandtesting.com/upload");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String file1="C:\\Users\\himab\\OneDrive\\Desktop\\softwre manual testing\\day.txt";
		String file2="C:\\Users\\himab\\OneDrive\\Desktop\\softwre manual testing\\Day2.txt";
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file1+"\n"+file2);
		WebElement upload=driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", upload);
		
	}

}
