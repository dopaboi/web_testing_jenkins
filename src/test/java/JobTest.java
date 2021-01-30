import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.JobPage;
import pages.LoginPage;
import utils.ConfigProperties;

import static org.testng.Assert.*;

public class JobTest extends BasicTest {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
    private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);

    @Test
    public void JobCreationTest() throws Exception {
        homePage.open();
        jobPage = homePage.createJob();
        assertEquals(jobPage.getJobName(), ConfigProperties.getProperties("job.finalname"));
    }

    @Test
    public void AddDescriptionJob() throws Exception
    {
        jobPage.open();
        jobPage.updateJob();
        assertTrue(jobPage.isJobUpdate());
    }

    @Test
    public void DeleteJobTest() throws Exception {
    jobPage.open();
    jobPage.deleteJob();
    assertFalse(jobPage.isJobNotDeleted());
    }

}
