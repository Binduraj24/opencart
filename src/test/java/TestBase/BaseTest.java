package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static WebDriver driver;
    public org.apache.logging.log4j.Logger logger;
    public Properties p;
    
    @Parameters({"os", "browser"})
    @BeforeClass(groups = {"Register","login","DataDriven","Master"})
    public void setup(@Optional("Windows") String os, @Optional("chrome") String br) throws IOException { 
    	logger = LogManager.getLogger(this.getClass());
        // Load the configuration properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
        

        // Remote execution setup
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else {
                System.out.println("Invalid OS specified");
                return;
            }

            // Set browser capabilities
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                    break;
                case "edge":
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, "edge");
                    break;
                case "firefox":
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                    break;
                default:
                    System.out.println("Invalid browser specified");
                    return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

        // Local execution setup
        if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
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
                    System.out.println("Invalid browser specified");
                    return;
            }
        }

        // Common driver setup
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(p.getProperty("appURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphanumeric() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return generatedString + "@" + generatedNumber;
    }

    public String CaptureScreenshot(String tname) {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        try {
            FileUtils.copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return targetFilePath;
    }

    @AfterClass(groups = {"Register","login","DataDriven","Master"})
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
