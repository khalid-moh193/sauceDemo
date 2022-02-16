package Web.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class AppDriver {
    WebDriver driver;

    public WebDriver SeleniumDriverSetup(String browser) throws Exception {
//         Check if parameter passed from web.xml is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--headless"); //You can un-comment it if you need to run in the headless mode
            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return driver;
        }

//        Check if parameter passed from web.xml is 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--headless"); //You can un-comment it if you need to run in the headless mode
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        }
//        Check if parameter passed from web.xml is 'safari'
        else if (browser.equalsIgnoreCase("safari")) {

//You must enable 'Allow Remote Automation' option in Safari's Develop menu to control Safari via WebDriver
            DriverManagerType safari = DriverManagerType.SAFARI;
            WebDriverManager.getInstance(safari).setup();
            driver = new SafariDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            return driver;
        } else {
            // If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
    }

}
