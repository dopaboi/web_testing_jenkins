import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.JobPage;
import pages.LoginPage;
import pages.ViewJobPage;
import utils.ConfigProperties;
import static org.testng.Assert.*;

@Listeners({TestAllureListener.class})

public class ViewTest extends BasicTest {

    private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
    private ViewJobPage viewJobPage = PageFactory.initElements(getWebDriver(), ViewJobPage.class);
    private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);
    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);

    @BeforeMethod
    public void loginIs()
    {
        homePage.open();
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
        }
    }

    @Test(priority = 1)
    public void CreateNewView()
    {
        homePage.open();
        viewJobPage = homePage.createNewView();
    }

    @Test(priority = 2)
    public void AddDeskTest()
    {
        viewJobPage.open();
        viewJobPage.AddDesk();
        assertTrue(viewJobPage.isAddedDesk());

    }

    @Test(priority = 3)
    public void AddJobToView() throws Exception
    {
        viewJobPage.open();
        viewJobPage = homePage.createJobToView();
        assertEquals(jobPage.getJobName(), ConfigProperties.getProperties("view.name.job"));
    }

    @Test(priority = 4)
    public void DeleteView()
    {
        viewJobPage.open();
        viewJobPage.DeleteView();
        assertFalse(viewJobPage.isViewDeleted());
    }

}
