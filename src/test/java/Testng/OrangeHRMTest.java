package Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMTest {
    WebDriver driver;
    WebDriverWait wait;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setUp(String br, String url) {
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser");
                return;
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
    }

    @Test
    public void testLoginAndLogout() {
        // Enter username and password
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        // Click the login button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Wait for the dashboard to be displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")));

        // Assert that the dashboard is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed(), "Login failed or dashboard not found");

        // Click the user dropdown to show the logout option
        WebElement userDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='oxd-userdropdown-name']")));
        userDropdown.click();

        // Wait for the logout button and click it
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='oxd-userdropdown-link' and normalize-space(text())='Logout']")));
        logoutButton.click();

        // Wait for the login page to reappear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
        Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Login']")).isDisplayed(), "Logout was not successful");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
