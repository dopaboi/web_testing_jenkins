import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginTest extends BasicTest {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);

    @Test
    public void loginTest() throws Exception{
        loginPage.open();
        loginPage.login(admin);
        assertTrue(loginPage.isLoggedIn());
        loginPage.logout();
        assertTrue(loginPage.isLoggedOut());
    }

}
