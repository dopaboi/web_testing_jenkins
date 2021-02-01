import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.JobPage;
import utils.ConfigProperties;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.*;

public class JobTest extends BasicTest {


    private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
    private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);

    @Test
    public void JobCreationTest() throws Exception {
        homePage.open();
        jobPage = homePage.createJob();
        assertEquals(jobPage.getJobName(), ConfigProperties.getProperties("job.finalname"));
        Allure.addAttachment("Failed to create job", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test
    public void AddDescriptionJob() throws Exception {
        jobPage.open();
        jobPage.updateJob();
        assertTrue(jobPage.isJobUpdate());
        Allure.addAttachment("Failed to add description", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test
    public void RenameJobTest() throws Exception {
        jobPage.open();
        jobPage.renameJob();
        assertTrue(jobPage.isJobRename());
        Allure.addAttachment("Failed to rename job", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test
    public void DeleteJobTest() throws Exception {
        jobPage.open();
        jobPage.deleteJob();
        assertFalse(jobPage.isJobNotDeleted());
        Allure.addAttachment("Failed to delete job", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
