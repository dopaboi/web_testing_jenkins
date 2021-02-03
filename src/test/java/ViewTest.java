import org.openqa.selenium.support.PageFactory;
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

    @Test
    public void CreateNewView() throws Exception
    {
        homePage.open();
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
        }
        viewJobPage = homePage.createNewView();
    }

    @Test
    public void AddDeskTest() throws Exception
    {
        viewJobPage.open();
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
            viewJobPage.open();
        }
        viewJobPage.AddDesk();
        assertTrue(viewJobPage.isAddedDesk());

    }


    @Test
    public void AddJobToView() throws Exception
    {
        viewJobPage.open();
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
            viewJobPage.open();
        }
        viewJobPage = homePage.createJobToView();
        assertEquals(jobPage.getJobName(), ConfigProperties.getProperties("job.finalname"));
    }
    @Test
    public void DeleteView() throws Exception
    {
        viewJobPage.open();
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
            viewJobPage.open();
        }
        viewJobPage.DeleteView();
        assertFalse(viewJobPage.isViewNotDeleted());

    }
}
