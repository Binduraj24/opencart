package seleniumpractice1;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class SelecDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='country']"));
		Select s=new Select(dropdown);
		s.selectByValue("germany");
		List<WebElement>options=s.getOptions();
		System.out.println(options.size());
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
			
		}
		
		
		
	}

}
