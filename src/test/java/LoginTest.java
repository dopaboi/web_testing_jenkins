import static org.testng.Assert.assertTrue;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;

import java.io.ByteArrayInputStream;


public class LoginTest extends BasicTest {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);

    @Test
    public void loginTest() throws Exception{
        loginPage.open();
        loginPage.login(admin);
        assertTrue(loginPage.isLoggedIn());
        loginPage.logout();
        assertTrue(loginPage.isLoggedOut());
        Allure.addAttachment("Failed to login", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
