import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.JobPage;
import pages.LoginPage;
import utils.ConfigProperties;

import static org.testng.Assert.*;


@Listeners({TestAllureListener.class})
public class JobTest extends BasicTest {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
    private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);

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
    public void JobCreationTest() {
        homePage.open();
        jobPage = homePage.createJob();
        assertEquals(jobPage.getJobName(), ConfigProperties.getProperties("job.finalname"));
        jobPage.deleteJob();
    }

    @Test(priority = 2)
    public void JobCreationNegativeTest()
    {
        homePage.open();
        jobPage = homePage.createJob();
        homePage.open();
        jobPage.failedCreationJob();
        assertTrue(jobPage.ErrorCreation());
        jobPage.open();
        jobPage.deleteJob();
    }

    @Test(priority = 2)
    public void AddDescriptionJob()  {
        homePage.open();
        jobPage = homePage.createJob();
        jobPage.updateJob();
        assertTrue(jobPage.isJobUpdate());
        jobPage.deleteJob();
    }

    @Test(priority = 3)
    public void RenameJobTest()  {
        homePage.open();
        jobPage = homePage.createJob();
        jobPage.renameJob();
        assertTrue(jobPage.isJobRename());
        jobPage.deleteJob();
    }

    @Test(priority = 4)
    public void DeleteJobTest()  {
        homePage.open();
        jobPage = homePage.createJob();
        jobPage.open();
        jobPage.deleteJob();
        assertFalse(jobPage.isJobDeleted());
    }
}
