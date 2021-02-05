import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


import entities.User;
import utils.ConfigProperties;



public class BasicTest {

    protected static WebDriver driver;


    public User admin = new User(ConfigProperties.getProperties("username"), ConfigProperties.getProperties("password"));

    protected WebDriver getWebDriver() {

        if (driver == null) {
            //System.setProperty(ConfigProperties.getProperties("name.driver"), ConfigProperties.getProperties("path.driver"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperties(    "imp.wait")), TimeUnit.SECONDS);
        }
        return driver;
    }

    public String getScreenshot(String name) {
        File src = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String path = System.getProperty("user.dir") + "/screenshots/" + name + timeStamp + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }


    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}
