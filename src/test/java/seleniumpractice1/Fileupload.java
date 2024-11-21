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
public class Fileupload {

	public static void main(String[] args) {
		
WebDriver driver=new ChromeDriver();
driver.get("https://practice.expandtesting.com/upload");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\himab\\OneDrive\\Desktop\\softwre manual testing\\day.txt");
WebElement upload=driver.findElement(By.xpath("//button[@type='submit']"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click()", upload);
//verfitying the uploade file success message
if(driver.findElement(By.xpath("//h1[normalize-space()='File Uploaded!']")).getText().equals("File Uploaded!")) {
	System.out.println("file uploaded sucessfully");
}
else {
	System.out.println("not uploaded sucessfully");
}

	}

}
