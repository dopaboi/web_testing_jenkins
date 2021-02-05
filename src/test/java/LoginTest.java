import static org.testng.Assert.assertTrue;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners({TestAllureListener.class})
public class LoginTest extends BasicTest {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);

    @Test
    public void loginTest() throws Exception{
        loginPage.open();
        loginPage.login(admin);
        assertTrue(loginPage.isLoggedOut());
        loginPage.logout();
        assertTrue(loginPage.isLoggedIn());
    }

    @Test
    public void loginTest_failed() throws Exception
    {
        loginPage.open();
        loginPage.failed_login();
        assertTrue(loginPage.isNotLoggedIn());
    }


}
