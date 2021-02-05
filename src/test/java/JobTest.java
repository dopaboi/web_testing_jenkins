import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
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

    @Test
    public void JobCreationTest() throws Exception {
        homePage.open();
        jobPage = homePage.createJob();
        assertEquals(jobPage.getJobName(), ConfigProperties.getProperties("job.finalname"));
        jobPage.deleteJob();
    }

    @Test
    public void AddDescriptionJob() throws Exception {
        homePage.open();
        jobPage = homePage.createJob();
        jobPage.updateJob();
        assertTrue(jobPage.isJobUpdate());
        jobPage.deleteJob();
    }

    @Test
    public void RenameJobTest() throws Exception {
        homePage.open();
        jobPage = homePage.createJob();
        jobPage.renameJob();
        assertTrue(jobPage.isJobRename());
        jobPage.deleteJob();

    }

    @Test
    public void DeleteJobTest() throws Exception {
        homePage.open();
        jobPage = homePage.createJob();
        jobPage.open();
        jobPage.deleteJob();
        assertFalse(jobPage.isJobNotDeleted());
    }

}
