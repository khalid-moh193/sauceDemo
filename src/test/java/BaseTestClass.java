import Web.Util.AppDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public abstract class BaseTestClass {
    public WebDriver driver;
    public SoftAssert softAssert;

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTestLog(String message) {
        return message;
    }

    @BeforeClass
    @Parameters("browser")
    void beforeClass(@Optional("Chrome") String browser) throws Exception {
        AppDriver testInit = new AppDriver();
        driver = testInit.SeleniumDriverSetup(browser);
    }

    @BeforeMethod
    void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("check that value : {0} equal to : {1} ")
    boolean doAssertEqual(Object Actual, Object Expected, String message) {
        softAssert.assertEquals(Actual, Expected, message);
        if (String.valueOf(Expected) != String.valueOf(Actual)) {
            saveScreenshotPNG();
            saveTestLog(message);
            return false;
        }

        return true;
    }

}
