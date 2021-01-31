
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import io.qameta.allure.*;

import entities.User;
import utils.ConfigProperties;

public class BasicTest {

    protected static WebDriver driver;


    public User admin = new User(ConfigProperties.getProperties("username"), ConfigProperties.getProperties("password"));

    protected WebDriver getWebDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperties(    "imp.wait")), TimeUnit.SECONDS);
        }
        return driver;
    }

//    @Attachment(value = "Failed test screenshot")
//    public byte[] attachScreenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }



    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}
